package application;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.application.Application;
import javafx.scene.Group;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class R01Controller {

	@FXML
	private Label Index;
	@FXML
	private Label Level;
	@FXML
	private Button btn09;
	@FXML
	private TextField Indextxt;
	@FXML
	private TextField Leveltxt;
	@FXML
	private Button btn08;

	/* Event Listener on Button[#btn09].onAction
	 	Close the Registration window*/
	@FXML
	public void CloseApp3(ActionEvent event) {
		Stage stage = (Stage) btn09.getScene().getWindow();
		stage.close();
		stage.setResizable(false);
	}

	@FXML
	public void OpenApp1(ActionEvent event) throws Exception {
		//Declaring student variable
		String student="";

		for (int row = 0; row < 5; row++){
			
			if(student.equalsIgnoreCase(""))
			{
				//Receive the Student Number 
				Main.studendDb[row][0] = Indextxt.getText();
				Main.studendDb[row][1] = "Level 4";
				//System.out.println("New Student");
				//System.out.println(Main.studendDb[row][0]);
				break;
			}

		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Registration");
		alert.setHeaderText(null);
		alert.setContentText("STUDENT HAS BEEN REGISTERED");

		alert.showAndWait();
		
		
		//Open the Home window
		Stage primaryStage3 = new Stage();
		primaryStage3.setTitle("University of GUGSI/Home");
		Parent root3 = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
		Scene scene = new Scene(root3);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage3.setScene(scene);
		primaryStage3.show();
		primaryStage3.setResizable(false);
		

	}

}
