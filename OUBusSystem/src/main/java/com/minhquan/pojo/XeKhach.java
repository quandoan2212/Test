/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Amin
 */
@Entity
@Table(name = "xekhach")
public class XeKhach implements Serializable{
     @Id
    @Column(name = "BienSoXe")
    private String bienSoXe;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaLoaiXe")
    private LoaiXe loaiXe;

    @Override
    public String toString() {
        return this.bienSoXe; //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * @return the bienSoXe
     */
    public String getBienSoXe() {
        return bienSoXe;
    }

    /**
     * @param bienSoXe the bienSoXe to set
     */
    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the loaiXe
     */
    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    /**
     * @param loaiXe the loaiXe to set
     */
    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }
}
