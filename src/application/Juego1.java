package application;

import Utils.Ruleta;
import static java.lang.String.valueOf;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Juego1 {

    @FXML
    private Button cB;

    @FXML
    private Button dB;

    @FXML
    private Button eB;

    @FXML
    private Text fT;
    
    private String  c = null, d = null, e = null, f = null;
    
    private int b,p = 100;
    
    @FXML
    private Text pT;
    
    
    /**
     Objeto de ruleta.
     */
    public Ruleta n;
    
    public Ruleta personaje; 
    
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
       
       for (int i = 0, intentos = 4; i < intentos; i++) {

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
                    c = "pendejo";
                    d = "pendejo";
                    e = "pendejo";
                    f = "pendejo";
                    break;
                    
            }
            System.out.println("hola soy el case" + numero);
            cB.setText(c);
            dB.setText(d);
            eB.setText(e);
            fT.setText(f);
            /**/
       }
            
    }catch (Exception e){
        
                    /**
                     * Cargas el juego en vez de mostrar la alerta o cerrar el programa 
                     */
                    System.exit(0);
                    //alerta_de_error("Error",e);
                    }
    }
    
    
    
    public void initialize()throws IllegalStateException, InterruptedException{
        logica();
        pT.setText(valueOf(p));
        
       }
    @FXML
    void click1(MouseEvent event)throws IllegalStateException, InterruptedException {
      
        if ((numero == 1)|| (numero == 4) ||(numero == 7) || (numero == 10) ||(numero == 13) ||(numero == 16) || (numero == 19)){
                
             p = p + 100;
            
        }
        else{
            p = p - 100;
        }
         pT.setText(valueOf(p));
         logica();
         System.out.println("c");
        
    }

    @FXML
    void click2(MouseEvent event)throws IllegalStateException, InterruptedException {
        
        if ((numero == 2) || (numero == 5) ||(numero == 8) || (numero == 11) ||(numero == 14) ||(numero == 17) || (numero == 20)){
        
             p = p + 100;
            
        }
        else{
            p = p - 100;
        }
         pT.setText(valueOf(p));
                  logica();

         System.out.println("d");
    }

    @FXML
    void click3(MouseEvent event)throws IllegalStateException, InterruptedException {
       
        if ( numero == 3 || (numero == 6) ||(numero == 9) || (numero == 12) ||(numero == 15) ||(numero == 18)){
            
             p = p + 100;
            
        }
        else{
            p = p - 100;
        }
         pT.setText(valueOf(p));
                  logica();

         System.out.println("e");
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
