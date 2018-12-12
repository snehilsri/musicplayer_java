package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PlayerController implements Initializable {
	@FXML private MediaView mv;
	private MediaPlayer mp;
	@FXML Slider volumeSlider;
	private Media me;
	PatternController pat = new PatternController();
	public int qw =PatternController.shared;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String path="";
		if(qw==5)
		{path = new File("src/media/vid1.mp4").getAbsolutePath();
		System.out.println(path);}
		if(qw==4)
		{path = new File("src/media/vid2.mp4").getAbsolutePath();
		System.out.println(path);}
		if(qw==3)
		{path = new File("src/media/vid3.mp4").getAbsolutePath();
		System.out.println(path);}
		if(qw==2)
		{path = new File("src/media/vid4.mp4").getAbsolutePath();
		System.out.println(path);}
		if(qw==1)
		{path = new File("src/media/vid5.mp4").getAbsolutePath();
		System.out.println(path);}
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		//mp.setAutoPlay(true);
		DoubleProperty width = mv.fitWidthProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(),"width" ));
		height.bind(Bindings.selectDouble(mv.sceneProperty(),"height"));
		volumeSlider.setValue(mp.getVolume()*100);
		volumeSlider.valueProperty().addListener(new InvalidationListener(){

			@Override
			public void invalidated(Observable arg0) {
				mp.setVolume(volumeSlider.getValue()/100);
				
			}
			
			
		});
	}
	public void play(ActionEvent event){
		mp.play();
		mp.setRate(1);
	}
	public void pause(ActionEvent event){
		mp.pause();
	}
	public void start(ActionEvent event){
		mp.seek(mp.getStartTime());
		mp.stop();
	}
	public void last(ActionEvent event){
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}
	public void fast(ActionEvent event){
		mp.setRate(2);
	}
	public void slow(ActionEvent event){
		mp.setRate(.5);
	}
	public void relode(ActionEvent event){
		mp.seek(mp.getStartTime());
		mp.play();
	}
	

}
