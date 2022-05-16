/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.sentencias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.factor.Entero;
import compilador.ast.expresiones.factor.Constante;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class SumaImpar extends Expresion{
    
    private Entero entero;
    private ArrayList<Expresion> lista;

    public SumaImpar(Entero entero, ArrayList<Expresion> lista) {
        this.entero = entero;
        this.lista = lista;
    }

    public Entero getEntero() {
        return entero;
    }
    public void setEntero(Entero entero) {
        this.entero = entero;
    }

    public ArrayList<Expresion> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Expresion> lista) {
        this.lista = lista;
    }    
    
   
    
}
