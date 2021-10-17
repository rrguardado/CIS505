/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package GuardadoEnhancedFutureValueApp;

import java.util.Set;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.text.DecimalFormat;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Guardado Future Value App");
       
        //start setup form controls
        TextField txtFieldMonthlyPayment = new TextField();
        TextField txtFieldInterestRate = new TextField();
               
        Label lblMonthlyPayment = new Label("Monthly Payment:  ");      
        Label lblInterestRateFormat = new Label("Interest Rate:          ");

        Label lblInterestInstructionRed = new Label("Enter 11.1% as 11.1");
        lblInterestInstructionRed.setTextFill(javafx.scene.paint.Color.RED);// Set the font color of the interest rate instructions to red.
       
        Label lblYears = new Label("Years:                                                    ");                
        ComboBox<Integer> cboBoxYears = new ComboBox<Integer>();
        List<Integer> yearsList = new ArrayList<Integer>(Arrays.asList(0,1,2));
        cboBoxYears.getItems().addAll(yearsList);
        
        Button btnClear = new Button("Clear");
        Button btnCalculate = new Button("Calculate");
               
        Label lblCalcAsOfDate = new Label();
                
        TextArea calcOutputTextArea = new TextArea();
        calcOutputTextArea.setPrefRowCount(7);
        calcOutputTextArea.setPrefColumnCount(19);
        //end setup form controls
       
        //start setup HBox containers to hold controls
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
        
        HBox currentDateContainer = new HBox();
        currentDateContainer.getChildren().add(lblCalcAsOfDate);

        HBox outputTaContainer = new HBox();
        outputTaContainer.setPadding(new Insets(15, 0, 15, 30));//set the container's padding
        outputTaContainer.setSpacing(10);//set the container's spacing
        outputTaContainer.getChildren().add(calcOutputTextArea); 
        //end setup HBox containers
        
        //start setup AnchorPane
        AnchorPane myAnchorPane = new AnchorPane(outputTaContainer, actionBtnContainer, currentDateContainer, comboBoxContainer, intInstrContainer, intRateContainer, monthlyContainer);
        myAnchorPane.setPrefSize(300, 340);
        
        myAnchorPane.setRightAnchor(monthlyContainer, 25.0);
        myAnchorPane.setRightAnchor(intRateContainer, 25.0);
        myAnchorPane.setRightAnchor(intInstrContainer, 25.0);
        myAnchorPane.setRightAnchor(actionBtnContainer, 25.0);
        myAnchorPane.setRightAnchor(currentDateContainer, 25.0);
        myAnchorPane.setRightAnchor(comboBoxContainer, 25.0);
                
        myAnchorPane.setBottomAnchor(monthlyContainer, 295.0);
        myAnchorPane.setBottomAnchor(intRateContainer, 270.0);
        myAnchorPane.setBottomAnchor(intInstrContainer, 245.0);
        myAnchorPane.setBottomAnchor(comboBoxContainer, 220.0);       
        myAnchorPane.setBottomAnchor(actionBtnContainer, 175.0);
        myAnchorPane.setBottomAnchor(currentDateContainer, 155.0);        
        myAnchorPane.setBottomAnchor(outputTaContainer, 0.0);        
        //end setup AnchorPane
        
        //start event handlers
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                txtFieldMonthlyPayment.clear();
                txtFieldInterestRate.clear();
                calcOutputTextArea.clear();
                lblCalcAsOfDate.setText("");
                cboBoxYears.getSelectionModel().select(0);
            }
        });//end override setOnAction for btnClear
        
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent e) {
               String monthlyPaymentText = txtFieldMonthlyPayment.getText();
               String interestRateText = txtFieldInterestRate.getText();
               int selectedYears = (int) cboBoxYears.getValue();               
               int monthlyPaymentInt = Integer.parseInt(monthlyPaymentText);
               double interestRateDbl = Double.parseDouble(interestRateText);              
               double futureValue = FinanceCalculator.calculateFutureValue(monthlyPaymentInt, interestRateDbl, selectedYears);
               
               lblCalcAsOfDate.setText("Calculation as of " + getTodaysDate()+ "                           ");
               
               DecimalFormat df = new DecimalFormat("0.00");
               calcOutputTextArea.setText("The future value is $" + df.format(futureValue));
           }
        });//end override setOnAction for btnCalculate
        //end event handlers
        
        Scene myScene = new Scene(myAnchorPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }//end start override method

    private static String getTodaysDate() {
        LocalDate ld = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String todaysDate = ld.format(dtf);
        return todaysDate;
    }//end getTodaysDate method

    public static void main(String[] args) {
        launch(args);
    }//end main method    
}//end Main class