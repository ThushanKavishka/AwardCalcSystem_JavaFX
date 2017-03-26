package application;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class UpdateLoginController implements Initializable {
	//Create ComboBox for the UserInput
	@FXML
	public ComboBox<String> UpdateInput;

	ObservableList<String> list01 = FXCollections.observableArrayList("fAttempt", "Condoned", "Referral", "Retake");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UpdateInput.setItems(list01);

	}
	
	@FXML
	private TextField UpdateLevel;
	@FXML
	private Label UpdateIndexLbl;
	@FXML
	private Label UpdateLevelLbl;
	@FXML
	private Button btn20;
	@FXML
	private Button btn21;
	@FXML
	private Label StatusLbl;
	@FXML
	private Label UpdateInputLbl;
	

	public void UpdateLoginOk(ActionEvent event) throws Exception {
		//open Level4 first attempt window	
		if ((UpdateLevel.getText().equals("L4")) && (UpdateInput.getValue().equalsIgnoreCase("fAttempt"))){
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/MarksL4.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();

		//open Level5 first attempt window	
		} else if ((UpdateLevel.getText().equals("L5")) && (UpdateInput.getValue().equalsIgnoreCase("fAttempt"))) {
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/MarksL5.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
			
		//open Level6 first attempt window	
		} else if ((UpdateLevel.getText().equals("L6"))&& ((UpdateInput.getValue().equalsIgnoreCase("fAttempt")))) {
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/MarksL6.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
		//open Level4 Condoned Marks window	
		}else if ((UpdateLevel.getText().equals("L4")) && ((UpdateInput.getValue().equalsIgnoreCase("Condoned")))) {
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/U02-1.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
		//open Level4 Referral Marks window		
		}else if ((UpdateLevel.getText().equals("L4")) && ((UpdateInput.getValue().equalsIgnoreCase("Referral")))){
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/U02-3.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
		//open Level4 Retake Marks window		
		}else if ((UpdateLevel.getText().equals("L4")) && ((UpdateInput.getValue().equalsIgnoreCase("Retake")))){
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/U02-2.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
			
		//open Level5 Retake Marks window		
		}else if ((UpdateLevel.getText().equals("L5")) && ((UpdateInput.getValue().equalsIgnoreCase("Retake")))){
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/U03-2.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
		}
		//open Level5 Referral Marks window	
		else if ((UpdateLevel.getText().equals("L5")) && ((UpdateInput.getValue().equalsIgnoreCase("Referral")))){
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/U03-3.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		}
		//open Level6 Retake Marks window	
		else if ((UpdateLevel.getText().equals("L6")) && ((UpdateInput.getValue().equalsIgnoreCase("Retake")))){
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/U04-2.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
		}
		//open Level6 Referral Marks window	
		else if ((UpdateLevel.getText().equals("L6")) && ((UpdateInput.getValue().equalsIgnoreCase("Referral")))){
			Parent root4 = FXMLLoader.load(getClass().getResource("/application/U04-3.fxml"));
			Stage primaryStage4 = new Stage();
			primaryStage4.setTitle("University of GUGSI/Home/Update");
			Scene scene = new Scene(root4);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage4.setScene(scene);
			primaryStage4.show();
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		}
		else if ((UpdateLevel.getText().equals("L5")) && ((UpdateInput.getValue().equalsIgnoreCase("Condoned")))) {
			StatusLbl.setText("Condoned Not Valid For Level5 ");
		}
		else if ((UpdateLevel.getText().equals("L6")) && ((UpdateInput.getValue().equalsIgnoreCase("Condoned")))) {
			StatusLbl.setText("Condoned Not Valid For Level6 ");
		}
}

	/* Event Listener on Button[#btn21].onAction
	 	Close UpdateLogin window */
	@FXML
	public void CloseAppUpdateLogin(ActionEvent event) {
		Stage stage = (Stage) btn21.getScene().getWindow();
		stage.close();
	}

	
}
