/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.jflex;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Scanner;

/**
 *
 * @author itt
 */
public class CompiladorJavaCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {   
            String path = "./src/ejemplo/jflex/entrada.txt";
            System.out.println("Análisis sintáctico iniciado:");
            MiLexico lexer = new MiLexico(new FileReader(path));
            MiParser parser = new MiParser((Scanner) lexer);
            parser.parse();
        } catch (Exception ex) {
            Logger.getLogger(CompiladorJavaCup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
