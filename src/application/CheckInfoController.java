package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckInfoController {
	@FXML
	private Button btn32;
	@FXML
	private Button btn33;
	@FXML
	private TextField InsetTxt;
	@FXML
	private Label CheckLevelLbl;
	@FXML
	private Label StatusBar;
	@FXML
	private TextField CheckLevel;
	
	//open Homepage
	public void CheckInfoOk (ActionEvent event)throws Exception{
		
		Stage primaryStage3 = new Stage();
		primaryStage3.setTitle("University of GUGSI/Home");
		Parent root3 = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
		Scene scene = new Scene(root3);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage3.setScene(scene);
		primaryStage3.show();
		primaryStage3.setResizable(false);
		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		
		
		}	
	//calculate level
	public void Check (ActionEvent event)throws Exception{
		String onIndex ="";
		onIndex = InsetTxt.getText();
		
		int studRow = 0;
		int studCol = 0;
		String[] pastMarks = new String[3];
		String[] splitMarks = new String[6];
		String[] splitModuleMarks = new String[2];
		String currentLevel="";
		
		int level=0;
		
		for (int row = 0; row < 5; row++){
			if ((Main.studendDb[row][0]).equalsIgnoreCase(onIndex))
			{	
				//System.out.println("found the guy");
				studRow= row;
				
				for(int col=3;col<6;col++)
				{
					if(!((Main.studendDb[row][col]).equalsIgnoreCase("")))
					{
						pastMarks[level] = Main.studendDb[row][col];
						level++;
					}
					else
					{
						pastMarks[level] = "";
						level++;
					}
				}
				currentLevel = Main.studendDb[studRow][1];
				break;
			}
		}
		CheckLevel.setText(currentLevel);
		
		
		//Checking level4
		if(!(pastMarks[0].equalsIgnoreCase("")))
		{
			splitMarks = pastMarks[0].split("/");
			
			for(int i=0;i<(splitMarks.length);i++){
				splitModuleMarks = splitMarks[i].split("-");
				if(Integer.parseInt(splitModuleMarks[1]) >4)
				{
					StatusBar.setText("Student Has Been Excluded");
				}
			}
		}

		//clear all the array contents
		for(int i=0;i<splitMarks.length;i++)
		{
			splitMarks[i]="";
		}
		
		for(int i=0;i<splitModuleMarks.length;i++)
		{
			splitModuleMarks[i]="";
		}
		
		
		//Checking level5
		if(!(pastMarks[1].equalsIgnoreCase("")))
		{
			splitMarks = pastMarks[1].split("/");
			for(int i=0;i<(splitMarks.length);i++){
				splitModuleMarks = splitMarks[i].split("-");
				if(Integer.parseInt(splitModuleMarks[1]) >4)
				{
				//Set excluded label
					StatusBar.setText("Student Has Been Excluded");
				}
			}
		}
		
		//clear all the array contents
		
		for(int i=0;i<splitMarks.length;i++)
			{
				splitMarks[i]="";
			}
				
			for(int i=0;i<splitModuleMarks.length;i++)
			{
				splitModuleMarks[i]="";
			}

		
			//Checking level6
		if(!(pastMarks[2].equalsIgnoreCase("")))
		{
			splitMarks = pastMarks[2].split("/");
			for(int i=0;i<(splitMarks.length);i++){
				splitModuleMarks = splitMarks[i].split("-");
				if(Integer.parseInt(splitModuleMarks[1]) >4)
				{
				//Set excluded label
					StatusBar.setText("Student Has Been Excluded");
				}
			}
		}
		
	}
		
	}
	 
	

