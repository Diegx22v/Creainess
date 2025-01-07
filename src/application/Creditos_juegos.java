package application;
import javafx.animation.Animation.Status;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Platform;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
/**
 * Clase de creditos del proyecto
 * Maneja la logica de esta ventana
 * @author Diego V.
 * @version 1.1
 */
public class Creditos_juegos {
    /**
     *  Objeto VBox para contener el primer grupo
     */
    @FXML
    public VBox contenedor_vertical;
 /**
     *  Objeto Text para contener el primer grupo
     */
    @FXML
    public Text integrantes_d;
    
    /**
     *  Objeto VBox para contener el segundo grupo
     */
    @FXML
    public VBox Contenedor_vertical_dos;

    /**
     *  Objeto VBox para contener a los profesores
     */
    @FXML
    public VBox Contenedor_vertical_tres;
    
     /**
     *  Objeto Text para contener el segundo grupo
     */
    @FXML
    public Text integrantes_c;
     /**
     *  Objeto Text para contener los profesores
     */
    @FXML
    public Text profesores;

    /**
     *  Imagen de Techcon
     */
    @FXML
    public ImageView Techcom;

    /**
     *  Imagen de retorno
     */
    @FXML
    public ImageView Return_credits;


    /**
     *  Animacion de la imagen de retorno
     */
    public ScaleTransition credits_return_animation;

    /**
     * Inicializa las animaciones y metodos
     */
    @FXML
    public void initialize(){
        initialize_animation_return_credits();
        String texto_d = "* Diego Villota\n"
                + "* Dayana Torres\n"
                + "* Carlos Vélez\n"
                + "* Franklin Chunga\n";
        String texto_c = "* Danna Lopez\n"
                + "* Felix Mendoza\n"
                + "* Daniela Marcillo\n"
                + "* Valeria Arias\n";
        String texto_p = "* Lcda. Maria Fernanda Lavaye\n"
                + "* Lcdo. Anthony Sotomayor";
        integrantes_d.setText(texto_d);
        integrantes_c.setText(texto_c);
        profesores.setText(texto_p);
                }

    /**
     * Inicia una animacion
     */
    public void initialize_animation_return_credits() {

        credits_return_animation = new ScaleTransition(Duration.millis(150), Return_credits);
        credits_return_animation.setByX(0.15);
        credits_return_animation.setByY(0.10);
        credits_return_animation.setAutoReverse(true);
        credits_return_animation.setCycleCount(2);
    }

    /**
     * verifica la ejecucion de la animacion
     * @param animacion recoge la animacion
     */
    public void animacion_image(ScaleTransition animacion) {
        if (animacion.getStatus() != Status.RUNNING) {
            animacion.playFromStart();
        }
    }

    /**
     * Inicia la animacion
     */
    @FXML
   public  void softimage1() {
        animacion_image(credits_return_animation);
    }

    /**
     * Cierra la ventana actual y regresa a la anterior
     */
    @FXML
    public void return_main1() {
        try {
            Return_credits.setDisable(true);
             Stage stage = (Stage) Return_credits.getScene().getWindow();
            stage.close();
            double baseWidth = 1920;
            double baseHeight = 1080;
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            double screenWidth = screenBounds.getWidth();
            double screenHeight = screenBounds.getHeight();
            Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
            stage.getIcons().add(icono);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("juegos.fxml"));
            javafx.scene.control.ScrollPane main = loader.load();
            Group scalableGroup = new Group(main);
            Scene scene = new Scene(new StackPane(scalableGroup), screenWidth, screenHeight);
            scene.getStylesheets().add(getClass().getResource("resources/interfaz_principal.css").toExternalForm());
            double scaleX = screenWidth / baseWidth;
            double scaleY = screenHeight / baseHeight;
            double scale = Math.min(scaleX, scaleY); 
            scalableGroup.setScaleX(scale);
            scalableGroup.setScaleY(scale);
            StackPane stackPane = (StackPane) scene.getRoot();
            stackPane.setAlignment(Pos.CENTER);
            stage.setMaximized(true);
            stage.setTitle("Juegos locos Franklin");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            // ALERTA`
            alerta_de_error(e);
        }finally{
            Return_credits.setDisable(false);
        }
    }

    /**
     * Crea una alerta de error
     * @param e recoge el error
     */
    public void alerta_de_error(Exception e) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error en la Aplicación");
        errorAlert.setHeaderText("Error en la ejecución");
        errorAlert.setContentText("error: "+e);
        Stage errores = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        errores.getIcons().add(new Image(getClass().getResourceAsStream("resources/error_icon.png")));
        errorAlert.showAndWait();
    }
}