package application;import javafx.animation.Animation.Status;import javafx.animation.ScaleTransition;import javafx.event.ActionEvent;import javafx.fxml.FXML;import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;import javafx.scene.Scene;import javafx.scene.control.Alert;import javafx.scene.control.Alert.AlertType;import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;import javafx.scene.control.Hyperlink;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;import javafx.scene.text.Text;import javafx.scene.web.WebEngine;import javafx.scene.web.WebView;
import javafx.stage.Stage;import javafx.util.Duration;
//import utils.Utils;
import Utils.Ruleta;
import java.awt.*;import java.io.IOException;import java.net.URI;import java.net.URISyntaxException;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
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
     inicializarAnimacion_boton_jugar();  
     inicializarAnimacion_boton_creditos(); 
     inicializarAnimacion_boton_salir(); 
    }
    
    /**
     Objeto de ruleta.
     */
    public Ruleta n;
    /**
     metodo para la ruleta.
     */
    public juegos(){
        n = new Ruleta();
    }
    /**
     metodo de ruleta para obtener el juego a jugar
     */
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
     * @param header le da un titulo a la alerta
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
    
    
    //@FXML
    //public Button salir;
    
    /**
     * Crea una animacion para el boton deepfake (operativa)
     */
    @FXML
    public ScaleTransition animacion_de_salir;
    
    public void inicializarAnimacion_boton_salir() {

        animacion_de_salir = new ScaleTransition(Duration.millis(150), salir);
        animacion_de_salir.setByX(0.02);
        animacion_de_salir.setByY(0.02);
        animacion_de_salir.setAutoReverse(true);
        animacion_de_salir.setCycleCount(2);
    }
    /**
     * Verificacion de animacion (semi-obsoleta)
     *
     * @param animacion_de_deepfake necesita de un objeto ScaleTransition
     */
    public void animacion_soft_salir(ScaleTransition animacion_de_deepfake) {
        if (animacion_de_deepfake.getStatus() != Status.RUNNING) {
            animacion_de_deepfake.playFromStart();
        }
    }
    /**
     * ejecucion (handler) de animacion
     */
    @FXML
    public void soft_salir() {
        animacion_soft_salir(animacion_de_salir);
    }
    
    //@FXML
    //public Button salir;
    
    /**
     * Crea una animacion para el boton deepfake (operativa)
     */
    @FXML
    public ScaleTransition animacion_de_jugar;
    
    public void inicializarAnimacion_boton_jugar() {

        animacion_de_jugar = new ScaleTransition(Duration.millis(150), jugar);
        animacion_de_jugar.setByX(0.02);
        animacion_de_jugar.setByY(0.02);
        animacion_de_jugar.setAutoReverse(true);
        animacion_de_jugar.setCycleCount(2);
    }
    /**
     * Verificacion de animacion (semi-obsoleta)
     *
     * @param animacion_de_jugar necesita de un objeto ScaleTransition
     */
    public void animacion_soft_jugar(ScaleTransition animacion_de_jugar) {
        if (animacion_de_jugar.getStatus() != Status.RUNNING) {
            animacion_de_jugar.playFromStart();
        }
    }
    /**
     * ejecucion (handler) de animacion
     */
    @FXML
    public void soft_jugar() {
        animacion_soft_jugar(animacion_de_jugar);
    }
    
    @FXML
    public ScaleTransition animacion_de_creditos;
    
    public void inicializarAnimacion_boton_creditos() {

        animacion_de_creditos = new ScaleTransition(Duration.millis(150), creditos);
        animacion_de_creditos.setByX(0.02);
        animacion_de_creditos.setByY(0.02);
        animacion_de_creditos.setAutoReverse(true);
        animacion_de_creditos.setCycleCount(2);
    }
    /**
     * Verificacion de animacion (semi-obsoleta)
     *
     * @param animacion_de_creditos necesita de un objeto ScaleTransition
     */
    public void animacion_soft_creditos(ScaleTransition animacion_de_creditos) {
        if (animacion_de_creditos.getStatus() != Status.RUNNING) {
            animacion_de_creditos.playFromStart();
        }
    }
    /**
     * ejecucion (handler) de animacion
     */
    @FXML
    public void soft_creditos() {
        animacion_soft_creditos(animacion_de_creditos);
    }
    /**
     * Crea una ventana para creditos
     */
    @FXML
    public void ventana_creditos() {
        try {
            Stage stage = (Stage) creditos.getScene().getWindow();
            stage.close();
            double baseWidth = 1920;
            double baseHeight = 1080;

            // Detectar resolución de pantalla
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            double screenWidth = screenBounds.getWidth();
            double screenHeight = screenBounds.getHeight();

            // Configuración de la ventana principal
            Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
            stage.getIcons().add(icono);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("creditos_juegos.fxml"));
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
        } catch (Exception e) {
            alerta_de_error("Error de carga",e);
        }
    }
    

}
