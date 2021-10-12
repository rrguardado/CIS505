/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/


package FutureValueApp;

import java.util.Set;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class FutureValueApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Guardado Future Value App");
       
        TextField txtFieldMonthlyPayment = new TextField();
        TextField txtFieldInterestRate = new TextField();
       
        Label lblMonthlyPayment = new Label("Monthly Payment:  ");      
        Label lblInterestRateFormat = new Label("Interest Rate:          ");

        Label lblInterestInstructionRed = new Label("Enter 11.1% as 11.1");
        lblInterestInstructionRed.setTextFill(javafx.scene.paint.Color.RED);// Set the font color of the interest rate instructions to red.
       
        Label lblYears = new Label("Years:                                                    ");                
        ComboBox<Integer> cboBoxYears = new ComboBox<Integer>();        
        
        Button btnClear = new Button("Clear");
        Button btnCalculate = new Button("Calculate");
        
        TextArea calcOutputTextArea = new TextArea();
        calcOutputTextArea.setPrefRowCount(7);
        calcOutputTextArea.setPrefColumnCount(19);

        HBox outputTaContainer = new HBox();
        outputTaContainer.setPadding(new Insets(15, 0, 15, 30));//set the container's padding
        outputTaContainer.setSpacing(10);//set the container's spacing
        outputTaContainer.getChildren().add(calcOutputTextArea);
       
        HBox monthlyContainer = new HBox();
        monthlyContainer.getChildren().addAll(lblMonthlyPayment, txtFieldMonthlyPayment);
        monthlyContainer.setPadding(new Insets(2.5,0,2.5,0));
                
        HBox intRateContainer = new HBox();
        intRateContainer.getChildren().addAll(lblInterestRateFormat, txtFieldInterestRate);
        intRateContainer.setPadding(new Insets(2.5,0,2.5,0));
        
        HBox intInstrContainer = new HBox();
        intInstrContainer.getChildren().add(lblInterestInstructionRed);
        intInstrContainer.setPadding(new Insets(2.5,0,2.5,0));
        
        HBox comboBoxContainer = new HBox();
        comboBoxContainer.getChildren().addAll(lblYears, cboBoxYears);

        HBox actionBtnContainer = new HBox();//create a new HBox container
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));//set the container's padding
        actionBtnContainer.setSpacing(10);//set the container's spacing
        actionBtnContainer.getChildren().add(btnClear);//add the clear button to the container
        actionBtnContainer.getChildren().add(btnCalculate);//add the calculate button to the container

        AnchorPane myAnchorPane = new AnchorPane(outputTaContainer, actionBtnContainer, comboBoxContainer, intInstrContainer, intRateContainer, monthlyContainer);
        myAnchorPane.setPrefSize(300, 340);
              
        myAnchorPane.setRightAnchor(monthlyContainer, 25.0);
        myAnchorPane.setRightAnchor(intRateContainer, 25.0);
        myAnchorPane.setRightAnchor(intInstrContainer, 25.0);
        myAnchorPane.setRightAnchor(comboBoxContainer, 25.0);
        myAnchorPane.setRightAnchor(actionBtnContainer, 25.0);
        
        myAnchorPane.setBottomAnchor(monthlyContainer, 295.0);
        myAnchorPane.setBottomAnchor(intRateContainer, 270.0);
        myAnchorPane.setBottomAnchor(intInstrContainer, 245.0);
        myAnchorPane.setBottomAnchor(comboBoxContainer, 220.0);
        myAnchorPane.setBottomAnchor(actionBtnContainer, 175.0);
        myAnchorPane.setBottomAnchor(outputTaContainer, 0.0);

        Scene myScene = new Scene(myAnchorPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }//end start override

    public static void main(String[] args) {
        launch(args);
    }
}