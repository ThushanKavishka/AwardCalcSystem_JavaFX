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

public class MarksL4Controller {
	@FXML
	private Label M01Lbl;
	@FXML
	private Label M02Lbl;
	@FXML
	private Label M03Lbl;
	@FXML
	private Label M04Lbl;
	@FXML
	private Label M05Lbl;
	@FXML
	private Label M06Lbl;
	@FXML
	private TextField M02txt1;
	@FXML
	private TextField M03txt1;
	@FXML
	private TextField M04txt1;
	@FXML
	private TextField M05txt1;
	@FXML
	private TextField M06txt1;
	@FXML
	private Button btn22;
	@FXML
	private Button btn23;
	@FXML
	private Button btn24;
	@FXML
	private TextField M01txt1;
	@FXML
	private TextField M01txt2;
	@FXML
	private TextField M02txt2;
	@FXML
	private TextField M03txt2;
	@FXML
	private TextField M04txt2;
	@FXML
	private TextField M05txt2;
	@FXML
	private TextField M06txt2;
	@FXML
	private TextField L4Index;
	@FXML
	private TextField L401;
	@FXML
	private TextField L402;
	@FXML
	private TextField L403;
	@FXML
	private TextField L404;
	@FXML
	private TextField L405;
	@FXML
	private TextField L406;
	
	
	
	//Declare onIndex variable
	String onIndex;

	public void MarksL4Apply(ActionEvent event) throws Exception {
		int point=0;
		//Get Index no from textField
		onIndex = L4Index.getText();
		//Calculate the Average Marks
		double module01Avg = ((Integer.parseInt(M01txt1.getText()) + (Integer.parseInt(M01txt2.getText())))) / (2.0);
		double module02Avg = (((Integer.parseInt(M02txt1.getText())) + (Integer.parseInt(M02txt2.getText())))) / (2.0);
		double module03Avg = (((Integer.parseInt(M03txt1.getText())) + (Integer.parseInt(M03txt2.getText())))) / (2.0);
		double module04Avg = (((Integer.parseInt(M04txt1.getText())) + (Integer.parseInt(M04txt2.getText())))) / (2.0);
		double module05Avg = (((Integer.parseInt(M05txt1.getText())) + (Integer.parseInt(M05txt2.getText())))) / (2.0);
		double module06Avg = (((Integer.parseInt(M06txt1.getText())) + (Integer.parseInt(M06txt2.getText())))) / (2.0);
		
		//set average values in each modules in text fields
		L401.setText(String.valueOf(module01Avg));
		L402.setText(String.valueOf(module02Avg));
		L403.setText(String.valueOf(module03Avg));
		L404.setText(String.valueOf(module04Avg));
		L405.setText(String.valueOf(module05Avg));
		L406.setText(String.valueOf(module06Avg));
		
		
		
		//Add module marks averages to markUpdate variable
		String markUpdate = Double.toString(module01Avg) + "-1" + "/" + Double.toString(module02Avg) + "-1" + "/"
				+ Double.toString(module03Avg) + "-1" + "/" + Double.toString(module04Avg) + "-1" + "/"
				+ Double.toString(module05Avg) + "-1" + "/" + Double.toString(module06Avg)+"-1";
		
		System.out.println(markUpdate);
		//calculate the points for each module 
		if(module01Avg>39) point+=20;
		if(module02Avg>39) point+=20;
		if(module03Avg>39) point+=20;
		if(module04Avg>39) point+=20;
		if(module05Avg>39) point+=20;
		if(module06Avg>39) point+=20;
		
		for (int row = 0; row < 5; row++){
			//System.out.println(Main.studendDb[row][0]);
			//Add marks Averages to StudentDb matrix
			if (onIndex.equalsIgnoreCase(Main.studendDb[row][0])){
				//System.out.println("found one");
				
				Main.studendDb[row][3] = markUpdate;
			//calculate level	
				if(point>=100){
					Main.studendDb[row][1] = "Level 5";
				}
				//System.out.println(Main.studendDb[row][3]);
				break;
			}
		}

	}
	//open Update Login window 
	public void MarksL4Ok(ActionEvent event) throws Exception {
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

	/* Event Listener on Button[#btn24].onAction
	 	close the MarksL4 window*/
	@FXML
	public void CloseApp11(ActionEvent event) {
		Stage stage = (Stage) btn24.getScene().getWindow();
		stage.close();
	}

}
