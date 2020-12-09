package com.minhquan.oubussystem;

import com.minhquan.HibernateServices.LoaiXeServices;
import com.minhquan.HibernateServices.TuyenDuongServices;
import com.minhquan.pojo.LoaiXe;
import com.minhquan.pojo.TuyenDuong;
import com.minhquan.pojo.XeKhach;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainAppController implements Initializable{

    @FXML
    private Pane paneTraCuuVe;

    @FXML
    private TextField txtTimHoTen;

    @FXML
    private TextField txtTimSdt;

    @FXML
    private Button buttonTimVe;

    @FXML
    private TableView<?> tableVe;

    @FXML
    private Button buttonHuyVe;

    @FXML
    private Pane paneThemChuyenDi;

    @FXML
    private TextField txtIDChuyenXe;

    @FXML
    private ComboBox<TuyenDuong> cbNoiDi;

    @FXML
    private ComboBox<TuyenDuong> cbNoiDen;

    @FXML
    private DatePicker dateTimeChuyenMoi;

    @FXML
    private ComboBox<LoaiXe> cbLoaiXe;

    @FXML
    private TextField txtXe;

    @FXML
    private TextField txtDonGia;

    @FXML
    private Button buttonThemChuyenMoi;

    @FXML
    private Button buttonHoanTac;

    @FXML
    private Pane paneTraCuuChuyenDi;

    @FXML
    private Button buttonTimChuyen;

    @FXML
    private TextField txtNoiXuatPhat;

    @FXML
    private TextField txtNoiDen;

    @FXML
    private Button buttonHuyChuyen;

    @FXML
    private TableView<?> tableChuyenDi;

    @FXML
    private Pane paneDatVe;

    @FXML
    private TextField txtHoTen;

    @FXML
    private TextField txtSdt;

    @FXML
    private DatePicker dateNgayDi;

    @FXML
    private Pane paneGhe;

    @FXML
    private Button btGhe1;

    @FXML
    private Button btGhe5;

    @FXML
    private Button btGhe9;

    @FXML
    private Button btGhe13;

    @FXML
    private Button btGhe17;

    @FXML
    private Button btGhe21;

    @FXML
    private Button btGhe25;

    @FXML
    private Button btGhe29;

    @FXML
    private Button btGhe33;

    @FXML
    private Button btGhe37;

    @FXML
    private Button btGhe41;

    @FXML
    private Button btGhe45;

    @FXML
    private Button btGhe2;

    @FXML
    private Button btGhe6;

    @FXML
    private Button btGhe10;

    @FXML
    private Button btGhe14;

    @FXML
    private Button btGhe18;

    @FXML
    private Button btGhe22;

    @FXML
    private Button btGhe26;

    @FXML
    private Button btGhe30;

    @FXML
    private Button btGhe34;

    @FXML
    private Button btGhe38;

    @FXML
    private Button btGhe42;

    @FXML
    private Button btGhe3;

    @FXML
    private Button btGhe7;

    @FXML
    private Button btGhe11;

    @FXML
    private Button btGhe15;

    @FXML
    private Button btGhe19;

    @FXML
    private Button btGhe23;

    @FXML
    private Button btGhe27;

    @FXML
    private Button btGhe31;

    @FXML
    private Button btGhe35;

    @FXML
    private Button btGhe39;

    @FXML
    private Button btGhe43;

    @FXML
    private Button btGhe4;

    @FXML
    private Button btGhe8;

    @FXML
    private Button btGhe12;

    @FXML
    private Button btGhe16;

    @FXML
    private Button btGhe20;

    @FXML
    private Button btGhe24;

    @FXML
    private Button btGhe28;

    @FXML
    private Button btGhe32;

    @FXML
    private Button btGhe36;

    @FXML
    private Button btGhe40;

    @FXML
    private Button btGhe44;

    @FXML
    private TextField txtSoGhe;

    @FXML
    private Button buttonDatVe;

    @FXML
    private Button buttonHuyGiaoDich;

    @FXML
    private ComboBox<XeKhach> cbXe;

    @FXML
    private Button btnDatVe;

    @FXML
    private Button btnTraCuuVe;

    @FXML
    private Button btnThemChuyenDi;

    @FXML
    private Button btnTraCuuChuyenDi;
    
    @FXML
    private VBox vbDatVe;
    
    
    @FXML
    void clickButton(ActionEvent event) {
         if (event.getSource() == btnDatVe){
            paneDatVe.toFront();
        }
        if (event.getSource() == btnThemChuyenDi){
            paneThemChuyenDi.toFront();
        }
        if (event.getSource() == btnTraCuuVe){
            paneTraCuuVe.toFront();
        }
        if (event.getSource() == btnTraCuuChuyenDi){
            paneTraCuuChuyenDi.toFront();
        }
    }
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb){
       this.txtHoTen.prefWidthProperty().bind(this.vbDatVe.widthProperty());
       this.txtSdt.prefWidthProperty().bind(this.vbDatVe.widthProperty());
       this.cbLoaiXe.prefWidthProperty().bind(this.vbDatVe.widthProperty());
       this.cbNoiDi.prefHeightProperty().bind(this.vbDatVe.widthProperty());
       this.cbNoiDen.prefHeightProperty().bind(this.vbDatVe.widthProperty());
       this.dateNgayDi.prefHeightProperty().bind(this.vbDatVe.widthProperty());
       this.cbXe.prefHeightProperty().bind(this.vbDatVe.widthProperty());
       this.txtSoGhe.prefWidthProperty().bind(this.vbDatVe.widthProperty());
       
       this.cbLoaiXe.getItems().addAll(LoaiXeServices.getLoaiXe());
       this.cbNoiDi.getItems().addAll(TuyenDuongServices.getTuyenDuong());
      
    }
    
    public void bookTicket(ActionEvent e){
        
    }
    

    public void resetAction(ActionEvent e){
        this.txtHoTen.setText("");
        this.txtSdt.setText("");
        this.cbLoaiXe.setValue(null);
        this.cbNoiDi.setValue(null);
        this.cbNoiDen.setValue(null);
        this.dateNgayDi.setValue(null);
        this.cbXe.setValue(null);
        this.txtSoGhe.setText("");
    }
    
//    private void loadLoaiXeToApp(){
//        
//        
//    }
//    
//    private void loadXeToApp(){
//        
//    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}