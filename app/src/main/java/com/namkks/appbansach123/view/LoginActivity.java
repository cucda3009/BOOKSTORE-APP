package com.namkks.appbansach123.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.namkks.appbansach123.R;
import com.namkks.appbansach123.models.KhachHang;
import com.namkks.appbansach123.models.NhanVien;

public class LoginActivity extends AppCompatActivity {
    public static KhachHang kh;
    public static NhanVien nv;
    LinearLayout trangChuLayout, thongBaoLayout, cartLayout, choThanhToanBtn, hoanTatBtn;
    TextView loginTxt, registerTxt, tenKhtxt, tenNVtxt, themSachLayout,
    suaSachLayout, xoaSachLayout, qldonhangLayout, tkDXBtn, nvDXBtn,
    profile, soLDonHang, soLHoaDon;
    ViewFlipper viewFlipperLogin;
    boolean isLoginForm;
    EditText sdtDNtxt, mkDNtxt, hoTenDKtxt, sdtDKtxt, passDKtxt, diaChiDKtxt;
    LinearLayout loreform, tk_profile, tk_NVprofile;
    Button dnBtn, dkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AnhXa();
        ShowProFile();
        ShowNVProfile();
        FlipForm();
        dnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangNhap();
            }
        });
        DangKy();
        ChuyenCartLayOut();
        ChuyenTCLayOut();
        ChuyenThemSachLayout();
        ChuyenSuaSachLayout();
        ChuyenChoThanhToanLayout();
        ChuyenQLDonHangLayout();
        ChuyenHoanTatLayout();
        ChuyenProfile();
        DangXuat();
    }

    private void AnhXa(){
        loginTxt = findViewById(R.id.loginTxt);
        registerTxt = findViewById(R.id.registerTxt);
        viewFlipperLogin = findViewById(R.id.viewflipperlogin);
        isLoginForm = true;
        sdtDNtxt = findViewById(R.id.sdtDNtxt);
        mkDNtxt = findViewById(R.id.mkDNtxt);
        loreform = findViewById(R.id.loreform);
        tk_profile = findViewById(R.id.tk_profile);
        tenKhtxt = findViewById(R.id.tenKHtxt);
        dnBtn = findViewById(R.id.dnBtn);
        hoTenDKtxt = findViewById(R.id.hoTenDKtxt);
        sdtDKtxt = findViewById(R.id.sdtDKtxt);
        passDKtxt = findViewById(R.id.passDKtxt);
        diaChiDKtxt = findViewById(R.id.diaChiDKtxt);
        dkBtn = findViewById(R.id.dkBtn);
        trangChuLayout = findViewById(R.id.trangChuLayout);
        thongBaoLayout = findViewById(R.id.thongBaoLayout);
        cartLayout = findViewById(R.id.cartLayout);
        tk_NVprofile = findViewById(R.id.tk_NVprofile);
        tenNVtxt = findViewById(R.id.tenNVtxt);
        themSachLayout = findViewById(R.id.themSachLayout);
        suaSachLayout = findViewById(R.id.suaSachLayout);
        xoaSachLayout = findViewById(R.id.xoaSachLayout);
        choThanhToanBtn = findViewById(R.id.choThanhToanBtn);
        qldonhangLayout = findViewById(R.id.qldonhangLayout);
        tkDXBtn = findViewById(R.id.tkDXBtn);
        nvDXBtn = findViewById(R.id.nvDXBtn);
        hoanTatBtn = findViewById(R.id.hoanTatBtn);
        profile = findViewById(R.id.profileTxt);
        soLDonHang = findViewById(R.id.soLDonHang);
        soLHoaDon = findViewById(R.id.soLHoaDon);
    }
    public void ChuyenProfile(){
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
    public void ChuyenSuaSachLayout(){
        suaSachLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ListSachSuaXoaActivity.class);
                startActivity(intent);
            }
        });
        xoaSachLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ListSachSuaXoaActivity.class);
                startActivity(intent);
            }
        });
    }
    public void DangXuat(){
        tkDXBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("Xác nhận")
                        .setMessage("Bạn có chắc muốn đăng xuất không?")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                LoginActivity.kh = null;
                                Toast.makeText(LoginActivity.this, "Đã đăng xuất!", Toast.LENGTH_SHORT).show();
                                recreate();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
        nvDXBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("Xác nhận")
                        .setMessage("Bạn có chắc muốn đăng xuất không?")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                LoginActivity.nv = null;
                                Toast.makeText(LoginActivity.this, "Đã đăng xuất!", Toast.LENGTH_SHORT).show();
                                recreate();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
    }
    public void ChuyenChoThanhToanLayout(){
        choThanhToanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, DonHangActivity.class);
                startActivity(intent);
            }
        });
    }
    public void ChuyenHoanTatLayout(){
        hoanTatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HoaDonActivity.class);
                startActivity(intent);
            }
        });
    }
    public void ChuyenQLDonHangLayout(){
        qldonhangLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, QuanLyDonHangActivity.class);
                startActivity(intent);
            }
        });
    }
    public void ChuyenThemSachLayout(){
        themSachLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ThemSachActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ChuyenCartLayOut(){
        cartLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });
    }
    public void ChuyenTCLayOut(){
        trangChuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void DangNhap(){
        NhanVien nv1 = new NhanVien();
        nv1.setSdt(sdtDNtxt.getText().toString());
        nv1.setPass(mkDNtxt.getText().toString());
        if(nv1.KiemTraDN() > 0){
            nv = NhanVien.getNhanVien(nv1.KiemTraDN());
            ShowNVProfile();
        }else{
            KhachHang kh1 = new KhachHang();
            kh1.setSdt(sdtDNtxt.getText().toString());
            kh1.setPass(mkDNtxt.getText().toString());
                                                                                                
            if(kh1.KiemTraDN() > 0 ){
                LoginActivity.kh = KhachHang.getKH(kh1.KiemTraDN());
                ShowProFile();
            }else{
                Toast.makeText(this, "Thông tin tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
            }
        }

    }
    private void DangKy(){
        dkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachHang kh = new KhachHang();
                kh.setHoTen(hoTenDKtxt.getText().toString());
                kh.setSdt(sdtDKtxt.getText().toString());
                kh.setPass(passDKtxt.getText().toString());
                kh.setDiaChi(diaChiDKtxt.getText().toString());
                if(kh.AddKhachHang()){
                    Toast.makeText(LoginActivity.this, "Đăng ký thành công!\nVui lòng đăng nhập.",Toast.LENGTH_SHORT).show();
                    viewFlipperLogin.showNext();
                    isLoginForm = true;
                }else{
                    Toast.makeText(LoginActivity.this, "Số điện thoại này đã được đăng ký!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void ShowProFile(){
        if(LoginActivity.kh != null){
            loreform.setVisibility(View.GONE);
            tk_profile.setVisibility(View.VISIBLE);
            tenKhtxt.setText(LoginActivity.kh.getHoTen());
            int soLDH = LoginActivity.kh.getSoLDonHang();
            int soLHD = LoginActivity.kh.getSoLHoaDon();
            if(soLDH > 0){
                soLDonHang.setText("" + soLDH);
            }else{
                soLDonHang.setVisibility(View.GONE);
            }
            if(soLHD > 0){
                soLHoaDon.setText("" + soLHD);
            }else{
                soLHoaDon.setVisibility(View.GONE);
            }
        }
    }
    private void ShowNVProfile(){
        if(nv != null){
            loreform.setVisibility(View.GONE);
            tk_NVprofile.setVisibility(View.VISIBLE);
            tenNVtxt.setText(nv.getHoTen());
        }
    }
    private void FlipForm(){
        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLoginForm){
                    isLoginForm = !isLoginForm;
                    viewFlipperLogin.showNext();
                    loginTxt.setTextColor(Color.parseColor("#ff9933"));
                    registerTxt.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLoginForm){
                    isLoginForm = !isLoginForm;
                    viewFlipperLogin.showNext();
                    loginTxt.setTextColor(Color.parseColor("#000000"));
                    registerTxt.setTextColor(Color.parseColor("#ff9933"));
                }
            }
        });
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.login_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.register_in_left);
        viewFlipperLogin.setInAnimation(slide_in);
        viewFlipperLogin.setOutAnimation(slide_out);
    }
}