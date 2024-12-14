package com.namkks.appbansach123.view;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.namkks.appbansach123.R;
import com.namkks.appbansach123.adapter.ListChiTietHoaDonAdapter;
import com.namkks.appbansach123.models.ChiTietHoaDon;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChiTietHoaDonActivity extends AppCompatActivity {
    TextView id_donhang, soLDonHang,tongTienDonHang,hoTenKH,sdtKH,diaChiKH, TongTienCTDH, ngaymua;
    RecyclerView recycleViewCTDH;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet_hoa_don);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AnhXa();
        ActionBar();
        LoadData();
    }
    @SuppressLint("RestrictedApi")
    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void AnhXa(){
        id_donhang = findViewById(R.id.id_donhang);
        soLDonHang = findViewById(R.id.soLDonHang);
        tongTienDonHang = findViewById(R.id.tongTienDonHang);
        hoTenKH = findViewById(R.id.hoTenKH);
        sdtKH = findViewById(R.id.sdtKH);
        diaChiKH = findViewById(R.id.diaChiKH);
        TongTienCTDH = findViewById(R.id.TongTienCTDH);
        recycleViewCTDH = findViewById(R.id.recycleViewCTDH);
        toolbar = findViewById(R.id.toolbarTK);
        ngaymua = findViewById(R.id.ngaymua);
    }
    private void LoadData(){
        int iddh = getIntent().getIntExtra("iddh", 0);
        ArrayList<ChiTietHoaDon> ctdh = ChiTietHoaDon.getChiTietHoaDon(iddh);
        id_donhang.setText("#" + iddh);
        ngaymua.setText(ChiTietHoaDon.getNgayLap(iddh));
        soLDonHang.setText(ChiTietHoaDon.getSoLuong(iddh)+" sản phẩm");
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        String tienvnd = formatter.format(ChiTietHoaDon.getTongTien(iddh)) + " đ";
        tongTienDonHang.setText(tienvnd);
        hoTenKH.setText(LoginActivity.kh.getHoTen());
        sdtKH.setText(LoginActivity.kh.getSdt());
        diaChiKH.setText(LoginActivity.kh.getDiaChi());
        String tongtien = "Tổng tiền: " + tienvnd;
        SpannableString spannableString = new SpannableString(tongtien);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 11, tongtien.length(), 0);
        TongTienCTDH.setText(spannableString);

        ListChiTietHoaDonAdapter listChiTietDonHangAdapter = new ListChiTietHoaDonAdapter
                (ctdh, this);
        recycleViewCTDH.setLayoutManager(new LinearLayoutManager(this));
        recycleViewCTDH.setAdapter(listChiTietDonHangAdapter);
    }
}