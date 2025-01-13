package application;

import java.awt.Desktop;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.animation.Animation.Status;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;

/**
 * Clase principal del menú de la aplicación.
 * Maneja la lógica y las animaciones de la interfaz principal.
 * @author Diego V.
 * @version 1.0
 */
public class menu_principal {

    /**
     * Objeto ImageView para mostrar y accionar el logo del proyecto
     * Contiene la imagen del proyecto
     */
    @FXML
    public ImageView Techcom;
    
    /*
        Boton para dirigirse a soporte
    */
    @FXML
    public Button soporte;


    /**
     * Objeto ImageView para mostrar una imagen
     * Contiene la imagen del colegio
     */
    @FXML
    public ImageView Delfos;

    /**
     * Objeto ImageView para mostrar una imagen
     * Contiene la imagen de vision
     */
    @FXML
    public ImageView Vision;

    /**
     * Objeto ImageView para mostrar una imagen
     * Contiene la imagen de mision
     */
    @FXML
    public ImageView Mision;

    /**
     * Objeto ImageView para mostrar una imagen
     * Contiene la imagen de deepfake
     */
    @FXML
    public ImageView Deepfake;

    /**
     * Objeto ImageView para mostrar una imagen
     * Contiene la imagen de clonacion de voz
     */
    @FXML
    public ImageView Clonacion_de_voz;

    /**
     * Objeto ImageView para mostrar una imagen
     * Contiene la imagen de creditos
     */
    @FXML
    public ImageView Creditos;
    
    
    /**
     Objeto ImageView para las imagenes
     * */
    
    @FXML
    public GridPane main;

    /**
     * Objeto ScaleTransition para la imagen Techcom
     */
    public ScaleTransition animacionTechcom;

    /**
     * Objeto ScaleTransition para el boton de Deepfake
     */
    public ScaleTransition animacion_de_inicio;
    /**
     * Objeto ScaleTransition para el boton de clonacion de voz
     */
    public ScaleTransition  animacion_de_soporte;
    /**
     * Objeto ScaleTransition para el boton de creditos
     */
    public ScaleTransition  animacion_creditos;

    /**
     * Objeto Button para ventana de creditos
     */
    @FXML
    public Button creditos;

    
    /**
     * Objeto HBox para contener los circulos
     */
    @FXML
    public HBox historias;
    
    /*
        Circulo 1
    */
    @FXML
    public Circle clip1;
    
    
    @FXML
    public ImagePattern ajaj;
    
    /**
     * Objeto Button para la ventana de Deepfake
     */
    @FXML
    public Button inicio;
    
    /*
        VBOX de anclaje
    */
    @FXML
    public VBox inicio_uno;
    
     /*
        VBOX de anclaje
    */
    @FXML
    public VBox inicio_dos;
    
     /*
        VBOX de anclaje
    */
    @FXML
    public VBox inicio_tres;
    
     /*
        VBOX de anclaje
    */
    @FXML
    public VBox inicio_cuatro;
    
     /*
        VBOX de anclaje
    */
    @FXML
    public VBox inicio_cinco;
    
     /*
        VBOX de anclaje
    */
    @FXML
    public VBox inicio_seis;
    
    
      /*
        Texto de anclaje
    */
    @FXML
    public Text inicio_1;
    
     /*
        Texto de anclaje
    */
    @FXML
    public Text inicio_2;
    
     /*
        Texto de anclaje
    */
    @FXML
    public Text inicio_3;
    
     /*
        Texto de anclaje
    */
    @FXML
    public Text inicio_4;
    
     /*
        Texto de anclaje
    */
    @FXML
    public Text inicio_5;
    
     /*
        Texto de anclaje
    */
    @FXML
    public Text inicio_6;

    /**
     * Objeto Button para la ventana de Clonacion de voz
     */
    @FXML
    public Button clonacion_de_voz;
    /*
        Contenedor secundario
    */
    @FXML 
    public ScrollPane principio;

    
    /**
     * Inicializa los componentes gráficos, las animaciones y las acciones asociadas a los botones de la interfaz.
     * Esta funcion se llama automáticamente cuando la interfaz se carga.
     * <p>
     * Se realiza lo siguiente:
     * - Inicializa el motor de WebView para cargar un video de YouTube.
     * - Configura las animaciones para los botones de la interfaz.
     * - Configura las interacciones de los botones con animaciones al hacer clic.
     */
    @FXML
    public void initialize() {
        inicializarAnimacion_imagen_techcom();
        inicializarAnimacion_boton_inicio();
        inicializarAnimacion_boton_creditos();
        inicializarAnimacion_boton_soporte();
        inicializarAnimacion_boton_salir();
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        if (screenBounds.getWidth() != 1920.0 && screenBounds.getHeight() != 1080.0 ) {
            Insets padding = new Insets(25, 0, 10, 0);
            historias.setPadding(padding);
        }
        
        //inicializarAnimacion_boton_clonacion_de_voz();
        cargar_circulo();
        cargar_circulo2();
        cargar_circulo3();
        cargar_circulo4();
        cargar_circulo5();
        cargar_circulo6();
        //inicializarAnimacion_click_jugar();
        //inicializarAnimacion_click_salir();
        //int puntosIniciales = 0;
        //puntos.setText("Puntos: " + puntosIniciales);
    }

    /*
        Regresa al punto inicial del programa
    */
    @FXML
    public void regreso(){
         Platform.runLater(() -> {
        // Obtén la posición del nodo inicio_6 relativo al VBox (anclaje)
        double targetY = inicio_uno.getBoundsInParent().getMinY();

        // Obtén la altura total del VBox (contenido del ScrollPane)
        double totalHeight = principio.getContent().getBoundsInLocal().getHeight() - 1000;

        // Calcula el valor relativo para el desplazamiento
        double vvalue = targetY / (totalHeight - principio.getViewportBounds().getHeight());

        // Ajusta el desplazamiento para que esté entre 0 y 1
        principio.setVvalue(Math.max(0, Math.min(1, vvalue)));
    });

 
    
    }


  /*
        Regresa a la segunda publicacion  del programa
    */
    @FXML
    public void regreso_dos(){
         Platform.runLater(() -> {
        // Obtén la posición del nodo inicio_6 relativo al VBox (anclaje)
        double targetY = inicio_dos.getBoundsInParent().getMinY();

        // Obtén la altura total del VBox (contenido del ScrollPane)
        double totalHeight = principio.getContent().getBoundsInLocal().getHeight() - 1000;

        // Calcula el valor relativo para el desplazamiento
        double vvalue = targetY / (totalHeight - principio.getViewportBounds().getHeight());

        // Ajusta el desplazamiento para que esté entre 0 y 1
        principio.setVvalue(Math.max(0, Math.min(1, vvalue)));
    });
 
    
    }    
    
    
     /*
        Regresa a la tercera publicacion  del programa
    */
    @FXML
    public void regreso_tres(){
         Platform.runLater(() -> {
        // Obtén la posición del nodo inicio_6 relativo al VBox (anclaje)
        double targetY = inicio_tres.getBoundsInParent().getMinY();

        // Obtén la altura total del VBox (contenido del ScrollPane)
        double totalHeight = principio.getContent().getBoundsInLocal().getHeight() - 900;

        // Calcula el valor relativo para el desplazamiento
        double vvalue = targetY / (totalHeight - principio.getViewportBounds().getHeight());

        // Ajusta el desplazamiento para que esté entre 0 y 1
        principio.setVvalue(Math.max(0, Math.min(1, vvalue)));
    });
 
    
    }    
    
    
     /*
        Regresa a la cuarta publicacion  del programa
    */
    @FXML
    public void regreso_cuatro(){
         Platform.runLater(() -> {
        // Obtén la posición del nodo inicio_6 relativo al VBox (anclaje)
        double targetY = inicio_cuatro.getBoundsInParent().getMinY();

        // Obtén la altura total del VBox (contenido del ScrollPane)
        double totalHeight = principio.getContent().getBoundsInLocal().getHeight() - 800;

        // Calcula el valor relativo para el desplazamiento
        double vvalue = targetY / (totalHeight - principio.getViewportBounds().getHeight());

        // Ajusta el desplazamiento para que esté entre 0 y 1
        principio.setVvalue(Math.max(0, Math.min(1, vvalue)));
    });
 
    
    }    
    
     /*
        Regresa a la quinta publicacion  del programa
    */
    @FXML
    public void regreso_cinco(){
        Platform.runLater(() -> {
        // Obtén la posición del nodo inicio_6 relativo al VBox (anclaje)
        double targetY = inicio_cinco.getBoundsInParent().getMinY();

        // Obtén la altura total del VBox (contenido del ScrollPane)
        double totalHeight = principio.getContent().getBoundsInLocal().getHeight() - 800;

        // Calcula el valor relativo para el desplazamiento
        double vvalue = targetY / (totalHeight - principio.getViewportBounds().getHeight());

        // Ajusta el desplazamiento para que esté entre 0 y 1
        principio.setVvalue(Math.max(0, Math.min(1, vvalue)));
    });

 
    
    }    
    
     /*
        Regresa a la sexta publicacion  del programa
    */
    @FXML
    public void regreso_seis(){
        Platform.runLater(() -> {
        // Obtén la posición del nodo inicio_6 relativo al VBox (anclaje)
        double targetY = inicio_seis.getBoundsInParent().getMinY();

        // Obtén la altura total del VBox (contenido del ScrollPane)
        double totalHeight = principio.getContent().getBoundsInLocal().getHeight() - 1000;

        // Calcula el valor relativo para el desplazamiento
        double vvalue = targetY / (totalHeight - principio.getViewportBounds().getHeight());

        // Ajusta el desplazamiento para que esté entre 0 y 1
        principio.setVvalue(Math.max(0, Math.min(1, vvalue)));
    });
        
    }    
    
    
    
    
    /*
        Primer circulo para contener imagen
    */
    public void cargar_circulo(){
        clip1.setCenterX(150);
        clip1.setCenterY(150);
        // Cargar la imagen
        Image id = new Image(getClass().getResource("resources/circulo_uno.jpg").toExternalForm());
        // Aplicar la imagen al círculo como patrón
        clip1.setFill(new ImagePattern(id));
    }
    
    /*
        Segundo circulo para contener imagen
    */
    @FXML
    public Circle clip2;
    
    /*
        Segundo circulo para contener imagen
    */
    public void cargar_circulo2(){
        // define X
        clip2.setCenterX(150);
        // define Y
        clip2.setCenterY(150);
        // Obtener imagen con los metodos getClass getResource y pasarlo a forma externa
        Image id = new Image(getClass().getResource("resources/circulo_dos.jpg").toExternalForm());
        // establecer llenado del circulo por la imagen
        clip2.setFill(new ImagePattern(id));
    }
    
    /*
        Tercer circulo para contener imagen
    */
    @FXML
    public Circle clip3;
    
     /*
        Tercer circulo para contener imagen
    */
    public void cargar_circulo3(){
        clip3.setCenterX(150);
        clip3.setCenterY(150);
        Image id = new Image(getClass().getResource("resources/circulo_tres.jpg").toExternalForm());
        clip3.setFill(new ImagePattern(id));
    }
    
     /*
        Cuarto circulo para contener imagen
    */
    @FXML
    public Circle clip4;
    
     /*
        Cuarto circulo para contener imagen
    */
    public void cargar_circulo4(){
        clip4.setCenterX(150);
        clip4.setCenterY(150);
        Image id = new Image(getClass().getResource("resources/circulo_cuatro.jpg").toExternalForm());
        clip4.setFill(new ImagePattern(id));
    }
    
     /*
        Quinto circulo para contener imagen
    */
    @FXML
    public Circle clip5;
    
     /*
        Quinto circulo para contener imagen
    */
    public void cargar_circulo5(){
        clip5.setCenterX(150);
        clip5.setCenterY(150);
        Image id = new Image(getClass().getResource("resources/circulo_cinco.jpg").toExternalForm());        
        clip5.setFill(new ImagePattern(id));
    }
    
     /*
        Sexto circulo para contener imagen
    */
    @FXML
    public Circle clip6;
    
     /*
        Sexto circulo para contener imagen
    */
    public void cargar_circulo6(){
        clip6.setCenterX(150);
        clip6.setCenterY(150);        
        Image id = new Image(getClass().getResource("resources/circulo_seis.jpg").toExternalForm());        
        clip6.setFill(new ImagePattern(id));
    }
    
    
    
    /**
     * Crea una animacion para el boton clonacion de voz (operativa)
     */
    public void inicializarAnimacion_boton_soporte() {

        animacion_de_soporte = new ScaleTransition(Duration.millis(150), soporte);
        animacion_de_soporte.setByX(0.02);
        animacion_de_soporte.setByY(0.02);
        animacion_de_soporte.setAutoReverse(true);
        animacion_de_soporte.setCycleCount(2);
    }

    /**
     * ejecucion (handler) de animacion
     */
    @FXML
    public void soft_soporte() {
        animacion_soft_soporte(animacion_de_soporte);
    }



    /**
     * Recibe el objeto animacion_uno para la animacion del boton de Clonacion de voz
     *
     * @param animacion_de_clonacion necesita de un objeto scaletransition
     */
    public void animacion_soft_soporte(ScaleTransition animacion_de_clonacion) {
        if (animacion_de_clonacion.getStatus() != Status.RUNNING) {
            animacion_de_clonacion.playFromStart();
        }
    }



    /**
     * Crea una animacion para el boton deepfake (operativa)
     */
    public void inicializarAnimacion_boton_inicio() {

        animacion_de_inicio = new ScaleTransition(Duration.millis(150), inicio);
        animacion_de_inicio.setByX(0.02);
        animacion_de_inicio.setByY(0.02);
        animacion_de_inicio.setAutoReverse(true);
        animacion_de_inicio.setCycleCount(2);
    }
    /**
     * Verificacion de animacion (semi-obsoleta)
     *
     * @param animacion_de_deepfake necesita de un objeto ScaleTransition
     */
    public void animacion_soft_inicio(ScaleTransition animacion_de_inicio) {
        if (animacion_de_inicio.getStatus() != Status.RUNNING) {
            animacion_de_inicio.playFromStart();
        }
    }
    /**
     * ejecucion (handler) de animacion
     */
    @FXML
    public void soft_inicio() {
        animacion_soft_inicio(animacion_de_inicio);
    }

    
    @FXML
    public Button salir;
    
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

    /*
        Funcion para salir del programa
    */
    @FXML
    public void salir(){
        System.exit(0);
    }

    /**
     * Crea una animacion para el boton creditos (operativa)
     */
    public void inicializarAnimacion_boton_creditos() {

        animacion_creditos = new ScaleTransition(Duration.millis(150), creditos);
        animacion_creditos.setByX(0.02);
        animacion_creditos.setByY(0.02);
        animacion_creditos.setAutoReverse(true);
        animacion_creditos.setCycleCount(2);
    }

    /**
     * Verificacion de animacion (operativa)
     *
     * @param animacion_creditos necesita de un objeto ScaleTransition
     */
    public void animacion_soft_creditos(ScaleTransition animacion_creditos) {
        if (animacion_creditos.getStatus() != Status.RUNNING) {
            animacion_creditos.playFromStart();
        }
    }



    /**
     * ejecucion (handler) de animacion
     */



    /**
     * ejecucion (handler) de animacion
     */
    @FXML
    public void soft_creditos() {
        animacion_soft_creditos(animacion_creditos);

    }


    /**
     * ejecucion (handler) de video, pasando una url de YT
     * carga el video de deepfake
     */



    /**
     * ejecucion (handler) de video, pasando una url de YT
     * carga el video de clonacion de voz
     * espera a otro metodo
     */


    /**
     * Crea animacion de imagen
     */
    
    
    @FXML
    public Button juegos;
    
    public void inicializarAnimacion_imagen_techcom() {

        animacionTechcom = new ScaleTransition(Duration.millis(150), juegos);
        animacionTechcom.setByX(0.03);
        animacionTechcom.setByY(0.03);
        animacionTechcom.setAutoReverse(true);
        animacionTechcom.setCycleCount(2);
    }

    /**
     * Verifica su ejecucion
     *
     * @param animacionTechcom recoge la animacion de techcom
     */
    public void animacion_image(ScaleTransition animacionTechcom) {
        if (animacionTechcom.getStatus() != Status.RUNNING) {
            animacionTechcom.playFromStart();
        }
    }



    /**
     * Ejecucion de animacion
     */
    @FXML
    public void soft_techcom() throws IOException, URISyntaxException {
        animacion_image(animacionTechcom);

    }



    /**
     * crea ventana emergente para las excepciones y errores de la aplicacion
     *
     * @param e recoge el error
     */
    public void alerta_de_error(Exception e) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error en la Aplicación");
        errorAlert.setHeaderText("Error en la ejecución");
        errorAlert.setContentText("error: " + e);
        Stage errores = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        errores.getIcons().add(new Image(getClass().getResourceAsStream("resources/error_icon.png")));
        errorAlert.showAndWait();
    }

    /**
     * Reproduce un sonido
     */
    private MediaPlayer playsound;

    /**
     * Crea una ventana para Deepfake
     */
    
    /*@FXML
    public void ventana_deepfake() {
        try {
            if (playsound == null) {
                String audio = getClass().getResource("resources/deepfake_prueba.mp3").toExternalForm();
                Media sound = new Media(audio);
                playsound = new MediaPlayer(sound);
            }
            playsound.stop();
            playsound.play();
            animacion_image(animacionTechcom);
            Stage stage = (Stage) deepfake.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("deepfake.fxml"));
            Stage preguntas = new Stage();
            preguntas.setTitle("Deepfake");
            Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
            preguntas.getIcons().add(icono);
            Scene Deepfake = new Scene(root, 800, 600);
            preguntas.setMaximized(true);
            preguntas.setScene(Deepfake);
            Deepfake.getStylesheets().add(getClass().getResource("resources/menu_principal.css").toExternalForm());
            preguntas.show();
        } catch (Exception e) {
            alerta_de_error(e);
        }
    }*/

    /**
     * Crea un chat con el creador del software
*/
    @FXML
    public void apertura_soporte()throws URISyntaxException,IOException {
        try {
            Desktop.getDesktop().browse(new URI("https://api.whatsapp.com/send?phone=+5930968053751&text=Hola%21+Necesito+ayuda+con+el+software+de+Creainess"));
        } catch (Exception e) {
            alerta_de_error(e);
        }
    }

    /**
     * Cierra el programa por completo
     */
    @FXML
    public void exit() {
        System.exit(0);
    }

    
        /**
     * Reproduce un sonido
     */
    private MediaPlayer s_creditos;

           
    
    
    /**
     * Crea una ventana para creditos
     */
    @FXML
    public void ventana_creditos() {
        try {
            
             if (s_creditos == null) {
                String audio = getClass().getResource("resources/menciones.mp3").toExternalForm();
                Media sound = new Media(audio);
                s_creditos = new MediaPlayer(sound);
            }
            s_creditos.stop();
            s_creditos.play();
            
            
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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("creditos.fxml"));
            //GridPane main = loader.load(); // Se asegura de que el GridPane es el nodo raíz
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

            // Configuración del Stage
            stage.setMaximized(true);
            stage.setTitle("TECHCON");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            alerta_de_error(e);
        }
    }

        /**
     * Reproduce un sonido
     */
    private MediaPlayer s_juegos;

    
    /**
     * Crea una ventana para los juegos
     */
    @FXML
public void ventana_juegos() throws IllegalStateException, InterruptedException {
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("feedback.fxml"));
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

        // Configuración del Stage
        stage.setMaximized(true);
        stage.setTitle("TECHCON");
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        alerta_de_error(e);
    }
}


    

}