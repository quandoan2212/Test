/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Amin
 */
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable{
     @Id
   @Column(name = "idticket")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @JoinColumn(name = "MaNV")
   @ManyToOne(fetch = FetchType.EAGER)
   private NhanVien nhanVien;
   
   @JoinColumn(name = "LichTrinh_TuyenDuong")
   @ManyToOne(fetch =FetchType.EAGER)
   private TuyenDuongLichTrinh tuyenLich;
   
   @JoinColumn(name = "MaKH")
   @ManyToOne(fetch = FetchType.EAGER)
   private KhachHang khachHang;
   
   @Column(name = "printedDate")
   private GregorianCalendar ngayInVe;
   
   @Column(name = "MaGhe")
   private String maGhe;
   
   @Column(name = "ngayDi")
   private Date ngayKH;
   

   public Ticket(){
       
   }
   public Ticket(int id, NhanVien nhanVien, TuyenDuongLichTrinh tuyenLich, KhachHang khachHang, GregorianCalendar ngayInVe,String maGhe) {
        this.id = id;
        this.nhanVien = nhanVien;
        this.tuyenLich = tuyenLich;
        this.khachHang = khachHang;
        this.ngayInVe = ngayInVe;
        this.maGhe = maGhe;
    }
   
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nhanVien
     */
    public NhanVien getNhanVien() {
        return nhanVien;
    }

    /**
     * @param nhanVien the nhanVien to set
     */
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    /**
     * @return the tuyenLich
     */
    public TuyenDuongLichTrinh getTuyenLich() {
        return tuyenLich;
    }

    /**
     * @param tuyenLich the tuyenLich to set
     */
    public void setTuyenLich(TuyenDuongLichTrinh tuyenLich) {
        this.tuyenLich = tuyenLich;
    }

    /**
     * @return the khachHang
     */
    public KhachHang getKhachHang() {
        return khachHang;
    }

    /**
     * @param khachHang the khachHang to set
     */
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    /**
     * @return the ngayInVe
     */
    public GregorianCalendar getNgayInVe() {
        return ngayInVe;
    }

    /**
     * @param ngayInVe the ngayInVe to set
     */
    public void setNgayInVe(GregorianCalendar ngayInVe) {
        this.ngayInVe = ngayInVe;
    }

    /**
     * @return the maGhe
     */
    public String getMaGhe() {
        return maGhe;
    }

    /**
     * @param maGhe the maGhe to set
     */
    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    /**
     * @return the ngayKH
     */
    public Date getNgayKH() {
        return ngayKH;
    }

    /**
     * @param ngayKH the ngayKH to set
     */
    public void setNgayKH(Date ngayKH) {
        this.ngayKH = ngayKH;
    }
}
