/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.sentencias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.factor.StringLiteral;

/**
 *
 * @author Nacho
 */
public class Display extends Sentencia{
    
    private Expresion display;
    
    public Display(Expresion display){
        super("DISPLAY");
        this.display = display;
    }
    
    public Display(StringLiteral display){
        super("DISPLAY");
        this.display = display;
    }
    

    public Expresion getDisplay() {
        return display;
    }

    public void setDisplay(Expresion display) {
        this.display = display;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += display.graficar(getId());
        return grafico;
    }    

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
