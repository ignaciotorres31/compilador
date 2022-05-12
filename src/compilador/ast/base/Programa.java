package compilador.ast.base;

import compilador.ast.base.Nodo;
import compilador.ast.expresiones.Cadena;
import compilador.ast.expresiones.Expresion;

import java.util.*;

public class Programa extends Nodo {
    
    private Bloque cuerpo;

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

}
