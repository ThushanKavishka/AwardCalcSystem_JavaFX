package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;

public class HomeController{
	
	
	
	@FXML
	private Button btn03;
	@FXML
	private Button btn04;
	@FXML
	private Button btn05;
	@FXML
	private Button btn06;
	@FXML
	private Button btn07;
	@FXML
	private Label Hometxt;


	/*Event Listener on Button[#btn03].onAction
	 	Open the Registration window*/
		public void Registration(ActionEvent event)throws Exception{
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/R01.fxml"));
		Stage primaryStage2 = new Stage();
		primaryStage2.setTitle("University of GUGSI/Home/Registration");
		Scene scene = new Scene(root2);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.show();
		primaryStage2.setResizable(false);
		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
	}
	/* Event Listener on Button[#btn07].onAction
		Close the Home Window*/
			@FXML
			public void CloseApp2(ActionEvent event) {
				Stage stage = (Stage) btn07.getScene().getWindow();
			    stage.close();
			}
			//Open the Update login window
			public  void Update(ActionEvent event) throws IOException {
					
					Parent root4 = FXMLLoader.load(getClass().getResource("/application/UpdateLogin.fxml"));
					Stage primaryStage4 = new Stage();
					primaryStage4.setTitle("University of GUGSI/Home/Update");
					Scene scene = new Scene(root4);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage4.setScene(scene);
					primaryStage4.show();
					primaryStage4.setResizable(false);
					
				
		}
			//Open the CheckInfo window
		public void CheckInfo (ActionEvent event) throws IOException{
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/CheckInfo.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			primaryStage4.setResizable(false);
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
		}	
		//Open the Award window	
		public void Award (ActionEvent event) throws IOException{
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/Award.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			primaryStage4.setResizable(false);	
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
	}

}