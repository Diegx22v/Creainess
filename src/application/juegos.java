package application;
import javafx.animation.Animation.Status;import javafx.animation.ScaleTransition;import javafx.fxml.FXML;import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;import javafx.scene.control.Alert;import javafx.scene.control.Alert.AlertType;import javafx.scene.control.Button;
import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.text.Text;import javafx.stage.Stage;import javafx.util.Duration;
import Utils.Ruleta;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    
    
    /*
        Texto de titulo
    */
    @FXML
    public Text tittle;
    
    
    private MediaPlayer mediaPlayer;

    /*
        Texto de SubTitulo
    */
    @FXML
    public Text subtittle;
    
    /*
        Texto de version (Obsoleto)
    */
    @FXML
    public Text version;
    

    /**
     * Objeto Button para salir del programa
     */
    @FXML
    public Button salir;
    
    
    /*
        Imagen / Gif de la ruleta
    */
    @FXML
    public ImageView gif_ruleta;
    
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
     initialize_animation_return_credits();
        try {
        String audio = getClass().getResource("resources/sans.mp3").toExternalForm();
        Media sound = new Media(audio);
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5); // Establecer volumen al 50%
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Reproducción infinita
        mediaPlayer.play(); // Iniciar reproducción
    } catch (Exception e) {
        alerta_de_error(e);
    }
}

public void alerta_de_error(Exception e) {
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    errorAlert.setTitle("Error en la Aplicación");
    errorAlert.setHeaderText("Error al reproducir música");
    errorAlert.setContentText("Detalles: " + e.getMessage());
    errorAlert.showAndWait();
}

    
    

    
    
    
    /**
     Objeto de ruleta.
     */
    public Ruleta n;
    
    public Ruleta personaje; 
    
    
    /**
     metodo para la ruleta.
     */
    public juegos(){
        n = new Ruleta();
    }
    
    
    /**
     metodo de ruleta para obtener el juego a jugar
     */
    /**
     metodo de ruleta para obtener el juego a jugar
     */
    @FXML
    public void ruleta() throws IllegalStateException, InterruptedException{
        try{  
            int numero;
            numero = n.obtenerNumero();
            Image gif;
            int gifDuration;
            Timeline timeline;
            switch (numero) {
                case 1:
                    System.out.println("primer juego cargado");
                    tittle.setVisible(false);
                    subtittle.setVisible(false);
                    version.setVisible(false);
                    jugar.setVisible(false);
                    creditos.setVisible(false);
                    salir.setVisible(false);
                    gif = new Image(getClass().getResource("resources/animacion.gif").toExternalForm());
                    gif_ruleta.setImage(gif);
                    gif_ruleta.setVisible(true);
                    
                    // Duración del GIF en milisegundos (modifica según tu GIF)
                    gifDuration = 5000;

                    // Usar un Timeline para restaurar los elementos tras la reproducción del GIF
                    timeline = new Timeline(new KeyFrame(Duration.millis(gifDuration), e -> {
                        gif_ruleta.setVisible(false); // Ocultar el GIF
                        gif_ruleta.setImage(null);   // Opcional: Limpiar referencia al GIF
            
                        // Mostrar elementos nuevamente
                        tittle.setVisible(true);
                        subtittle.setVisible(true);
                        version.setVisible(true);
                        jugar.setVisible(true);
                        creditos.setVisible(true);
                        salir.setVisible(true);
                    }));
                    timeline.setCycleCount(1); // Ejecutar una sola vez
                    timeline.play();
                                mediaPlayer.stop();
                    
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
                    tittle.setVisible(false);
                    subtittle.setVisible(false);
                    version.setVisible(false);
                    jugar.setVisible(false);
                    creditos.setVisible(false);
                    salir.setVisible(false);
                    gif = new Image(getClass().getResource("resources/animacion.gif").toExternalForm());
                    gif_ruleta.setImage(gif);
                    gif_ruleta.setVisible(true);
                    // Duración del GIF en milisegundos (modifica según tu GIF)
                    gifDuration = 5000;
                    // Usar un Timeline para restaurar los elementos tras la reproducción del GIF
                    timeline = new Timeline(new KeyFrame(Duration.millis(gifDuration), e -> {
                        gif_ruleta.setVisible(false); // Ocultar el GIF
                        gif_ruleta.setImage(null);   // Opcional: Limpiar referencia al GIF
                        // Mostrar elementos nuevamente
                        tittle.setVisible(true);
                        subtittle.setVisible(true);
                        version.setVisible(true);
                        jugar.setVisible(true);
                        creditos.setVisible(true);
                        salir.setVisible(true);
                    }));
                    timeline.setCycleCount(1); // Ejecutar una sola vez
                    timeline.play();
                    break;
                case 3:
                    System.out.println("tercer juego cargado");
                    /**
                    * CARGAR VIDEO DE RULETA Y DESAPARECER LOS ELEMENTOS PARA QUE SE QUEDE SOLO LA RULETA Y SU VIDEO
                    * TODA LA LOGICA DEL TERCER JUEGO 
                    * HECHO POR: FRANKLIN C.
                    */ 
                    tittle.setVisible(false);
                    subtittle.setVisible(false);
                    version.setVisible(false);
                    jugar.setVisible(false);
                    creditos.setVisible(false);
                    salir.setVisible(false);
                    gif = new Image(getClass().getResource("resources/animacion.gif").toExternalForm());
                    gif_ruleta.setImage(gif);
                    gif_ruleta.setVisible(true);
                    // Duración del GIF en milisegundos (modifica según tu GIF)
                    gifDuration = 5000;

                    // Usar un Timeline para restaurar los elementos tras la reproducción del GIF
                    timeline = new Timeline(new KeyFrame(Duration.millis(gifDuration), e -> {
                        gif_ruleta.setVisible(false); // Ocultar el GIF
                        gif_ruleta.setImage(null);   // Opcional: Limpiar referencia al GIF
            
                        // Mostrar elementos nuevamente
                        tittle.setVisible(true);
                        subtittle.setVisible(true);
                        version.setVisible(true);
                        jugar.setVisible(true);
                        creditos.setVisible(true);
                        salir.setVisible(true);
                    }));
                    timeline.setCycleCount(1); // Ejecutar una sola vez
                    timeline.play();
                    break;
                case 4:
                    /**
                    * CARGAR VIDEO DE RULETA Y DESAPARECER LOS ELEMENTOS PARA QUE SE QUEDE SOLO LA RULETA Y SU VIDEO
                    * TODA LA LOGICA DEL CUARTO JUEGO 
                    * HECHO POR: FRANKLIN C.
                    */ 
                    tittle.setVisible(false);
                    subtittle.setVisible(false);
                    version.setVisible(false);
                    jugar.setVisible(false);
                    creditos.setVisible(false);
                    salir.setVisible(false);
                    gif = new Image(getClass().getResource("resources/animacion.gif").toExternalForm());
                    gif_ruleta.setImage(gif);
                    gif_ruleta.setVisible(true);
                    System.out.println("cuarto juego cargado");
                    // Duración del GIF en milisegundos (modifica según tu GIF)
                    gifDuration = 5000;

                    // Usar un Timeline para restaurar los elementos tras la reproducción del GIF
                    timeline = new Timeline(new KeyFrame(Duration.millis(gifDuration), e -> {
                        gif_ruleta.setVisible(false); // Ocultar el GIF
                        gif_ruleta.setImage(null);   // Opcional: Limpiar referencia al GIF
            
                        // Mostrar elementos nuevamente
                        tittle.setVisible(true);
                        subtittle.setVisible(true);
                        version.setVisible(true);
                        jugar.setVisible(true);
                        creditos.setVisible(true);
                        salir.setVisible(true);
                    }));
                    timeline.setCycleCount(1); // Ejecutar una sola vez
                    timeline.play();
                    break;
                default:
                    System.out.println("error");
                }
        }catch(IllegalStateException e){
            alerta_de_error("Cantidad de juegos excedida",e);
            Stage stage = (Stage) salir.getScene().getWindow();
            stage.close();
        }
        try {
    // Cerrar la ventana actual
    Stage currentStage = (Stage) salir.getScene().getWindow();
    currentStage.close();
    
    // Resolución base
    double baseWidth = 1920;
    double baseHeight = 1080;
    
    // Detectar resolución de pantalla
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double screenWidth = screenBounds.getWidth();
    double screenHeight = screenBounds.getHeight();
    
    // Cargar el archivo FXML
    FXMLLoader loader = new FXMLLoader(getClass().getResource("juego1.fxml"));
    ScrollPane main = loader.load();
    
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
    
    // Crear y configurar un nuevo Stage
    //Stage newStage = new Stage();
    currentStage.setMaximized(true);
    currentStage.setTitle("TECHCON");
    currentStage.setScene(scene);
    
    // Configuración del ícono
    Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
    currentStage.getIcons().add(icono);
    
    // Detener el reproductor de audio si está activo
    if (mediaPlayer != null) {
        mediaPlayer.stop();
    }
    
    // Mostrar la nueva ventana
    currentStage.show();
} catch (IOException ex) {
    Logger.getLogger(Juego2.class.getName()).log(Level.SEVERE, null, ex);
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
            mediaPlayer.stop();
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
    
    /*
        Animacion para la imagen de retorno
    */
    @FXML
    public ScaleTransition credits_return_animation;
    
    /*
        Imagen de retorno
    */
    @FXML
    public ImageView Return_credits;
    
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
            jugar.setDisable(true);
            Stage cerrar = (Stage) jugar.getScene().getWindow();
            cerrar.close();
                      
            Stage primaryStage = new Stage();
            double baseWidth = 1920;
            double baseHeight = 1080;

            // Detectar resolución de pantalla
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            double screenWidth = screenBounds.getWidth();
            double screenHeight = screenBounds.getHeight();

            // Configuración de la ventana principal
            Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
            primaryStage.getIcons().add(icono);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu_principal.fxml"));
            GridPane main = loader.load(); // Se asegura de que el GridPane es el nodo raíz

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
            primaryStage.setMaximized(true);
            primaryStage.setTitle("Contribuidores");
            primaryStage.setScene(scene);
            primaryStage.show();

            // Mostrar la nueva ventana
            cerrar.close();
        } catch (Exception e) {
            // ALERTA`
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error en la Aplicación");
            errorAlert.setHeaderText("Error en la ejecución");
            errorAlert.setContentText("error: " + e);

            Stage errores = (Stage) errorAlert.getDialogPane().getScene().getWindow();
            errores.getIcons().add(new Image(getClass().getResourceAsStream("resources/error_icon.png")));
            errorAlert.showAndWait();
        }finally{
            jugar.setDisable(false);
        }
    }
    

}
