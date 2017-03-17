package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class MarksL6Controller {
	//define labels,textfields and buttons
	@FXML
	private Button btn47;
	@FXML
	private Button btn48;
	@FXML
	private Button btn49;
	@FXML
	private Label M13Lbl;
	@FXML
	private Label M14Lbl;
	@FXML
	private Label M15Lbl;
	@FXML
	private Label M16Lbl;
	@FXML
	private Label M17Lbl;
	@FXML
	private Label M18Lbl;
	@FXML
	private TextField M13txt1;
	@FXML
	private TextField M14txt1;
	@FXML
	private TextField M15txt1;
	@FXML
	private TextField M16txt1;
	@FXML
	private TextField M17txt1;
	@FXML
	private TextField M13txt2;
	@FXML
	private TextField M14txt2;
	@FXML
	private TextField M15txt2;
	@FXML
	private TextField M16txt2;
	@FXML
	private TextField M17txt2;
	@FXML
	private TextField M18txt1;
	@FXML
	private TextField M18txt2;
	@FXML
	private TextField L6Index;
	@FXML
	private TextField L601;
	@FXML
	private TextField L602;
	@FXML
	private TextField L603;
	@FXML
	private TextField L604;
	@FXML
	private TextField L605;
	

	//Declare onIndex variable
	String onIndex;

	public void MarksL6Apply(ActionEvent event) throws Exception {
		//Get Index no from textField
		int point=0;
		onIndex = L6Index.getText();
		//Calculate the Average Marks
		double module13Avg = ((Integer.parseInt(M13txt1.getText()) + (Integer.parseInt(M13txt2.getText())))) / (2.0);
		double module14Avg = (((Integer.parseInt(M14txt1.getText())) + (Integer.parseInt(M14txt2.getText())))) / (2.0);
		double module15Avg = (((Integer.parseInt(M15txt1.getText())) + (Integer.parseInt(M15txt2.getText())))) / (2.0);
		double module16Avg = (((Integer.parseInt(M16txt1.getText())) + (Integer.parseInt(M16txt2.getText())))) / (2.0);
		double module17Avg = (((Integer.parseInt(M17txt1.getText())) + (Integer.parseInt(M17txt2.getText())))) / (2.0);
		
		//set average values in each modules in text fields
		L601.setText(String.valueOf(module13Avg));
		L602.setText(String.valueOf(module14Avg));
		L603.setText(String.valueOf(module15Avg));
		L604.setText(String.valueOf(module16Avg));
		L605.setText(String.valueOf(module17Avg));
		
		
		//Add module marks averages to markUpdate variable
		String markUpdate = Double.toString(module13Avg) + "-1" + "/" + Double.toString(module14Avg) + "-1" + "/"
				+ Double.toString(module15Avg) + "-1" + "/" + Double.toString(module16Avg) + "-1" + "/"
				+ Double.toString(module17Avg) + "-1";
		System.out.println(markUpdate);

		//calculate the points for each module 
		if(module13Avg>39) point+=20;
		if(module14Avg>39) point+=20;
		if(module15Avg>39) point+=20;
		if(module16Avg>39) point+=20;
		if(module17Avg>39) point+=40;
		
		
		for (int row = 0; row < 5; row++){
			System.out.println(Main.studendDb[row][0]);
			if (onIndex.equalsIgnoreCase(Main.studendDb[row][0])){
				//System.out.println("found one");
				//Add marks Averages to StudentDb matrix
				Main.studendDb[row][5] = markUpdate;
				
				if(point>=100){
					Main.studendDb[row][1] = "Graduated";
				}
				System.out.println(Main.studendDb[row][5]);
				break;
			}
		}

	}
	//open Update Login window 
	public void MarksL6Ok(ActionEvent event) throws Exception {
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

	// Event Listener on Button[#btn48].onAction
	//Close L6 Marks window
	@FXML
	public void CloseApp18(ActionEvent event) {
		Stage stage = (Stage) btn48.getScene().getWindow();
		stage.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
