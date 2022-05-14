package compilador.ast.base;

import compilador.ast.base.Nodo;
import compilador.ast.expresiones.Expresion;

import java.util.*;

public class Programa extends Nodo {
    
    private ArrayList<Nodo> cuerpo;

    public Programa(ArrayList<Nodo> cuerpo) {
        super("Bloque Programa");
        this.cuerpo = cuerpo;
    }

    public ArrayList<Nodo> getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(ArrayList<Nodo> cuerpo) {
        this.cuerpo = cuerpo;
    }

}
