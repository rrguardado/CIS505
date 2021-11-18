/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package GradeBookApp

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GuardadoGradeBookApp extends Application 
{
    private static final String FILE_NAME = "grades.csv";
    private static File file = new File(FILE_NAME);    
        
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
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
        
        //start event handlers
        //clear button click handler
        btnClear.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                tfFirstName.clear();
                tfLastName.clear();
                tfCourseName.clear();
                cboBoxGrades.getSelectionModel().clearSelection();
            }
        });//end setOnAction for btnClear              

        //save button click handler
        btnSave.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                //check for required values 
                if (tfFirstName.getText().equals("") || tfLastName.getText().equals("") || tfCourseName.getText().equals("") || cboBoxGrades.getValue() == null) 
                {
                    Alert missingInfoAlert = new Alert(AlertType.WARNING);
                    missingInfoAlert.setContentText("One or more required values are missing - please provide all required values!");
                    missingInfoAlert.show();                                        
                }//end if
                else 
                {
                    //prevent digits from being entered for first name/last name
                    if (tfFirstName.getText().matches(".*\\d+.*") || tfLastName.getText().matches(".*\\d+.*"))
                    {
                        Alert missingInfoAlert = new Alert(AlertType.WARNING);
                        missingInfoAlert.setContentText("Digits should not be used within values for student's name!");
                        missingInfoAlert.show();                            
                    }
                    else {
                        Student stu = new Student(tfFirstName.getText(), tfLastName.getText(), tfCourseName.getText(), cboBoxGrades.getValue());
                        try 
                        {
                            writeStudentToCSV(stu);
                            Alert savedAlert = new Alert(AlertType.INFORMATION);
                            savedAlert.setContentText("Data was successfully saved!");
                            savedAlert.show();                          
                        }
                        catch (Exception ex)
                        {
                            Alert cannotWriteFileAlert = new Alert(AlertType.ERROR);
                            cannotWriteFileAlert.setContentText("Could not save/write to the grades.csv file! Data was not saved.");
                            cannotWriteFileAlert.show();
                        }//end catch                                            
                    }
                }//end else                  
            }//end override handle            
        });//end setOnAction for btnSave
        
        btnView.setOnAction(new EventHandler<ActionEvent>() 
        {        
            @Override
            public void handle(ActionEvent e) 
            {
                try 
                {
                    if (file.exists() == false) 
                    {
                        Alert noFileAlert = new Alert(AlertType.WARNING);
                        noFileAlert.setContentText("Grades file is empty - no grades to show!");
                        noFileAlert.show();
                    }
                    else 
                    {
                        Process notepad = new ProcessBuilder("C:\\windows\\notepad.exe", "grades.csv").start();                
                    }
                }//end try
                catch (Exception ex2) 
                {
                    Alert noNotepadAlert = new Alert(AlertType.ERROR);
                    noNotepadAlert.setContentText("Windows Notepad application failed to launch. Windows OS with C:\\Windows\\notepad.exe is required to view grades!");
                    noNotepadAlert.show();
                }//end catch
            }//end override handle
        });//end setOnAction for btnView
        
        btnHelp.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) {
                Alert helpAlert = new Alert(AlertType.INFORMATION);
                helpAlert.setContentText("Welcome to GradeBookApp by Richard Guardado.\nWindows Notepad application at C:\\Windows\\notepad.exe is required to view grades!");
                helpAlert.show();                
            }//end override handle
        });//end setOnAction for btnHelp
        //end event handlers
        
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

    //start file IO    
    public static void writeStudentToCSV (Student studentToAdd) throws IOException 
    {       
        PrintWriter output = null;
        if (file.exists())
        {//open already existing grades.csv if it is there
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));            
        }
        else 
        {//grades.csv file does not exist, so ensure that headers are put at top
            output = new PrintWriter(FILE_NAME);
            output.print("firstName,lastName,course,grade\n");      
        }        
        output.print(studentToAdd.toString());      
        output.close();
    }//end writeStudentToCSV   
    //end file IO

    public static void main(String[] args) 
    {
        launch(args);
    }//end main method    
}//end GuardadoGradeBookApp class