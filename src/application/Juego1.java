package application;

import Utils.Ruleta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.paint.Color.color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Juego1 {
    
    @FXML
    private Pane popup;

    @FXML
    private Button cB;

    @FXML
    private Button dB;

    @FXML
    private Button eB;
    
    @FXML
    private Text intentoss;
    
    private MediaPlayer mediaPlayer;

    @FXML
    private Text fT;
    
    private String  c = null, d = null, e = null, f = null, piunt = "/5";
    
    private int p = 0, attempts = 1;
    
    @FXML
    private Text pT;
    
    private Boolean activador;
     
    @FXML
    private ImageView borrador;
    
    /**
     Objeto de ruleta.
     */
    public Ruleta n;
    
    public Ruleta personaje; 
    
    @FXML
    private Text timer;
    
    private int timar = 30,timos = 0;
    
    private String po = ":";
    
    
    private Timeline timerTimeline; // Timeline para manejar el temporizador
      
    private void cambiarAEscenaJuegos() {
        try {
            Stage MYstage = (Stage) eB.getScene().getWindow();
            MYstage.close();

            double baseWidth = 1920;
            double baseHeight = 1080;

            // Detectar resolución de pantalla
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            double screenWidth = screenBounds.getWidth();
            double screenHeight = screenBounds.getHeight();

            // Configuración de la ventana principal
            Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
            MYstage.getIcons().add(icono);
            mediaPlayer.stop();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("juego2.fxml"));
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
            MYstage.setMaximized(true);
            MYstage.setTitle("TECHCON");
            MYstage.setScene(scene);
            MYstage.show();
        } catch (Exception e) {
            alerta_de_error("Error de carga", e);
        }
    }
    
    
   @FXML
void quitar(MouseEvent event) {
    popup.setVisible(false);
    try {
        // Cargar el audio
        String audio = getClass().getResource("resources/Undertale OST_ 032 - Run!.mp3").toExternalForm();
        Media sound = new Media(audio);
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.5); // Establecer volumen al 50%
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Reproducción infinita
        mediaPlayer.play(); // Iniciar reproducción

        // Detener cualquier temporizador previo
        if (timerTimeline != null) {
            timerTimeline.stop();
        }

        // Crear un nuevo temporizador
        timerTimeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (timar == 0) {
                if (timos > 0) {
                    timos--;
                    timar = 59; // Reiniciar segundos
                } else {
                    // Tiempo agotado
                    timos = 0;
                    timar = 0;
                    timerTimeline.stop();
                    cambiarAEscenaJuegos(); // Cambiar a la nueva escena
                    return;
                }
            } else {
                timar--; // Decrementar segundos
            }

            // Actualizar el texto del temporizador
            timer.setText(String.format("%d%s%02d", timos, po, timar));
        }));
        timerTimeline.setCycleCount(Timeline.INDEFINITE); // Ciclo infinito
        timerTimeline.play(); // Iniciar el temporizador
    } catch (Exception e) {
        alerta_de_error("Error de carga", e);
    }
}


    public Juego1(){
        n = new Ruleta();
    }
            public int numero = 0;
    @FXML
    public void logica()throws IllegalStateException, InterruptedException{
        try{
        numero = n.obtenerNumero();
          System.out.println("Número obtenido: " + numero);
            
            // Puedes verificar cuántos números quedan disponibles
            System.out.println("Números restantes en la ruleta: " + n.numeros.size());
      
       activador = (true);
       cB.setVisible(true);
       dB.setVisible(true);
       eB.setVisible(true);
       intentoss.setText(valueOf(attempts) + piunt);   
       for (int i = 0; i < 4; i++) {
       
            switch (numero) {
                case 1:
                    c = "8";
                    d = "4";
                    e = "16";
                    f = "2^3";
                    break;
                case 2:
                    c = "64";
                    d = "125";
                    e = "27";
                    f = "5^3";
                    break;
                case 3:
                    c = "27";
                    d = "9";
                    e = "81";
                    f = "3^4";
                    break;
                case 4:
                    c = "49";
                    d = "25";
                    e = "16";
                    f = "7^2";
                    break;
                case 5:
                    c = "64";
                    d = "256";
                    e = "512";
                    f = "4^4";
                    break;
                case 6:
                    c = "25";
                    d = "125";
                    e = "625";
                    f = "5^4";
                    break;
                case 7:
                    c = "1024";
                    d = "512";
                    e = "2048";
                    f = "2^10";
                    break;
                case 8:
                    c = "49";
                    d = "343";
                    e = "7";
                    f = "7^3";
                    break;
                case 9:
                    c = "6";
                    d = "9";
                    e = "36";
                    f = "6^2";
                    break;
                case 10:
                    c = "16";
                    d = "32";
                    e = "8";
                    f = "2^4";
                    break;
                case 11:
                    c = "12";
                    d = "144";
                    e = "24";
                    f = "12^2";
                    break;
                case 12:
                    c = "81";
                    d = "27";
                    e = "729";
                    f = "9^3";
                    break;
                case 13:
                    c = "512";
                    d = "128";
                    e = "256";
                    f = "8^3";
                    break;
                case 14:
                    c = "64";
                    d = "16";
                    e = "4";
                    f = "4^2";
                    break;
                case 15:
                    c = "25";
                    d = "50";
                    e = "100";
                    f = "10^2";
                    break;
                case 16:
                    c = "64";
                    d = "16";
                    e = "32";
                    f = "4^3";
                    break;
                case 17:
                    c = "10";
                    d = "1";
                    e = "100";
                    f = "10^0";
                    break;
                case 18:
                    c = "32";
                    d = "64";
                    e = "128";
                    f = "2^7";
                    break;
                case 19:
                    c = "400";
                    d = "40";
                    e = "100";
                    f = "20^2";
                    break;
                case 20:
                    c = "3";
                    d = "9";
                    e = "27";
                    f = "3^2";
                    break;
                default:
                    c = "";
                    d = "";
                    e = "";
                    f = "";
                    break;
                    
            }
            System.out.println("hola soy el case" + numero);
            cB.setText(c);
            dB.setText(d);
            eB.setText(e);
            fT.setText(f);
            timer.setText(valueOf(timos) + po + valueOf(timar));
            
       }
       
            
    }catch (Exception e) {            
            try {
    // Cerrar la ventana actual
    Stage currentStage = (Stage) eB.getScene().getWindow();
    currentStage.close();
    
    // Resolución base
    double baseWidth = 1920;
    double baseHeight = 1080;
    
    // Detectar resolución de pantalla
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double screenWidth = screenBounds.getWidth();
    double screenHeight = screenBounds.getHeight();
    
    // Cargar el archivo FXML
    FXMLLoader loader = new FXMLLoader(getClass().getResource("juego2.fxml"));
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
    Stage newStage = new Stage();
    newStage.setMaximized(true);
    newStage.setTitle("TECHCON");
    newStage.setScene(scene);
    
    // Configuración del ícono
    Image icono = new Image(getClass().getResourceAsStream("resources/TECHCOM.png"));
    newStage.getIcons().add(icono);
    
    // Detener el reproductor de audio si está activo
    if (mediaPlayer != null) {
        mediaPlayer.stop();
    }
                mediaPlayer = null;

    // Mostrar la nueva ventana
    newStage.show();
} catch (IOException ex) {
    Logger.getLogger(Juego2.class.getName()).log(Level.SEVERE, null, ex);
}

}


    }
        
    public void initialize()throws IllegalStateException, InterruptedException{
        logica();
        pT.setText(valueOf(p));  
        
       } 
   
    @FXML
    void click1(MouseEvent event)throws IllegalStateException, InterruptedException {
      
        if ((numero == 1)|| (numero == 4) ||(numero == 7) || (numero == 10) ||(numero == 13) ||(numero == 16) || (numero == 19)){
                
             p = p + 25;
             timar += 5;
             cB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                    + "-fx-border-width: 2; -fx-background-color: green;");
        }
        else{
            p = p - 25;
            cB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                    + "-fx-border-width: 2; -fx-background-color: red;");
            if(p <= 0){
        
            p = 0;
            }
        }
       
        cB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
        + "-fx-border-width: 2; -fx-background-color: white;");
         pT.setText(valueOf(p));
         logica();
         System.out.println("c");
         attempts++;
         intentoss.setText(valueOf(attempts) + piunt);
         timer.setText(valueOf(timos) + po + valueOf(timar));
         
        
    }
      

    @FXML
    void click2(MouseEvent event)throws IllegalStateException, InterruptedException {
        
        if ((numero == 2) || (numero == 5) ||(numero == 8) || (numero == 11) ||(numero == 14) ||(numero == 17) || (numero == 20)){
        
             p = p + 25;
             timar += 5;dB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                    + "-fx-border-width: 2; -fx-background-color: green;");
            
           
        }
        else{
            p = p - 25;
            dB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                    + "-fx-border-width: 2; -fx-background-color: red;");
            if(p <= 0){
        
            p = 0;
            }
        }
        
        dB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
        + "-fx-border-width: 2; -fx-background-color: white;");
         pT.setText(valueOf(p));
                  logica();

         System.out.println("d");
         attempts++;
         intentoss.setText(valueOf(attempts) + piunt);
        timer.setText(valueOf(timos) + po + valueOf(timar));
    }
       
    

    @FXML
    void click3(MouseEvent event)throws IllegalStateException, InterruptedException {
       
        if ( (numero == 3) || (numero == 6) ||(numero == 9) || (numero == 12) ||(numero == 15) ||(numero == 18)){
            
             p = p + 25;
             timar += 5;eB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                    + "-fx-border-width: 2; -fx-background-color: green;");
            
        }
        else{
            p = p - 25;
            eB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                    + "-fx-border-width: 2; -fx-background-color: red;");
            if(p <= 0){
        
            p = 0;
            
         
            }
        }
        
        eB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
        + "-fx-border-width: 2; -fx-background-color: white;");
         pT.setText(valueOf(p));
                  logica();

         System.out.println("e");
         attempts++;
         intentoss.setText(valueOf(attempts) + piunt);
        timer.setText(valueOf(timos) + po + valueOf(timar));
    }   
    
    @FXML
    void quitarpu(MouseEvent event) {
        if (activador == (true)){
        if(p >= 50){
        if ((numero == 1)|| (numero == 4) ||(numero == 7) || (numero == 10) ||(numero == 13) ||(numero == 16) || (numero == 19)){
             /*c*/   
             dB.setVisible(false);
             p -= 50;
             activador = false;
            
        }
        else if ((numero == 2) || (numero == 5) ||(numero == 8) || (numero == 11) ||(numero == 14) ||(numero == 17) || (numero == 20)){
            /*d*/ 
            eB.setVisible(false);
            p -= 50;
            activador = false;
            
        }
        else if ( (numero == 3) || (numero == 6) ||(numero == 9) || (numero == 12) ||(numero == 15) ||(numero == 18)){
            /*e*/ 
            cB.setVisible(false);
            p -= 50;
            activador = false;
            
        }
       }
      }
        pT.setText(valueOf(p));
    } 
   /**
     * crea ventana emergente para las excepciones y errores de la aplicacion
     *
     * @param e recoge el error
     * @param header le da un titulo a la alerta
     */
    public void alerta_de_error(String header,Exception e) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Error en la Aplicación");
        errorAlert.setHeaderText(header);
        errorAlert.setContentText("error: " + e);
        Stage errores = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        errores.getIcons().add(new Image(getClass().getResourceAsStream("resources/error_icon.png")));
        errorAlert.show();
    } 
}
