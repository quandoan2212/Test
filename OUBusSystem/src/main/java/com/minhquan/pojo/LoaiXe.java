/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.pojo;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Amin
 */
@Entity
@Table(name = "loaixe")
public class LoaiXe {
     @Id
    @Column(name = "MaLoaiXe")
    private String maLoaiXe;
    
    @Column(name = "TenLoai")
    private String tenLoai;
    
    @Column(name = "GiaTien")
    private int giaTien;
    
    @OneToMany(mappedBy = "loaiXe")
    private Set<XeKhach> xekhachs;

    @Override
    public String toString() {
       return this.getTenLoai(); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public LoaiXe(){
//        
//    }
//    
//    public LoaiXe(String maLoaiXe, String tenLoai, int giaTien){
//        this.maLoaiXe = maLoaiXe;
//        this.tenLoai = tenLoai;
//        this.giaTien = giaTien;
//    }


    /**
     * @return the maLoaiXe
     */
    public String getMaLoaiXe() {
        return maLoaiXe;
    }

    /**
     * @param maLoaiXe the maLoaiXe to set
     */
    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    /**
     * @return the tenLoai
     */
    public String getTenLoai() {
        return tenLoai;
    }

    /**
     * @param tenLoai the tenLoai to set
     */
    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    /**
     * @return the giaTien
     */
    public int getGiaTien() {
        return giaTien;
    }

    /**
     * @param giaTien the giaTien to set
     */
    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    /**
     * @return the xekhachs
     */
    public Set<XeKhach> getXekhach() {
        return xekhachs;
    }

    /**
     * @param xekhach the xekhachs to set
     */
    public void setXekhach(Set<XeKhach> xekhach) {
        this.xekhachs = xekhach;
    }
}
