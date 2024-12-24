package application;import javafx.animation.Animation.Status;import javafx.animation.ScaleTransition;import javafx.event.ActionEvent;import javafx.fxml.FXML;import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;import javafx.scene.Scene;import javafx.scene.control.Alert;import javafx.scene.control.Alert.AlertType;import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;import javafx.scene.control.Hyperlink;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;import javafx.scene.text.Text;import javafx.scene.web.WebEngine;import javafx.scene.web.WebView;
import javafx.stage.Stage;import javafx.util.Duration;
//import utils.Utils;
import Utils.Ruleta;
import java.awt.*;import java.io.IOException;import java.net.URI;import java.net.URISyntaxException;
/**
 * Clase de la ventana de juegos.
 * Maneja la lógica y  de los juegos.
 * @author Franklin C.
 * @version 1.0
 */
public class juegos {
    /**
     * Objeto Button para jugar
     */
    @FXML
    public Button jugar;

    /**
     * Objeto Button para salir del programa
     */
    @FXML
    public Button salir;
    
    
    /**
      Objeto Button para los creditos
     */
    @FXML
    public Button creditos;
    
    /**
     metodo para inicializar animaciones o eventos.
     */
    @FXML
    public void initialize(){
    }
    
    private Ruleta n;
    public juegos(){
        n = new Ruleta();
    }
    
    @FXML
    public void ruleta() throws IllegalStateException{
        try{  
            int numero;
            numero = n.obtenerNumero();
            switch (numero) {
                case 1:
                    System.out.println("primer juego cargado");
                    /**                    
                     * CARGAR VIDEO DE RULETA Y DESAPARECER LOS ELEMENTOS PARA QUE SE QUEDE SOLO LA RULETA Y SU VIDEO
                     * TODA LA LOGICA DEL PRIMER JUEGO 
                     * HECHO POR: FRANKLIN C.
                     */ 
                    break;
                case 2:
                    System.out.println("segundo juego cargado");
                    /**                    
                     * CARGAR VIDEO DE RULETA Y DESAPARECER LOS ELEMENTOS PARA QUE SE QUEDE SOLO LA RULETA Y SU VIDEO
                     * TODA LA LOGICA DEL SEGUNDO JUEGO 
                     * HECHO POR: FRANKLIN C.
                     */ 
                    break;
                case 3:
                    System.out.println("tercer juego cargado");
                    /**
                    * CARGAR VIDEO DE RULETA Y DESAPARECER LOS ELEMENTOS PARA QUE SE QUEDE SOLO LA RULETA Y SU VIDEO
                    * TODA LA LOGICA DEL TERCER JUEGO 
                    * HECHO POR: FRANKLIN C.
                    */ 
                    break;
                case 4:
                    /**
                    * CARGAR VIDEO DE RULETA Y DESAPARECER LOS ELEMENTOS PARA QUE SE QUEDE SOLO LA RULETA Y SU VIDEO
                    * TODA LA LOGICA DEL CUARTO JUEGO 
                    * HECHO POR: FRANKLIN C.
                    */ 
                    System.out.println("cuarto juego cargado");
                    break;
                default:
                    System.out.println("error");
                }
        }catch(IllegalStateException e){
            alerta_de_error("Cantidad de juegos excedida",e);
            Stage stage = (Stage) salir.getScene().getWindow();
            stage.close();
        }
    }
    
    
    /**
     * Metodo de cierre
     */
    @FXML
    public void salir(){
        System.exit(0);
    }
    
    
       /**
     * crea ventana emergente para las excepciones y errores de la aplicacion
     *
     * @param e recoge el error
     */
    public void alerta_de_error(String header,Exception e) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error en la Aplicación");
        errorAlert.setHeaderText(header);
        errorAlert.setContentText("error: " + e);
        Stage errores = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        errores.getIcons().add(new Image(getClass().getResourceAsStream("resources/error_icon.png")));
        errorAlert.showAndWait();
    }

}
