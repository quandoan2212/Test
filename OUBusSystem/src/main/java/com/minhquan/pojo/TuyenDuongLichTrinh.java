/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.pojo;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Amin
 */

@Entity
@Table(name = "tuyenduong_lichtrinh")
public class TuyenDuongLichTrinh implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtuyenduong_lichtrinh")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaXe")
    private XeKhach xe;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaLichTrinh")
    private LichTrinhChuyenDi lichTrinh;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTuyenDuong")
    private TuyenDuong tuyenDuong;

    @OneToMany(mappedBy = "tuyenLich")
    private Set<Ticket> ticket;
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
     * @return the maXe
     */
    public XeKhach getXe() {
        return xe;
    }

    /**
     * @param maXe the maXe to set
     */
    public void setXe(XeKhach maXe) {
        this.xe = maXe;
    }

    /**
     * @return the maLichTrinh
     */
    public LichTrinhChuyenDi getLichTrinh() {
        return lichTrinh;
    }

    /**
     * @param maLichTrinh the maLichTrinh to set
     */
    public void setLichTrinh(LichTrinhChuyenDi maLichTrinh) {
        this.lichTrinh = maLichTrinh;
    }

    /**
     * @return the maTuyenDuong
     */
    public TuyenDuong getTuyenDuong() {
        return tuyenDuong;
    }

    /**
     * @param maTuyenDuong the maTuyenDuong to set
     */
    public void setTuyenDuong(TuyenDuong maTuyenDuong) {
        this.tuyenDuong = maTuyenDuong;
    }

    /**
     * @return the ticket
     */
    public Set<Ticket> getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Set<Ticket> ticket) {
        this.ticket = ticket;
    }
}
