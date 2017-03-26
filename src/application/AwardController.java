package application;

import java.io.IOException;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class AwardController {
	@FXML
	private Label Label03;
	@FXML
	private TextField IndexNo5;
	@FXML
	private Label Label04;
	@FXML
	private Button AwardBtn;
	@FXML
	private Button CalculateBtn;
	
	//calculate level
	public void Calculate(ActionEvent event)throws Exception{
		String onIndex = IndexNo5.getText();
		int studRow = 0;
		int studCol = 0;
		
		String[] pastMarks = new String[3];
		String[] splitMarksL4 = new String[6];
		String[] splitMarksL5 = new String[6];
		String[] splitMarksL6 = new String[5];
		
		String[] Marks = new String[2];
		String currentLevel="";
		
		int level=0;
		int points=0;
		
		
		
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
		Label03.setText(currentLevel);
		
		if(!(pastMarks[0].equalsIgnoreCase(""))){
			splitMarksL4 = pastMarks[0].split("/");
		}
		if(!(pastMarks[1].equalsIgnoreCase(""))){
			splitMarksL5 = pastMarks[1].split("/");
		}
		if(!(pastMarks[0].equalsIgnoreCase(""))){
			splitMarksL6 = pastMarks[2].split("/");
		}
		
		//Level4 point calculation
		if(!(pastMarks[0].equalsIgnoreCase(""))){
			for(int i=0;i<6;i++){
				Marks = splitMarksL4[i].split("-");
				if(Double.parseDouble(Marks[0])>=40){
					points +=20;
				}
			}
		}
		
		//level5 calculation
		if(!(pastMarks[1].equalsIgnoreCase(""))){
			for(int i=0;i<6;i++){
				Marks = splitMarksL4[i].split("-");
				if(Double.parseDouble(Marks[0])>=40){
					points +=20;
				}
			}
		}
		
		//level6 calculation
		int points1=0;
		if(!(pastMarks[2].equalsIgnoreCase(""))){
			for(int i=0;i<4;i++){
				Marks = splitMarksL4[i].split("-");
				if(Double.parseDouble(Marks[0])>=40){
					points +=20;
				}
			}Marks = splitMarksL4[5].split("-");
			if(Double.parseDouble(Marks[0])>=40){
				points +=40;
		
			
			}
		}
		//choose the level
		if((points)==360){ClassCalculation(pastMarks);}
		if(points>=300 && points<360){Label04.setText("Non Hounours Degree");}
		if(points>=240 && points<300){Label04.setText("Dip HE");}
		if(points>=120 && points<240){Label04.setText("Cert HE");}
	}
	//calculate class of the Honours Degree 
	void ClassCalculation(String[] pastMarks){
		
		String[] Marks = new String[2];
		
		String[] splitMarksL5 = new String[6];
		String[] splitMarksL6 = new String[6];
		
		String ClassL5 = "";
		String ClassL6 = "";
		
		//Level5 Class
		if(!(pastMarks[1].equalsIgnoreCase(""))){
			splitMarksL5 = pastMarks[1].split("/");
			for(int i=0;i<6;i++){
				Marks = splitMarksL5[i].split("-");
				if((Double.parseDouble(Marks[0])>=70) && (Double.parseDouble(Marks[0])<=100) 
						&& (ClassL5.equalsIgnoreCase("")||ClassL5.equalsIgnoreCase("1st Class"))){
					ClassL5 = "1st Class";
				}
				else if((Double.parseDouble(Marks[0])>=60) && (Double.parseDouble(Marks[0])<=69) 
						&& (ClassL5.equalsIgnoreCase("")||ClassL5.equalsIgnoreCase("2nd Class Upper"))){
					ClassL5 = "2nd Class Upper";
				}
				else if((Double.parseDouble(Marks[0])>=50) && (Double.parseDouble(Marks[0])<=59) 
						&& (ClassL5.equalsIgnoreCase("")||ClassL5.equalsIgnoreCase("2nd Class Lower"))){
					ClassL5 = "2nd Class Lower";
				}
				else if((Double.parseDouble(Marks[0])>=40) && (Double.parseDouble(Marks[0])<=49) 
						&& (ClassL5.equalsIgnoreCase("")||ClassL5.equalsIgnoreCase("3rd Class Hounours"))){
					ClassL5 = "3rd Class Hounours";
				}
			}
		}
		
		
		//Level6 Class
				if(!(pastMarks[2].equalsIgnoreCase(""))){
					splitMarksL6 = pastMarks[2].split("/");
					for(int i=0;i<5;i++){
						Marks = splitMarksL6[i].split("-");
						if((Double.parseDouble(Marks[0])>=70) && (Double.parseDouble(Marks[0])<=100) 
								&& (ClassL6.equalsIgnoreCase("")||ClassL6.equalsIgnoreCase("1st Class"))){
							ClassL6 = "1st Class ";
						}
						else if((Double.parseDouble(Marks[0])>=60) && (Double.parseDouble(Marks[0])<=69) 
								&& (ClassL6.equalsIgnoreCase("")||ClassL6.equalsIgnoreCase("2nd Class Upper"))){
							ClassL6 = "2nd Class Upper";
						}
						else if((Double.parseDouble(Marks[0])>=50) && (Double.parseDouble(Marks[0])<=59) 
								&& (ClassL6.equalsIgnoreCase("")||ClassL6.equalsIgnoreCase("2nd Class Lower"))){
							ClassL6 = "2nd Class Lower";
						}
						else if((Double.parseDouble(Marks[0])>=40) && (Double.parseDouble(Marks[0])<=49) 
								&& (ClassL6.equalsIgnoreCase("")||ClassL6.equalsIgnoreCase("3rd Class Hounours"))){
							ClassL6 = "3rd Class Hounours";
						}
					}
				}
		
		if(ClassL5.equalsIgnoreCase("1st Class")&& ClassL5.equalsIgnoreCase("1st Class")){
			Label04.setText("1st Class Degree");
		}
		else if(ClassL5.equalsIgnoreCase("2nd Class Upper")|| ClassL5.equalsIgnoreCase("2nd Class Upper")){
			Label04.setText("2nd Class Upper Degree");	
		}
		else if(ClassL5.equalsIgnoreCase("2nd Class Lower")|| ClassL5.equalsIgnoreCase("2nd Class Lower")){
			Label04.setText("2nd Class Lower Degree");	
		}
		else if(ClassL5.equalsIgnoreCase("3rd Class Hounours")|| ClassL5.equalsIgnoreCase("3rd Class Hounours")){
			Label04.setText("3rd Class Hounours Degree");	
		}		
	}
	
	public void AwardOk (ActionEvent event) throws Exception{
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
}


	
	