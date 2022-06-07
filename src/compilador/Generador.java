package compilador;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "./src/compilador/lexico/lexico.flex";
        generarLexer(path);
        
        String[] param = new String[5];
        param[0] = "-destdir";
        param[1] = "./src/compilador/sintactico/";
        param[2] = "-parser";
        param[3] = "MiParser";
        param[4] = "./src/compilador/sintactico/parser.cup";
        generarParser(param);
    }
    
    /**
     *
     * @param path
     */
    public static void generarLexer(String path){
        File file=new File(path);
        //jflex.Main.generate(file);
        //UTILIZAR JFLEX 1.8, la próxima línea no funciona para las versiones previas
        jflex.generator.LexGenerator generator = new jflex.generator.LexGenerator(file);
        generator.generate();
    }
    
    public static void generarParser(String[] param){
        try {
            java_cup.Main.main(param);
        } catch (IOException ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
