package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainControler {
@FXML
private Label lbl;
@FXML
private Label lbl2;
@FXML
private TextField usertxt;
@FXML
private TextField userpass;
@FXML
private TextField firstnametxt;
@FXML
private TextField lastnametxt;
@FXML
private TextField emailtxt;
@FXML
private TextField passwordtxt;
@FXML
public static volatile List<String> l1 = new ArrayList<String>();
public static volatile List<String> l2 = new ArrayList<String>();
public static volatile List<String> l3 = new ArrayList<String>();
public void login(ActionEvent event)throws Exception
{
	l1.add("user");
	l2.add("xyz");
	l3.add("pass");
	for(int i=0;i<l1.size();i++)
	{
		if((l1.get(i).equals(usertxt.getText())||usertxt.getText().equals("user"))&&(l3.get(i).equals(userpass.getText())||userpass.getText().equals("pass")))
		{
		lbl.setText("Login Successfull");
		Stage primaryStage2=new Stage();
		Parent root =FXMLLoader.load(getClass().getResource("/application/Pattern.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setTitle("Media Player");
		primaryStage2.setScene(scene);
		primaryStage2.show();
		break;
		}
	}
		lbl.setText("Login Fail");
}
public void register(ActionEvent event)throws Exception
{
	Stage primaryStage3=new Stage();
	Parent root =FXMLLoader.load(getClass().getResource("/application/Register.fxml"));
	Scene scene = new Scene(root);
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage3.setTitle("Media Player");
	primaryStage3.setScene(scene);
	primaryStage3.show();
	
}
public void register2(ActionEvent event)throws Exception
{
	if(firstnametxt.getText().equals("")||emailtxt.getText().equals("")||passwordtxt.getText().equals(""))
		lbl2.setText("Enter All Valid Fields");
	else{
	l1.add(firstnametxt.getText());
	l2.add(emailtxt.getText());
	l3.add(passwordtxt.getText());
	Stage primaryStage4=new Stage();
	Parent root =FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
	Scene scene = new Scene(root);
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage4.setTitle("Media Player");
	primaryStage4.setScene(scene);
	primaryStage4.show();

	}
}
}

