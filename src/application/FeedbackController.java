package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FeedbackController {

    @FXML
    private ImageView giff;
    
    @FXML
    public void initialize()throws IllegalStateException, InterruptedException{
        int gifDuration;
        
        Image gif;
        
        Timeline timeline;
        
        gif = new Image(getClass().getResource("resources/animacion.gif").toExternalForm());
        
        giff.setImage(gif);
        
        gifDuration = 4000;
        timeline = new Timeline(new KeyFrame(Duration.millis(gifDuration), e -> {
            Stage stage = (Stage) giff.getScene().getWindow();
            stage.close();
            try {
            double baseWidth = 1920;
            double baseHeight = 1080;

            // Detectar resolución de pantalla
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            double screenWidth = screenBounds.getWidth();
            double screenHeight = screenBounds.getHeight();

            // Configuración de la ventana principal
            Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
            stage.getIcons().add(icono);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("juegos.fxml"));
            //GridPane main = loader.load(); // Se asegura de que el GridPane es el nodo raíz
            javafx.scene.control.ScrollPane main = loader.load();
            // Crear un grupo para aplicar el escalado al contenido
            Group scalableGroup = new Group(main);

            // Crear una escena con la resolución detectada
            Scene scene = new Scene(new StackPane(scalableGroup), screenWidth, screenHeight);
            scene.getStylesheets().add(getClass().getResource("resources/interfaz_principal.css").toExternalForm());

            // Calcular el factor de escalado
            double scaleX = screenWidth / baseWidth;
            double scaleY = screenHeight / baseHeight;
            double scale = Math.min(scaleX, scaleY); // Mantener proporciones

            // Aplicar el escalado
            scalableGroup.setScaleX(scale);
            scalableGroup.setScaleY(scale);

            // Centrar el contenido escalado en la ventana
            StackPane stackPane = (StackPane) scene.getRoot();
            stackPane.setAlignment(Pos.CENTER);

            // Configuración del Stage
            stage.setMaximized(true);
            stage.setTitle("TECHCON");
            stage.setScene(scene);
            stage.show();
        } catch (Exception a) {
            alerta_de_error("Error de carga",a);
        }
                    }));
                    timeline.setCycleCount(1);
                    timeline.play();
    }
    public void alerta_de_error(String header,Exception a) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Error en la Aplicación");
        errorAlert.setHeaderText(header);
        errorAlert.setContentText("error: " + a);
        Stage errores = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        errores.getIcons().add(new Image(getClass().getResourceAsStream("resources/error_icon.png")));
        errorAlert.show();
    }
}

            
