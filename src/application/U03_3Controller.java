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

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

public class U03_3Controller implements Initializable {
	@FXML
	private Label M8;
	@FXML
	private Label Label08;
	@FXML
	private Label StatusLbl11;
	@FXML
	private Button btn41;
	@FXML
	private Button btn42;
	@FXML
	private Button btn43;
	@FXML
	private TextField Mr8;
	@FXML
	private TextField IndexNo8txt;

	
	@FXML
	public ComboBox<String> LevelCombo8;
	ObservableList<String> list8 = FXCollections.observableArrayList("Module07", "Module08", "Module09", "Module10",
			"Module11", "Module12");

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		LevelCombo8.setItems(list8);
	}
	
	// Event Listener on Button[#btn43].onAction
	//Close Level5 Referral Marks window
	@FXML
	public void CloseApp9(ActionEvent event) {
		Stage stage = (Stage) btn43.getScene().getWindow();
		stage.close();
	}
	//Calculate Referral Marks in level5
public void ReferralL5Apply(ActionEvent event )throws Exception{
	String RefferalModule01 = LevelCombo8.getValue();
	
	if(Double.parseDouble(Mr8.getText())<41){
		String RefferalModuleMarks = Mr8.getText();
		String onIndex = IndexNo8txt.getText();
		
		int studRow=0;
		String pastMarks = "";
		String[] currentMarks = {};
		String[] refMarks = {};
		String newRefMarks = "";
		
		for (int row = 0; row < 5; row++) {
			if ((Main.studendDb[row][0]).equalsIgnoreCase(onIndex)){
				//System.out.println("found our guy");
				pastMarks = Main.studendDb[row][4];
				studRow = row;
				//System.out.println(pastMarks);
				break;
			}
		}
		
		currentMarks = pastMarks.split("/");
		
			if (RefferalModule01.equalsIgnoreCase("Module07")){
				
				refMarks = currentMarks[0].split("-");
				refMarks[0] = RefferalModuleMarks;
				//System.out.println(refMarks[0]);
				
				if(Integer.parseInt(refMarks[1]) <5){
					//System.out.println("Referral Module_07");
					refMarks[1] = Integer.toString(1+(Integer.parseInt(refMarks[1])));
					System.out.println(refMarks[1]);
					
					newRefMarks = refMarks[0]+ "-" +refMarks[1];
					
					pastMarks = newRefMarks + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
							+ currentMarks[4] + "/" + currentMarks[5];
					
					System.out.println(pastMarks);
				}
				else{
					StatusLbl11.setText("The Student Has Been Excluded");			}
				
					
			}else if (RefferalModule01.equalsIgnoreCase("Module08")) {

				refMarks = currentMarks[1].split("-");
				refMarks[0] = RefferalModuleMarks;
				
				if(Integer.parseInt(refMarks[1]) <5){
					refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
					newRefMarks = refMarks[0]+ "-" +refMarks[1];
					pastMarks = currentMarks[0] + "/" + newRefMarks + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
							+ currentMarks[4] + "/" + currentMarks[5];
				}
				else{
					StatusLbl11.setText("The Student Has Been Excluded");			
					}
			
		} else if (RefferalModule01.equalsIgnoreCase("Module09")) {

			refMarks = currentMarks[2].split("-");
			refMarks[0] = RefferalModuleMarks;
			
			if(Integer.parseInt(refMarks[1]) <5){
				refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
				newRefMarks = refMarks[0]+ "-" +refMarks[1];
				pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + newRefMarks + "/" + currentMarks[3] + "/"
						+ currentMarks[4] + "/" + currentMarks[5];
			}
			else{
				StatusLbl11.setText("The Student Has Been Excluded");
			}
			
		} else if (RefferalModule01.equalsIgnoreCase("Module10")) {

			refMarks = currentMarks[3].split("-");
			refMarks[0] = RefferalModuleMarks;
			if(Integer.parseInt(refMarks[1]) <5){
				refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
				newRefMarks = refMarks[0]+ "-" +refMarks[1];
				pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + newRefMarks + "/"
						+ currentMarks[4] + "/" + currentMarks[5];
			}
			else{
				StatusLbl11.setText("The Student Has Been Excluded");
			}
			
		} else if (RefferalModule01.equalsIgnoreCase("Module11")) {

			refMarks = currentMarks[4].split("-");
			refMarks[0] = RefferalModuleMarks;
			if(Integer.parseInt(refMarks[1]) <5){
				refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
				newRefMarks = refMarks[0]+ "-" +refMarks[1];
				pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
						+ newRefMarks + "/" + currentMarks[5];
			}
			else{
				StatusLbl11.setText("The Student Has Been Excluded");
			}
			
		} else if (RefferalModule01.equalsIgnoreCase("Module12")) {

			refMarks = currentMarks[5].split("-");
			refMarks[0] = RefferalModuleMarks;
			if(Integer.parseInt(refMarks[1]) <5){
				refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
				newRefMarks = refMarks[0]+ "-" +refMarks[1];
				pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
						+ currentMarks[4] + "/" + newRefMarks;
			}
			else{
				StatusLbl11.setText("The Student Has Been Excluded");
			}
		}

			Main.studendDb[studRow][4] = pastMarks;
			System.out.println(pastMarks);
			
			currentMarks = pastMarks.split("/");
			String[] Marks = new String[2];
			int points=0;
			
			for(int i=0;i<6;i++){
				Marks = currentMarks[i].split("-");
				if(Double.parseDouble(Marks[0])>=40){
					points +=20;
				}
			}
			
			if(points>=100){
				Main.studendDb[studRow][1] = "Level 6";
			}

	}
	else{
		Label08.setText("Maximum Marks given is 40");
	}
	
}
//open UpdateLogin window
public void ReferralL5Ok (ActionEvent event)throws Exception{
	if ((Mr8.getText().equals(""))){
		StatusLbl11.setText("Invalid Selection");
	}else{
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
}
