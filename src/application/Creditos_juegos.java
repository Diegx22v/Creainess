package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Creditos_juegos {

    @FXML
    private MediaView videocre;
    
    @FXML
    private Button buton;

    private MediaPlayer mediaPlayer;

    @FXML
    public void initialize() {
        try {
            // Ruta del video
            
            Media video = new Media(getClass().getResource("resources/CREDITOS_TECH-CON.mp4").toExternalForm());
            mediaPlayer = new MediaPlayer(video);
            videocre.setMediaPlayer(mediaPlayer);

            // Reproducir el video
            mediaPlayer.play();

            // Detectar cuando el video termine
            mediaPlayer.setOnEndOfMedia(() -> {
                Stage stage = (Stage) videocre.getScene().getWindow();
                stage.close();
                cargarPaginaPrincipal(stage);
                
            });
        } catch (Exception e) {
            alerta_de_error("Error al reproducir el video", e);
        }
    }
    @FXML
    void desavanzar(MouseEvent event) {
        
        mediaPlayer.setRate(1);
        buton.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
        + "-fx-border-width: 2; -fx-background-color: white;");
    }
    @FXML
    void avanzar(MouseEvent event) {

        mediaPlayer.setRate(2);
        buton.setStyle("-fx-border-color: #4d4d4d; -fx-border-radius: 100; -fx-background-radius: 100; "
        + "-fx-border-width: 2; -fx-background-color: gray;");
          
    }
    

    private void cargarPaginaPrincipal(Stage stage) {
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
        } catch (Exception e) {
            alerta_de_error("Error de carga", e);
        }
    }

    public void alerta_de_error(String header, Exception e) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Error en la Aplicación");
        errorAlert.setHeaderText(header);
        errorAlert.setContentText("Error: " + e.getMessage());
        Stage errores = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        errores.getIcons().add(new Image(getClass().getResourceAsStream("resources/error_icon.png")));
        errorAlert.showAndWait();
    }
}
