package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController  {
	@FXML
	private Label AWD;
	@FXML
	private Button btn02;
	@FXML
	private Button btn01;
	@FXML
	private Label Username;
	@FXML
	private Label Password;
	@FXML
	private Label Login;
	@FXML
	private TextField Usertxt;
	@FXML
	private PasswordField Passtxt;
	@FXML
	private Label Message01;

	/* Event Listener on Button[#btn02].onAction
	 	Close the login window*/
	@FXML
	public void CloseApp(ActionEvent event) {
		System.exit(0);
		
	}
	/* Event Listener on Button[#btn01].onAction
	 Open the Home window 
	 */
	@FXML
	public void Login(ActionEvent event)throws Exception  {
		if(Usertxt.getText().equals("")&& Passtxt.getText().equals("")) {
			Message01.setText("Login Success");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
			primaryStage.setTitle("University of GUGSI/Home");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
			
			
		}else{
			Message01.setText("UserName or Password Incorrect");
		}
	
	
	}
}