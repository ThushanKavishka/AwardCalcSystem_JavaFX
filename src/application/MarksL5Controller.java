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

public class MarksL5Controller {
	//define labels,textfields and buttons
	@FXML
	private Label M07Lbl;
	@FXML
	private Label M08Lbl;
	@FXML
	private Label M09Lbl;
	@FXML
	private Label M10Lbl;
	@FXML
	private Label M11Lbl;
	@FXML
	private Label M12Lbl;
	@FXML
	private TextField M07txt1;
	@FXML
	private TextField M08txt1;
	@FXML
	private TextField M09txt1;
	@FXML
	private TextField M10txt1;
	@FXML
	private TextField M11txt1;
	@FXML
	private TextField M12txt1;
	@FXML
	private Button btn37;
	@FXML
	private Button btn36;
	@FXML
	private TextField M07txt2;
	@FXML
	private TextField M08txt2;
	@FXML
	private TextField M09txt2;
	@FXML
	private TextField M10txt2;
	@FXML
	private TextField M11txt2;
	@FXML
	private TextField L501;
	@FXML
	private TextField L502;
	@FXML
	private TextField L503;
	@FXML
	private TextField L504;
	@FXML
	private TextField L505;
	@FXML
	private TextField L506;
	@FXML
	private TextField M12txt2;
	@FXML
	private TextField L5Index;
	@FXML
	private Button btn35;
	
	
	//Declare onIndex variable
	String onIndex;

	public void MarksL5Apply(ActionEvent event) throws Exception {
		//Get Index no from textField
		int point=0;
		onIndex = L5Index.getText();
		//Calculate the Average Marks
		double module07Avg = ((Integer.parseInt(M07txt1.getText()) + (Integer.parseInt(M07txt2.getText())))) / (2.0);
		double module08Avg = (((Integer.parseInt(M08txt1.getText())) + (Integer.parseInt(M08txt2.getText())))) / (2.0);
		double module09Avg = (((Integer.parseInt(M09txt1.getText())) + (Integer.parseInt(M09txt2.getText())))) / (2.0);
		double module10Avg = (((Integer.parseInt(M10txt1.getText())) + (Integer.parseInt(M10txt2.getText())))) / (2.0);
		double module11Avg = (((Integer.parseInt(M11txt1.getText())) + (Integer.parseInt(M11txt2.getText())))) / (2.0);
		double module12Avg = (((Integer.parseInt(M12txt1.getText())) + (Integer.parseInt(M12txt2.getText())))) / (2.0);

		//set average values in each modules in text fields
				L501.setText(String.valueOf(module07Avg));
				L502.setText(String.valueOf(module08Avg));
				L503.setText(String.valueOf(module09Avg));
				L504.setText(String.valueOf(module10Avg));
				L505.setText(String.valueOf(module11Avg));
				L506.setText(String.valueOf(module12Avg));
				
				//Add module marks averages to markUpdate variable
		String markUpdate = Double.toString(module07Avg) + "-1" + "/" + Double.toString(module08Avg) + "-1" + "/"
				+ Double.toString(module09Avg) + "-1" + "/" + Double.toString(module10Avg) + "-1" + "/"
				+ Double.toString(module11Avg) + "-1" + "/" + Double.toString(module12Avg)+"-1";
		
		System.out.println(markUpdate);
		//calculate the points for each module 
		if(module07Avg>39) point+=20;
		if(module08Avg>39) point+=20;
		if(module09Avg>39) point+=20;
		if(module10Avg>39) point+=20;
		if(module11Avg>39) point+=20;
		if(module12Avg>39) point+=20;
		
		for (int row = 0; row < 5; row++){
			//System.out.println(Main.studendDb[row][0]);
			//Add marks Averages to StudentDb matrix
			if (onIndex.equalsIgnoreCase(Main.studendDb[row][0])){
				//System.out.println("found one");
				Main.studendDb[row][4] = markUpdate;
				
				if(point>=100){
					Main.studendDb[row][1] = "Level 6";
				}
				//System.out.println(Main.studendDb[row][4]);
				break;
			}
		}

	}
	//open Update Login window 
	public void MarksL5Ok(ActionEvent event) throws Exception {
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

	// Event Listener on Button[#btn37].onAction
	//Close MarksL5 window
	@FXML
	public void CloseApp15(ActionEvent event) {
		Stage stage = (Stage) btn37.getScene().getWindow();
		stage.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
