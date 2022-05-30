/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.expresiones;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Identificador;
import compilador.ast.expresiones.factor.Entero;
import compilador.ast.expresiones.factor.Constante;
import compilador.ast.sentencias.Asignacion;
import compilador.ast.sentencias.Sentencia;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class SumaImpar extends Expresion{
    
    private Constante pivot;
    private ArrayList<Sentencia> lista;
    private Asignacion contador;
    private Asignacion suma;

    public SumaImpar(Constante pivot, ArrayList<Sentencia> lista){
        this.pivot = pivot;
        this.lista = lista;
        this.contador = new Asignacion(new Identificador("aux"),new Entero(0));
        this.suma = new Asignacion(new Identificador("suma"),new Entero(0));
    }
    
    public Constante getPivot() {
        return pivot;
    }
    public void setPivot(Constante pivot) {
        this.pivot = pivot;
    }

    public ArrayList<Sentencia> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Sentencia> lista) {
        this.lista = lista;
    }

    public Asignacion getContador() {
        return contador;
    }
    public void setContador(Asignacion contador) {
        this.contador = contador;
    }

    public Asignacion getSuma() {
        return suma;
    }
    public void setSuma(Asignacion suma) {
        this.suma = suma;
    }
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico =  super.graficar(idPadre);
        grafico += contador.graficar(miId);
        grafico += suma.graficar(miId);
        for(Sentencia exp : getLista()){
            grafico += exp.graficar(getId());
        }
        return grafico;
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}