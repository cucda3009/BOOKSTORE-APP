package com.namkks.appbansach123.models;

import com.namkks.appbansach123.controller.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHang {
    private int id;
    private String hoTen;
    private String sdt;
    private String pass;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(int id, String hoTen, String sdt, String pass, String diaChi) {
        this.id = id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.pass = pass;
        this.diaChi = diaChi;
    }

    public boolean AddKhachHang(){
        try {
            if (KiemTraTT(this.sdt) || NhanVien.KiemtraTT(this.sdt))
                return false;
            DAO a = new DAO();
            PreparedStatement stm = a.conn.prepareStatement("INSERT INTO `khachhang`(`HoTen`, `SDT`, `Pass`, `DiaChi`) " +
                    "VALUES (?, ?, ?, ?)");
            stm.setString(1, this.hoTen);
            stm.setString(2, this.sdt);
            stm.setString(3, this.pass);
            stm.setString(4, this.diaChi);

            return stm.executeUpdate() > 0;
        }catch (SQLException e){
            return false;
        }
    }

    public int KiemTraDN(){
        try {
            DAO a = new DAO();
            PreparedStatement stm = a.conn.prepareStatement("SELECT `id` FROM `khachhang` WHERE SDT = ? and Pass = ?");
            stm.setString(1, this.sdt);
            stm.setString(2, this.pass);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            return 0;
        }
    }
    public boolean KiemTraTT(String sdt){
        try {
            DAO a = new DAO();
            PreparedStatement stm = a.conn.prepareStatement("SELECT `id` FROM `khachhang` WHERE SDT = ?");
            stm.setString(1, this.sdt);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }catch (SQLException e){
            return false;
        }
    }
    public int getSoLDonHang(){
        try {
            DAO a = new DAO();
            PreparedStatement stm = a.conn.prepareStatement("SELECT COUNT(id) FROM `donhang` WHERE id_khachhang = ?");
            stm.setInt(1, this.id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            return 0;
        }
    }
    public int getSoLHoaDon(){
        try {
            DAO a = new DAO();
            PreparedStatement stm = a.conn.prepareStatement("SELECT COUNT(id) FROM `hoadon` WHERE id_khachhang = ?");
            stm.setInt(1, this.id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            return 0;
        }
    }
    public static KhachHang getKH(int id){
        try {
            DAO a = new DAO();
            PreparedStatement stm = a.conn.prepareStatement("SELECT * FROM `khachhang` WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            KhachHang kh = new KhachHang();
            kh.setId(rs.getInt(1));
            kh.setHoTen(rs.getString(2));
            kh.setSdt(rs.getString(3));
            kh.setPass(rs.getString(4));
            kh.setDiaChi(rs.getString(5));

            return kh;
        }catch (SQLException e){
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
