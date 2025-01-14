package application;

import Utils.Ruleta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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

public class Juego2 {
    
    @FXML
    private Pane popup;

    @FXML
    private Button xB;

    @FXML
    private Button yB;

    @FXML
    private Button zB;
    
    @FXML
    private Text intentoss;
    
    private MediaPlayer mediaPlayer;

    @FXML
    private Text lT;
    
    private String  x = null, y = null, z = null, l = null, piunt = "/5";
    
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
            Stage MYstage = (Stage) zB.getScene().getWindow();
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


    public Juego2(){
        n = new Ruleta();
    }
            public int numero = 0;
    @FXML
    public void logicas()throws IllegalStateException, InterruptedException{
        try{
        numero = n.obtenerNumero();
          System.out.println("Número obtenido: " + numero);
            
            // Puedes verificar cuántos números quedan disponibles
            System.out.println("Números restantes en la ruleta: " + n.numeros.size());
      
       activador = (true);
       xB.setVisible(true);
       yB.setVisible(true);
       zB.setVisible(true);
       intentoss.setText(valueOf(attempts) + piunt); 
       for (int i = 0; i < 4; i++) {
       
            switch (numero) {
    case 1:
        x = "El cerebro";
        y = "El semáforo";
        z = "Un rey";
        l = "Órdenes da, órdenes recibe, algunas autoriza, otras las prohíbe ¿Qué es?";
        break;
    case 2:
        x = "Sí";
        y = "No";
        z = "No se puede determinar";
        l = "Tienes un cajón con 10 calcetines negros y 10 blancos. Cierras los ojos y sacas tres calcetines. ¿Tienes un par de calcetines iguales?";
        break;
    case 3:
        x = "Alicia";
        y = "Roberto";
        z = "Carlos";
        l = "Alicia mira a Roberto y Roberto mira a Carlos. Alicia está casada, Carlos no. ¿Una persona casada está mirando a una persona soltera?";
        break;
    case 4:
        x = "40 centavos";
        y = "60 centavos";
        z = "70 centavos";
        l = "Una pera cuesta 40 centavos, una banana 60 centavos y una ciruela 70 centavos. ¿Cuánto cuesta una manzana?";
        break;
    case 5:
        x = "Un router";
        y = "Un puerto";
        z = "Un firewall";
        l = "Si quieres conectarte conmigo, tu IP debes saber. Te doy acceso a redes, pero no me puedes ver. ¿Qué soy?";
        break;
    case 6:
        x = "Un disco duro";
        y = "Una memoria USB";
        z = "Un procesador";
        l = "No tengo piernas, pero corro veloz. Guardo tus datos, aunque no soy un cajón. ¿Qué soy?";
        break;
    case 7:
        x = "Un disco duro";
        y = "La RAM";
        z = "La ROM";
        l = "Aunque no soy humano, tengo memoria. Sin mí, tu computadora sería historia. ¿Qué soy?";
        break;
    case 8:
        x = "Una carpeta";
        y = "Un navegador";
        z = "Una aplicación";
        l = "En un solo clic me puedes abrir, y en mi interior, muchos datos puedes descubrir y guardar. ¿Qué soy?";
        break;
    case 9:
        x = "Almacenamiento en la nube";
        y = "Un servidor";
        z = "Un disco duro externo";
        l = "Aunque no soy un mago, puedo hacer aparecer. Guardo datos en la nube, para que los puedas ver. ¿Qué soy?";
        break;
    case 10:
        x = "El monitor";
        y = "El sistema operativo";
        z = "La ROM";
        l = "Me ves al encender la computadora, y sin mí no sabrías a dónde ir. Pero no me tocas, solo me observas.";
        break;
    case 11:
        x = "Un motor de búsqueda";
        y = "Un navegador";
        z = "Una base de datos";
        l = "Me buscas cuando necesitas aprender, investigar o curiosear. Soy rápido y siempre encuentro algo para mostrarte.";
        break;
    case 12:
        x = "Un software de modelado 3D";
        y = "Un sistema operativo";
        z = "Un navegador web";
        l = "Dicen que soy virtual, pero soy tan real como tus ideas. Te dejo crear mundos enteros con solo unos clics.";
        break;
    case 13:
        x = "Hardware";
        y = "Software";
        z = "Monitor";
        l = "No soy un ser físico, pero me dedico a las máquinas. Doy vida a lo digital y energía a las pantallas. ¿Qué soy?";
        break;
    case 14:
        x = "IA Estrecha o Específica (ANI)";
        y = "IA superdotada";
        z = "Clonación de voz";
        l = "Puedo hacer una sola tarea muy bien, como reconocer la voz o detectar imágenes, pero no pienso como un humano. ¿Qué soy?";
        break;
    case 15:
        x = "Superinteligencia Artificial";
        y = "Deepfake";
        z = "IA general";
        l = "Hoy soy solo una idea, pero si algún día llego, seré la más sabia del universo y superaría al humano en todo.";
        break;
    case 16:
        x = "Realidad virtual";
        y = "Realidad aumentada";
        z = "Realidad mixta";
        l = "Soy un creador virtual de mundos, que realza lo real con lo imaginado. ¿Qué soy?";
        break;
    case 17:
        x = "Sintaxis";
        y = "Compilador";
        z = "Algoritmo";
        l = "Como los cimientos de una casa, soy crucial para el código, para que el programa surja. ¿Quién soy yo?";
        break;
    case 18:
        x = "Android";
        y = "Windows";
        z = "Mac";
        l = "Soy un sistema operativo de código abierto basado en Unix, utilizado en servidores y dispositivos móviles. ¿Qué soy?";
        break;
    default:
        System.out.println("Número no reconocido: " + numero);
        x = "";
        y = "";
        z = "";
        l = "";
        break;
}


        }
            System.out.println("Texto seleccionado para el caso " + numero + ":");
           
            xB.setText(x);
            yB.setText(y);
            zB.setText(z);
            lT.setText(l);
            timer.setText(valueOf(timos) + po + valueOf(timar));
            
       
       
            
    } 
    catch (Exception i) {
    
        cambiarAEscenaJuegos();
        
    }
}
        
    public void initialize()throws IllegalStateException, InterruptedException{
        logicas();
        pT.setText(valueOf(p));  
        
       } 
   
    @FXML
void click1(MouseEvent event) throws IllegalStateException, InterruptedException {

    if ((numero == 1) || (numero == 4) || (numero == 7) || (numero == 10) || (numero == 13) || (numero == 16) || (numero == 19)) {
        p = p + 25;
        timar += 5;
        xB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                + "-fx-border-width: 2; -fx-background-color: green;");
    } else {
        p = p - 25;
        xB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                + "-fx-border-width: 2; -fx-background-color: red;");
        if (p <= 0) {
            p = 0;
        }
    }

    xB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
            + "-fx-border-width: 2; -fx-background-color: white;");
    pT.setText(valueOf(p));
    logicas();
    System.out.println("x");
    attempts++;
    intentoss.setText(valueOf(attempts) + piunt);
    timer.setText(valueOf(timos) + po + valueOf(timar));

}

@FXML
void click2(MouseEvent event) throws IllegalStateException, InterruptedException {

    if ((numero == 2) || (numero == 5) || (numero == 8) || (numero == 11) || (numero == 14) || (numero == 17) || (numero == 20)) {
        p = p + 25;
        timar += 5;
        yB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                + "-fx-border-width: 2; -fx-background-color: green;");
    } else {
        p = p - 25;
        yB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                + "-fx-border-width: 2; -fx-background-color: red;");
        if (p <= 0) {
            p = 0;
        }
    }

    yB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
            + "-fx-border-width: 2; -fx-background-color: white;");
    pT.setText(valueOf(p));
    logicas();

    System.out.println("y");
    attempts++;
    intentoss.setText(valueOf(attempts) + piunt);
    timer.setText(valueOf(timos) + po + valueOf(timar));

}

@FXML
void click3(MouseEvent event) throws IllegalStateException, InterruptedException {

    if ((numero == 3) || (numero == 6) || (numero == 9) || (numero == 12) || (numero == 15) || (numero == 18)) {
        p = p + 25;
        timar += 5;
        zB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                + "-fx-border-width: 2; -fx-background-color: green;");
    } else {
        p = p - 25;
        zB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
                + "-fx-border-width: 2; -fx-background-color: red;");
        if (p <= 0) {
            p = 0;
        }
    }

    zB.setStyle("-fx-border-color: gray; -fx-border-radius: 100; -fx-background-radius: 100; "
            + "-fx-border-width: 2; -fx-background-color: white;");
    pT.setText(valueOf(p));
    logicas();

    System.out.println("z");
    attempts++;
    intentoss.setText(valueOf(attempts) + piunt);
    timer.setText(valueOf(timos) + po + valueOf(timar));

}

@FXML
void quitarpu(MouseEvent event) {
    if (activador == (true)) {
        if (p >= 50) {
            if ((numero == 1) || (numero == 4) || (numero == 7) || (numero == 10) || (numero == 13) || (numero == 16) || (numero == 19)) {
                /*x*/
                yB.setVisible(false);
                p -= 50;
                activador = false;

            } else if ((numero == 2) || (numero == 5) || (numero == 8) || (numero == 11) || (numero == 14) || (numero == 17) || (numero == 20)) {
                /*y*/
                zB.setVisible(false);
                p -= 50;
                activador = false;

            } else if ((numero == 3) || (numero == 6) || (numero == 9) || (numero == 12) || (numero == 15) || (numero == 18)) {
                /*z*/
                xB.setVisible(false);
                p -= 50;
                activador = false;

            }
        pT.setText(valueOf(p));
        }
    }
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
        errorAlert.showAndWait();
    } 
}
