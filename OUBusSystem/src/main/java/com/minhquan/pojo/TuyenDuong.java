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
@Table(name = "tuyenduong")
public class TuyenDuong implements Serializable{
    @Id
    @Column(name = "matuyenduong")
    private String maTuyenDuong;
    
    @Column(name = "Departure")
    private String departure;
    
    @Column(name = "Location")
    private String location;
    
    @Column(name = "Length")
    private float length;
    
    @Column(name = "Time")
    private Time time;
    
    @OneToMany(mappedBy = "tuyenDuong")
    private Set<TuyenDuongLichTrinh> tdlt;

    @Override
    public String toString() {
        return this.maTuyenDuong; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    /**
     * @return the maTuyenDuong
     */
    public String getMaTuyenDuong() {
        return maTuyenDuong;
    }

    /**
     * @param maTuyenDuong the maTuyenDuong to set
     */
    public void setMaTuyenDuong(String maTuyenDuong) {
        this.maTuyenDuong = maTuyenDuong;
    }

    /**
     * @return the departure
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the length
     */
    public float getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(float length) {
        this.length = length;
    }

    /**
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Time time) {
        this.time = time;
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
