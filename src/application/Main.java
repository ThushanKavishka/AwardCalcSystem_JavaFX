package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	public static String[][] studendDb = new String[5][6];
	
	public void start(Stage primaryStage) {
		//Create Matrix with 5 rows and 6 columns
		for(int row=0;row<5;row++)
		{
			for(int col=0;col<6;col++)
			{
			
				studendDb[row][col]="";
			}

		}
			//Open the login window 
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("University of GUGSI");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	Stage window;
	public static void main(String[] args) {
		launch(args);
	}
	
	}

