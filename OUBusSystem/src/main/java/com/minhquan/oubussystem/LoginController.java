package com.minhquan.oubussystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

   @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private AnchorPane btnSignin;

    @FXML
    private Label label1;

    @FXML
    private TextField inputName;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    void btnSignInActionPerformed(ActionEvent event) {
        String username = inputName.getText();
        String password = inputPassword.getText();
        
        if(event.getSource() == btnSignIn){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            
            if(inputName.getText().equals("")){          
                a.setHeaderText("Vui lòng điền Username!");      
                a.show();
            }
            else if(inputPassword.getText().equals("")){          
                a.setHeaderText("Vui lòng điền Password!");  
                a.show();
            }
        }
    }
}
