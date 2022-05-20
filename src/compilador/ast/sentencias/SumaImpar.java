/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.sentencias;

import compilador.ast.base.Nodo;
import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Identificador;
import compilador.ast.expresiones.factor.Entero;
import compilador.ast.expresiones.factor.Constante;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class SumaImpar extends Expresion{
    
    private Entero entero;
    private ArrayList<Sentencia> lista;
    private Identificador id; 

    public SumaImpar(Entero entero, ArrayList<Sentencia> lista) {
        this.entero = entero;
        this.lista = lista;
    }

     public SumaImpar(Identificador id, ArrayList<Sentencia> lista) {
        this.id = id;
        this.lista = lista;
    }
    
    public Entero getEntero() {
        return entero;
    }
    public void setEntero(Entero entero) {
        this.entero = entero;
    }

    public ArrayList<Sentencia> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Sentencia> lista) {
        this.lista = lista;
    }    
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico =  super.graficar(idPadre);
        grafico += entero.graficar(miId);
        for(Sentencia exp : getLista()){
            grafico += exp.graficar(getId());
        };
        return grafico;
    }
    
}
