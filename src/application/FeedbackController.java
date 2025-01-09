package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class FeedbackController {

    @FXML
    private ImageView giff;
    
    @FXML
    public void initialize(){
        int gifDuration;
        
        Image gif;
        
        Timeline timeline;
        
        gif = new Image(getClass().getResource("resources/animacion.gif").toExternalForm());
        
        giff.setImage(gif);
        
        gifDuration = 4000;
        timeline = new Timeline(new KeyFrame(Duration.millis(gifDuration), e -> {
             
                    }));
                    timeline.setCycleCount(1); // Ejecutar una sola vez
                    timeline.play();
    }
    
     /**  @FXML
    public void iniciar(MouseEvent event) throws IllegalStateException, InterruptedException {
        
        int gifDuration;
        
        Image gif;
        
        Timeline timeline;
        
        gif = new Image(getClass().getResource("resources/animacion.gif").toExternalForm());
        
        giff.setImage(gif);
        
        gifDuration = 5000;
        timeline = new Timeline(new KeyFrame(Duration.millis(gifDuration), e -> {
             
                    }));
                    timeline.setCycleCount(1); // Ejecutar una sola vez
                    timeline.play();
    }*/

}

            
