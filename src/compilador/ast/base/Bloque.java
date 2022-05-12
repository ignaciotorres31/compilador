package compilador.ast.base;
        
import compilador.ast.base.Nodo;
import compilador.ast.expresiones.Expresion;
import compilador.ast.sentencias.Sentencia;

import java.util.ArrayList;
import java.util.List;

public class Bloque extends Sentencia {
    private List<Nodo> sentencias;

    public Bloque(String nombre, List<Nodo> sentencias) {
        super(nombre);
        this.sentencias = sentencias;
    }

    public Bloque(String nombre) {
        this(nombre, new ArrayList<>());
    }

    public void setSentencias(List<Nodo> sentencias) {
        this.sentencias = sentencias;
    }

    public List<Nodo> getSentencias() {
        return sentencias;
    }

    @Override
    public String getEtiqueta() {
        return this.getEtiqueta();
    }

}
