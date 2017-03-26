package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.rmi.CORBA.StubDelegate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

public class U02_1Controller implements Initializable {
	@FXML
	private Label M1;
	@FXML
	private Label M2;
	@FXML
	private TextField Mr1;
	@FXML
	private TextField Mr2;
	@FXML
	private Button btn13;
	@FXML
	private Button btn14;
	@FXML
	private TextField IndexNo2txt;
	@FXML
	private Button btn27;
	
	@FXML
	public ComboBox<String> LevelCombo2;
	ObservableList<String> list2 = FXCollections.observableArrayList("Module01", "Module02", "Module03", "Module04",
			"Module05", "Module06");
	
	@FXML
	public ComboBox<String> LevelCombo3;
	ObservableList<String> list3 = FXCollections.observableArrayList("Module01", "Module02", "Module03", "Module04",
			"Module05", "Module06");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LevelCombo2.setItems(list2);
		LevelCombo3.setItems(list3);
	}	

	@FXML
	public void CloseApp5(ActionEvent event) {
		Stage stage = (Stage) btn14.getScene().getWindow();
		stage.close();
	}
	//get modules from combo boxes
	@FXML
	public void CondonedApply(ActionEvent event) throws Exception {
		String condonedModule01 = (LevelCombo2.getValue());
		String condonedModule02 = (LevelCombo3.getValue());
		
		//get Student Index no
		String onIndex = IndexNo2txt.getText();
		//declare pastMarks variable
		String pastMarks = "";
		//create array called currentMarks
		String[] currentMarks = new String[6];
		int studRow = 0;
		
		//System.out.println("In condoned");
		//calculate the condoned marks
		for (int row = 0; row < 5; row++) {
			if ((Main.studendDb[row][0]).equalsIgnoreCase(onIndex)){
				studRow = row;
				//System.out.println(studRow);
				break;
			}
		}
		
		pastMarks = Main.studendDb[studRow][3];
		
		currentMarks = (pastMarks).split("/");
		
		 if(!(condonedModule01.equalsIgnoreCase("") && condonedModule02.equalsIgnoreCase(""))){
		if (condonedModule01.equalsIgnoreCase("Module01")) {
			currentMarks[0] = "40-1";
		} else if (condonedModule01.equalsIgnoreCase("Module02")) {
			currentMarks[1] = "40-1";
		} else if (condonedModule01.equalsIgnoreCase("Module03")) {
			currentMarks[2] = "40-1";
		} else if (condonedModule01.equalsIgnoreCase("Module04")) {
			currentMarks[3] = "40-1";
		} else if (condonedModule01.equalsIgnoreCase("Module05")) {
			currentMarks[4] = "40-1";
		} else if (condonedModule01.equalsIgnoreCase("Module06")) {
			currentMarks[5] = "40-1";
		}

		//System.out.println("moduleNo one updated");
		
		if (condonedModule02.equalsIgnoreCase("Module01")) {
			currentMarks[0] = "40-1";
		} else if (condonedModule02.equalsIgnoreCase("Module02")) {
			currentMarks[1] = "40-1";
		} else if (condonedModule02.equalsIgnoreCase("Module03")) {
			currentMarks[2] = "40-1";
		} else if (condonedModule02.equalsIgnoreCase("Module04")) {
			currentMarks[3] = "40-1";
		} else if (condonedModule02.equalsIgnoreCase("Module05")) {
			currentMarks[4] = "40-1";
		} else if (condonedModule02.equalsIgnoreCase("Module06")) {
			currentMarks[5] = "40-1";
		}
		} 
		//System.out.println("moduleNo two updated");
		
		pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
				+ currentMarks[4] + "/" + currentMarks[5];

		System.out.println(pastMarks);
		
		currentMarks = pastMarks.split("/");
		
		//create array called Marks
		String[] Marks = new String[2];
		int points=0;
		
		//calculate points
		for(int i=0;i<6;i++){
			Marks = currentMarks[i].split("-");
			if(Double.parseDouble(Marks[0])>=40){
				points +=20;
			}
		}
		//calculate level
		for (int row = 0; row < 5; row++) {
			if ((Main.studendDb[row][0]).equalsIgnoreCase(onIndex)) {
				Main.studendDb[row][3] = pastMarks;
				if(points>=100){
					Main.studendDb[row][1] = "Level 5";
				}
				break;
			}
		}

	}
	//open UpdateLogin window
	public void CondonedOk (ActionEvent event)throws Exception{
		Stage primaryStage3 = new Stage();
		primaryStage3.setTitle("University of GUGSI/Home");
		Parent root3 = FXMLLoader.load(getClass().getResource("/application/UpdateLogin.fxml"));
		Scene scene = new Scene(root3);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage3.setScene(scene);
		primaryStage3.show();
		primaryStage3.setResizable(false);
		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
	}
}
