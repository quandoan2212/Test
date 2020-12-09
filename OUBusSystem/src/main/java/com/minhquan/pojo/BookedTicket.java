/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.pojo;

import java.io.Serializable;
import java.sql.Date;
//import java.util.GregorianCalendar;
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
@Table(name = "bookedticket")
public class BookedTicket implements Serializable{
    @Id
    @Column(name = "idbookedticket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @JoinColumn(name = "idtd_lt")
    @ManyToOne(fetch = FetchType.EAGER)
    private TuyenDuongLichTrinh tuyenLich;
    
    @JoinColumn(name = "idkhachhang")
    @ManyToOne(fetch = FetchType.EAGER)
    private KhachHang khachHang;
    
    @JoinColumn(name = "idnhanvien")
    @ManyToOne(fetch = FetchType.EAGER)
    private NhanVien nhanVien;
    
    @Column(name = "MaGhe")
    private String maGhe;
    
    @Column(name = "isGet")
    private boolean isGet;
    
    @Column(name = "ngayDi")
    private Date ngayKhoiHanh;
    
    @Column(name = "isCancel",nullable = true)
    private boolean isCancel;
    
    public BookedTicket(){
        
    }

    {
        this.isGet = false;
        this.isCancel = false;
    }
    
    public BookedTicket(TuyenDuongLichTrinh tuyenLich, KhachHang khachHang, NhanVien nhanVien, String maGhe,Date ngayDi) {
        this.tuyenLich = tuyenLich;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maGhe = maGhe;
        this.ngayKhoiHanh = ngayDi;
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
     * @return the isGet
     */
    public boolean isIsGet() {
        return isGet;
    }

    /**
     * @param isGet the isGet to set
     */
    public void setIsGet(boolean isGet) {
        this.isGet = isGet;
    }
    
    /**
     * @return the ngayKhoiHanh
     */
    public Date getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    /**
     * @param ngayKhoiHanh the ngayKhoiHanh to set
     */
    public void setNgayKhoiHanh(Date ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    /**
     * @return the isCancel
     */
    public boolean isIsCancel() {
        return isCancel;
    }

    /**
     * @param isCancel the isCancel to set
     */
    public void setIsCancel(boolean isCancel) {
        this.isCancel = isCancel;
    }
}
