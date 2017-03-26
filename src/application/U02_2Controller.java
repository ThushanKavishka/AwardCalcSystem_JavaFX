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

public class U02_2Controller implements Initializable{
	@FXML
	private Button btn30;
	@FXML
	private Button btn31;
	@FXML
	private Label M4;
	@FXML
	private TextField Mr4;
	@FXML
	private Button btn29;
	@FXML
	private TextField IndexNo4txt;
	@FXML
	private Label StatusLbl09;
	@FXML
	private Label Label01;
	
	@FXML
	public ComboBox<String> LevelCombo5;
	ObservableList<String> list5 = FXCollections.observableArrayList("Module01", "Module02", "Module03", "Module04",
			"Module05", "Module06");

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		LevelCombo5.setItems(list5);
	}
	
	/*Event Listener on Button[#btn31].onAction
	 	Close L4 Retake window*/
	@FXML
	public void CloseApp10(ActionEvent event) {
		Stage stage = (Stage) btn31.getScene().getWindow();
		stage.close();
	}
	
	public void RetakeL4Apply (ActionEvent event) throws Exception{
		
		String RetakeModule01 = LevelCombo5.getValue();
		
		if(Double.parseDouble(Mr4.getText())<41){
			String RetakeModuleMarks = Mr4.getText();
			String onIndex = IndexNo4txt.getText();
			
			int studRow=0;
			String pastMarks = "";
			String[] currentMarks = {};
			String[] retMarks = {};
			String newRetMarks = "";
			
			for (int row = 0; row < 5; row++) {
				if ((Main.studendDb[row][0]).equalsIgnoreCase(onIndex)){
					System.out.println("found our guy");
					pastMarks = Main.studendDb[row][3];
					studRow = row;
					System.out.println(pastMarks);
					break;
				}
			}
			
			currentMarks = pastMarks.split("/");
			
				if (RetakeModule01.equalsIgnoreCase("Module01")){
					
					retMarks = currentMarks[0].split("-");
					retMarks[0] = RetakeModuleMarks;
					System.out.println(retMarks[0]);
					
					if(Integer.parseInt(retMarks[1]) <5){
						System.out.println("Referral Module_01");
						retMarks[1] = Integer.toString(1+(Integer.parseInt(retMarks[1])));
						System.out.println(retMarks[1]);
						
						newRetMarks = retMarks[0]+ "-" +retMarks[1];
						
						pastMarks = newRetMarks + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
								+ currentMarks[4] + "/" + currentMarks[5];
						
						System.out.println(pastMarks);
					}
					else{
						StatusLbl09.setText("The Student Has Been Excluded");			}
					
						
				}else if (RetakeModule01.equalsIgnoreCase("Module02")) {

					retMarks = currentMarks[1].split("-");
					retMarks[0] = RetakeModuleMarks;
					
					if(Integer.parseInt(retMarks[1]) <5){
						retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
						newRetMarks = retMarks[0]+ "-" +retMarks[1];
						pastMarks = currentMarks[0] + "/" + newRetMarks + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
								+ currentMarks[4] + "/" + currentMarks[5];
					}
					else{
						StatusLbl09.setText("The Student Has Been Excluded");			
						}
				
			} else if (RetakeModule01.equalsIgnoreCase("Module03")) {

				retMarks = currentMarks[2].split("-");
				retMarks[0] = RetakeModuleMarks;
				
				if(Integer.parseInt(retMarks[1]) <5){
					retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
					newRetMarks = retMarks[0]+ "-" +retMarks[1];
					pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + newRetMarks + "/" + currentMarks[3] + "/"
							+ currentMarks[4] + "/" + currentMarks[5];
				}
				else{
					StatusLbl09.setText("The Student Has Been Excluded");
				}
				
			} else if (RetakeModule01.equalsIgnoreCase("Module04")) {

				retMarks = currentMarks[3].split("-");
				retMarks[0] = RetakeModuleMarks;
				if(Integer.parseInt(retMarks[1]) <5){
					retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
					newRetMarks = retMarks[0]+ "-" +retMarks[1];
					pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + newRetMarks + "/"
							+ currentMarks[4] + "/" + currentMarks[5];
				}
				else{
					StatusLbl09.setText("The Student Has Been Excluded");
				}
				
			} else if (RetakeModule01.equalsIgnoreCase("Module05")) {

				retMarks = currentMarks[4].split("-");
				retMarks[0] = RetakeModuleMarks;
				if(Integer.parseInt(retMarks[1]) <5){
					retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
					newRetMarks = retMarks[0]+ "-" +retMarks[1];
					pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
							+ newRetMarks + "/" + currentMarks[5];
				}
				else{
					StatusLbl09.setText("The Student Has Been Excluded");
				}
				
			} else if (RetakeModule01.equalsIgnoreCase("Module06")) {

				retMarks = currentMarks[5].split("-");
				retMarks[0] = RetakeModuleMarks;
				if(Integer.parseInt(retMarks[1]) <5){
					retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
					newRetMarks = retMarks[0]+ "-" +retMarks[1];
					pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
							+ currentMarks[4] + "/" + newRetMarks;
				}
				else{
					StatusLbl09.setText("The Student Has Been Excluded");
				}
			}

				Main.studendDb[studRow][3] = pastMarks;
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
					Main.studendDb[studRow][1] = "Level 5";
				}

		}
		else{
			Label01.setText("Maximum Marks given is 40");
		}
}
	//open UpdateLogin window
	public void RetakeL4Ok (ActionEvent event)throws Exception{
		if(! (Mr4.getText().equals("") )){
		Stage primaryStage3 = new Stage();
		primaryStage3.setTitle("University of GUGSI/Home");
		Parent root3 = FXMLLoader.load(getClass().getResource("/application/UpdateLogin.fxml"));
		Scene scene = new Scene(root3);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage3.setScene(scene);
		primaryStage3.show();
		primaryStage3.setResizable(false);
		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		}else{
			StatusLbl09.setText("Invalid Selection");
		}
	}
	
}
