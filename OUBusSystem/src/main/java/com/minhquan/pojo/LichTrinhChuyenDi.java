/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhquan.pojo;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name = "lichtrinhchuyendi")
public class LichTrinhChuyenDi implements Serializable{
    @Id
    @Column(name = "malichtrinh")
    private String maLichTrinh;
    
    @Column(name = "TimeDepart")
    private Time timeDepart;
   
    
    @OneToMany(mappedBy = "lichTrinh")
    private Set<TuyenDuongLichTrinh> tdlt;

    @Override
    public String toString() {
        return this.maLichTrinh; //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * @return the maLichTrinh
     */
    public String getMaLichTrinh() {
        return maLichTrinh;
    }

    /**
     * @param maLichTrinh the maLichTrinh to set
     */
    public void setMaLichTrinh(String maLichTrinh) {
        this.maLichTrinh = maLichTrinh;
    }

    /**
     * @return the timeDepart
     */
    public Time getTimeDepart() {
        return timeDepart;
    }

    /**
     * @param timeDepart the timeDepart to set
     */
    public void setTimeDepart(Time timeDepart) {
        this.timeDepart = timeDepart;
    }


    /**
     * @return the tdlt
     */
    public Set<TuyenDuongLichTrinh> getTdlt() {
        return tdlt;
    }

    /**
     * @param tdlt the tdlt to set
     */
    public void setTdlt(Set<TuyenDuongLichTrinh> tdlt) {
        this.tdlt = tdlt;
    }
}
