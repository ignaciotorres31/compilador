/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import compilador.ast.base.Impresion;
import compilador.sintactico.MiParser;
import compilador.lexico.MiLexico;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java_cup.runtime.Symbol;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Scanner;

/**
 *
 * @author Merce
 */
public class Compilador extends javax.swing.JFrame {
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
    private static javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration                  
    
    /**
     * Creates new form prueba
     */

    public Compilador() {
        this.setSize(400, 400);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Compilador");

        jToggleButton1.setText("Importar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jToggleButtonImportarActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButton1.setText("Análisis lexico");
        jButton2.setText("Análisis sintactico");
        jButton3.setText("AST");
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonOkActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton3ActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea);

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(484, 484, 484)
                .addComponent(jLabel1)
                .addContainerGap(486, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void jToggleButtonImportarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                               
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            selectedFile.createNewFile();
            FileReader entrada = new FileReader(selectedFile);
            BufferedReader in;
            in = new BufferedReader(entrada);
            jTextArea.read(in, null);
            in.close();
            jTextArea.requestFocus();
            /*MiLexico lexico = new MiLexico(entrada);
            while (true) {
                MiToken token = lexico.yylex();
                if (token == null)
                    break;
                System.out.println("Token: " + token.toString());}
            System.out.println("Análisis léxico terminado.");*/
        }
    }                                              

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        InputStream is = new ByteArrayInputStream(jTextArea.getText().getBytes());
        InputStreamReader reader = new InputStreamReader(is);
        MiLexico lexico = new MiLexico(reader);
        String outpout = "Token: ";
        try{
            while (true) {
                Symbol token = lexico.next_token();
                if (token.sym == 0)
                    break;
               outpout  +=  token.toString() + "\n";
            }
            System.out.println(outpout);
            jTextPane1.setText(outpout);
        }
        catch(Error e){
            System.out.println("Error: " + e.getMessage());
            jTextPane1.setText("Error: " + e.getMessage());
        }          
        System.out.println("Análisis léxico terminado.");
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        ConsoleOutputCapturer consoleOutputCapturer = new ConsoleOutputCapturer();
        try {   
            //String path = "./src/ejemplo/jflex/entrada.txt";
            InputStream is = new ByteArrayInputStream(jTextArea.getText().getBytes());
            InputStreamReader reader = new InputStreamReader(is);
            System.out.println("Análisis sintáctico iniciado:");
            MiLexico lexer = new MiLexico(reader);
            MiParser parser = new MiParser((Scanner) lexer);
            consoleOutputCapturer.start();
            parser.parse();
            parser.ht.forEach((tipo, valor) -> {  
            System.out.println("Tabla de simbolos: " + tipo.toString() + " " + valor.toString());
            });
            jTextPane1.setText(consoleOutputCapturer.stop());
        } catch (Exception ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        String textArea = jTextArea.getText() == null ? "" : jTextArea.getText();
        InputStream is = new ByteArrayInputStream(textArea.getBytes());
        InputStreamReader reader = new InputStreamReader(is);
        MiLexico lexico = new MiLexico(reader);
        MiParser sintactico= new MiParser(lexico);
        Impresion impresion = (Impresion) sintactico.parse().value;
     
        try {
            jTextPane1.setText(impresion.graficar());
            PrintWriter grafico = new PrintWriter(new FileWriter("arbol.dot"));
            grafico.println(impresion.graficar());
            grafico.close();
            String cmdDot = "dot -Tpng arbol.dot -o arbol.png";
            Runtime.getRuntime().exec(cmdDot);

        } catch (Error e) {
            System.out.println("Error: " + e.getMessage());
            jTextPane1.setText("Error: " + e.getMessage());
        }
    }
    
    public static void setJTextConsole(String message){
        Compilador.jTextPane1.setText(message);
    }
    
    public static void main(String[] args) throws IOException {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Compilador();
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
        

        /*FileReader entrada = new FileReader("./entrada.txt");
        MiLexico lexico = new MiLexico(entrada);
        //MiLexico lexico = new MiLexico(new InputStreamReader(System.in));
        //System.out.printf("Análisis léxico iniciado: %nIngrese por teclado:%n");
        while (true) {
            MiToken token = lexico.yylex();
            if (token == null)
                break;
            System.out.println("Token: " + token.toString());
        }
        System.out.println("Análisis léxico terminado.");*/

    }

    
}
