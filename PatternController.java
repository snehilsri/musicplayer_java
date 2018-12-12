package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatternController implements Initializable{
	@FXML
	private TextField usertxt;
	@FXML
	public ListView<String> listview;
	ObservableList<String> list=FXCollections.observableArrayList();
	ObservableList<String> list2=FXCollections.observableArrayList("dil hai tumhara","dil to Pagal Hai","love Aal Kal","love Dose","in Dino");
	public ObservableList<String> list3;
	public static volatile int shared;
	public void login(ActionEvent event)throws Exception
	{
		String pat=usertxt.getText();
		for(int i=0;i<5;i++)
		{
	    KMPSearch(pat,list2.get(i));
		}
		
	}
	void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        int lps[] = new int[M];
        int j = 0; 
        computeLPSArray(pat,M,lps);
 
        int i = 0; 
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                System.out.println("Found pattern "+
                              "at index " + (i-j));
                list.add(txt);
                j = lps[j-1];
            }
 
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
    }
 
    void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0; 
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else 
            {
                if (len != 0)
                {
                    len = lps[len-1];
 
                  
                }
                else  
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listview.setItems(list);
		
	}
	public void btnAction(ActionEvent event)throws Exception
	{
			list3=listview.getSelectionModel().getSelectedItems();
			if(list3.get(0).equals("in Dino"))
				shared=5;
			if(list3.get(0).equals("dil hai tumhara"))
				shared=4;
			if(list3.get(0).equals("dil to Pagal Hai"))
				shared=3;
			if(list3.get(0).equals("love Aal Kal"))
				shared=2;
			if(list3.get(0).equals("love Dose"))
				shared=1;
			listview.getItems().clear();
			System.out.println(shared);
			Stage primaryStage2=new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/application/Player.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage2.setTitle("Media Player");
			primaryStage2.setScene(scene);
			primaryStage2.show();
			
	}
	public void btn6(ActionEvent event) throws Exception{
		Stage primaryStage7=new Stage();
		Parent root =FXMLLoader.load(getClass().getResource("/application/WebView.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage7.setTitle("Media Player");
		primaryStage7.setScene(scene);
		primaryStage7.show();
		
	}

}
