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

public class U04_2Controller implements Initializable{
	//define labels,textfields and buttons
	@FXML
	private Button btn45;
	@FXML
	private Button btn46;
	@FXML
	private Button btn44;
	@FXML
	private Label M12;
	@FXML
	private Label Label12;
	@FXML
	private Label StatusLbl12;
	@FXML
	private TextField Mr12;
	@FXML
	private TextField IndexNo12txt;

	
	@FXML
	public ComboBox<String> LevelCombo12;
	ObservableList<String> list12 = FXCollections.observableArrayList("Module13", "Module14", "Module15", "Module16",
			"Module17");

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		LevelCombo12.setItems(list12);
	}
	
	// Event Listener on Button[#btn46].onAction
	//close Level 6 retake Marks window
	@FXML
	public void CloseApp17(ActionEvent event) {
		Stage stage = (Stage) btn46.getScene().getWindow();
		stage.close();
	}
	//calculate retake Marks in level6
	public void RetakeL6Apply (ActionEvent event) throws Exception{

		String RetakeModule01 = LevelCombo12.getValue();
		
		if(Double.parseDouble(Mr12.getText())<41){
			String RetakeModuleMarks = Mr12.getText();
			String onIndex = IndexNo12txt.getText();
			
			int studRow=0;
			String pastMarks = "";
			String[] currentMarks = {};
			String[] retMarks = {};
			String newRetMarks = "";
			
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
			
				if (RetakeModule01.equalsIgnoreCase("Module13")){
					
					retMarks = currentMarks[0].split("-");
					retMarks[0] = RetakeModuleMarks;
					System.out.println(retMarks[0]);
					
					if(Integer.parseInt(retMarks[1]) <5){
					
						retMarks[1] = Integer.toString(1+(Integer.parseInt(retMarks[1])));
						System.out.println(retMarks[1]);
						
						newRetMarks = retMarks[0]+ "-" +retMarks[1];
						
						pastMarks = newRetMarks + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
								+ currentMarks[4];
						
						System.out.println(pastMarks);
					}
					else{
						StatusLbl12.setText("The Student Has Been Excluded");			}
					
						
				}else if (RetakeModule01.equalsIgnoreCase("Module14")) {

					retMarks = currentMarks[1].split("-");
					retMarks[0] = RetakeModuleMarks;
					
					if(Integer.parseInt(retMarks[1]) <5){
						retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
						newRetMarks = retMarks[0]+ "-" +retMarks[1];
						pastMarks = currentMarks[0] + "/" + newRetMarks + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
								+ currentMarks[4] ;
					}
					else{
						StatusLbl12.setText("The Student Has Been Excluded");			
						}
				
			} else if (RetakeModule01.equalsIgnoreCase("Module15")) {

				retMarks = currentMarks[2].split("-");
				retMarks[0] = RetakeModuleMarks;
				
				if(Integer.parseInt(retMarks[1]) <5){
					retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
					newRetMarks = retMarks[0]+ "-" +retMarks[1];
					pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + newRetMarks + "/" + currentMarks[3] + "/"
							+ currentMarks[4] ;
				}
				else{
					StatusLbl12.setText("The Student Has Been Excluded");
				}
				
			} else if (RetakeModule01.equalsIgnoreCase("Module16")) {

				retMarks = currentMarks[3].split("-");
				retMarks[0] = RetakeModuleMarks;
				if(Integer.parseInt(retMarks[1]) <5){
					retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
					newRetMarks = retMarks[0]+ "-" +retMarks[1];
					pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + newRetMarks + "/"
							+ currentMarks[4] ;
				}
				else{
					StatusLbl12.setText("The Student Has Been Excluded");
				}
				
			} else if (RetakeModule01.equalsIgnoreCase("Module17")) {

				retMarks = currentMarks[4].split("-");
				retMarks[0] = RetakeModuleMarks;
				if(Integer.parseInt(retMarks[1]) <5){
					retMarks[1] = Integer.toString((Integer.parseInt(retMarks[1])+1));
					newRetMarks = retMarks[0]+ "-" +retMarks[1];
					pastMarks = currentMarks[0] + "/" + currentMarks[1] + "/" + currentMarks[2] + "/" + currentMarks[3] + "/"
							+ newRetMarks ;
				}
				else{
					StatusLbl12.setText("The Student Has Been Excluded");
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
			Label12.setText("Maximum Marks given is 40");
		}
	
	}	
//open UpdateLogin window
	public void RetakeL6Ok (ActionEvent event)throws Exception{
		if(! (Mr12.getText().equals("") )){
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
			StatusLbl12.setText("Invalid Selection");
		}
	}
}
