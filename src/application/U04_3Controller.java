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

public class U04_3Controller implements Initializable{
	@FXML
	private Button btn51;
	@FXML
	private Button btn52;
	@FXML
	private Button btn50;
	@FXML
	private Label M13;
	@FXML
	private Label Label13;
	@FXML
	private Label StatusLbl13;
	@FXML
	private TextField IndexNo13txt;
	@FXML
	private TextField Mr13;

	
	
	@FXML
	public ComboBox<String> LevelCombo13;
	ObservableList<String> list13 = FXCollections.observableArrayList("Module13", "Module14", "Module15", "Module16",
			"Module17");

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		LevelCombo13.setItems(list13);
	}
	
	// Event Listener on Button[#btn52].onAction
	//close level6 referral Marks window
	@FXML
	public void CloseApp18(ActionEvent event) {
		Stage stage = (Stage) btn52.getScene().getWindow();
		stage.close();
	}
	
public void ReferralL6Apply(ActionEvent event )throws Exception{
String RefferalModule01 = LevelCombo13.getValue();
	
	if(Double.parseDouble(Mr13.getText())<41){
		String RefferalModuleMarks = Mr13.getText();
		String onIndex = IndexNo13txt.getText();
		
		int studRow=0;
		String pastMarks = "";
		String[] currentMarks = {};
		String[] refMarks = {};
		String newRefMarks = "";
		
		for (int row = 0; row < 5; row++) {
			if ((Main.studendDb[row][0]).equalsIgnoreCase(onIndex)){
				System.out.println("found our guy");
				pastMarks = Main.studendDb[row][5];
				studRow = row;
				System.out.println(pastMarks);
				break;
			}
		}
		
		currentMarks = pastMarks.split("/");
		
			if (RefferalModule01.equalsIgnoreCase("Module13")){
				
				refMarks = currentMarks[0].split("-");
				refMarks[0] = RefferalModuleMarks;
				System.out.println(refMarks[0]);
				
				if(Integer.parseInt(refMarks[1]) <5){
					System.out.println("Referral Module_01");
					refMarks[1] = Integer.toString(1+(Integer.parseInt(refMarks[1])));
					System.out.println(refMarks[1]);
					
					newRefMarks = refMarks[0]+ "-" +refMarks[1];
					
					pastMarks = newRefMarks + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
							+ currentMarks[4] ;
					
					System.out.println(pastMarks);
				}
				else{
					StatusLbl13.setText("The Student Has Been Excluded");			}
				
					
			}else if (RefferalModule01.equalsIgnoreCase("Module14")) {

				refMarks = currentMarks[1].split("-");
				refMarks[0] = RefferalModuleMarks;
				
				if(Integer.parseInt(refMarks[1]) <5){
					refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
					newRefMarks = refMarks[0]+ "-" +refMarks[1];
					pastMarks = currentMarks[0] + "/" + newRefMarks + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
							+ currentMarks[4] ;
				}
				else{
					StatusLbl13.setText("The Student Has Been Excluded");			
					}
			
		} else if (RefferalModule01.equalsIgnoreCase("Module15")) {

			refMarks = currentMarks[2].split("-");
			refMarks[0] = RefferalModuleMarks;
			
			if(Integer.parseInt(refMarks[1]) <5){
				refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
				newRefMarks = refMarks[0]+ "-" +refMarks[1];
				pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + newRefMarks + "/" + currentMarks[3] + "/"
						+ currentMarks[4];
			}
			else{
				StatusLbl13.setText("The Student Has Been Excluded");
			}
			
		} else if (RefferalModule01.equalsIgnoreCase("Module16")) {

			refMarks = currentMarks[3].split("-");
			refMarks[0] = RefferalModuleMarks;
			if(Integer.parseInt(refMarks[1]) <5){
				refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
				newRefMarks = refMarks[0]+ "-" +refMarks[1];
				pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + newRefMarks + "/"
						+ currentMarks[4] ;
			}
			else{
				StatusLbl13.setText("The Student Has Been Excluded");
			}
			
		} else if (RefferalModule01.equalsIgnoreCase("Module17")) {

			refMarks = currentMarks[4].split("-");
			refMarks[0] = RefferalModuleMarks;
			if(Integer.parseInt(refMarks[1]) <5){
				refMarks[1] = Integer.toString((Integer.parseInt(refMarks[1])+1));
				newRefMarks = refMarks[0]+ "-" +refMarks[1];
				pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
						+ newRefMarks ;
			}
			
			
		
			else{
				StatusLbl13.setText("The Student Has Been Excluded");
			}
		}

			Main.studendDb[studRow][5] = pastMarks;
			System.out.println(pastMarks);
			currentMarks = pastMarks.split("/");
			String[] Marks = new String[2];
			int points=0;
			
			for(int i=0;i<5;i++){
				Marks = currentMarks[i].split("-");
				if(Double.parseDouble(Marks[0])>=40){
					points +=20;
				}
			}
			
			if(points>=100){
				Main.studendDb[studRow][1] = "Graduated";
			}

	}
	else{
		Label13.setText("Maximum Marks given is 40");
	}
}
//open UpdateLogin window
public void ReferralL6Ok (ActionEvent event)throws Exception{
	if ((Mr13.getText().equals(""))){
		StatusLbl13.setText("Invalid Selection");
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
