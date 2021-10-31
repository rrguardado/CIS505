/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package GradeBookApp;

import java.util.Set;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.text.DecimalFormat;
import javafx.geometry.Insets;

public class GuardadoGradeBookApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("OpenEdX Gradebook App");                
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);
        
        //create labels
        Label lblFirstName = new Label("Student's First Name: ");
        Label lblLastName = new Label("Student's Last Name: ");
        Label lblCourseName = new Label("Course they completed: ");
        Label lblGrade = new Label("Student's course grade: ");
        //end labels
                       
        //start setup form controls
        TextField tfFirstName = new TextField();
        TextField tfLastName = new TextField();
        TextField tfCourseName = new TextField();
        //end textfields
                     
        ComboBox<String> cboBoxGrades = new ComboBox<String>();
        List<String> gradesList = new ArrayList<String>(Arrays.asList("A","B","C","D","F"));
        cboBoxGrades.getItems().addAll(gradesList);
        
        Button btnClear = new Button("Clear");
        Button btnSave = new Button("Save");
        Button btnView = new Button("View");
        Button btnHelp = new Button ("Help");
        //end buttons
        //end setup form controls
                
        //start setup gridpane
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gp.setHgap(5.5);
        gp.setVgap(5.5);
        
        //add controls to gridpane
        gp.add(lblFirstName, 1, 1);
        gp.add(tfFirstName, 2, 1);
        //end first row of grid
        
        gp.add(lblLastName, 1, 2);
        gp.add(tfLastName, 2, 2);
        //end second row of grid
        
        gp.add(lblCourseName, 1, 3);
        gp.add(tfCourseName, 2, 3);
        //end third row of grid
        
        gp.add(lblGrade, 1, 4);
        gp.add(cboBoxGrades, 2, 4);
        //end fourth row of grid
        
        gp.add(btnClear, 1, 5);
        gp.add(btnSave, 2, 5);
        //end fifth row of grid
        
        gp.add(btnView, 1, 6);
        gp.add(btnHelp, 2, 6);
        //end sixth row of grid
        //end add controls to gridpane
        //end setup gridpane
       
        Scene myScene = new Scene(gp);//set gridpane to scene
        primaryStage.setScene(myScene);
        primaryStage.show();
    }//end start override method

    public static void main(String[] args) {
        launch(args);
    }//end main method    
}//end Main class