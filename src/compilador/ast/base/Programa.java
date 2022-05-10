package compilador.ast.base;

import compilador.ast.base.Nodo;
import compilador.ast.expresiones.Cadena;
import compilador.ast.expresiones.Expresion;

import java.util.*;

public class Programa extends Nodo {
    
    private Bloque cuerpo;
    private List<Cadena> arrCadenas = new ArrayList<>();

    public Programa(String nombre, Bloque cuerpo) {
        super(nombre);
        this.cuerpo = cuerpo;      
    }

    public Bloque getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(Bloque cuerpo) {
        this.cuerpo = cuerpo;
    }

    public List<Cadena> getArrCadenas() {
        return arrCadenas;
    }

    public void setArrCadenas(List<Cadena> arrCadenas) {
        this.arrCadenas = arrCadenas;
    }

    @Override
    public Expresion evaluar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
