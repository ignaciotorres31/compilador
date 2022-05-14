package compilador.ast.sentencias;
        
import compilador.ast.base.Bloque;
import compilador.ast.base.Nodo;
import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Identificador;
import compilador.ast.expresiones.binarias.MayorIgual;
import compilador.ast.expresiones.binarias.MenorIgual;
import compilador.ast.expresiones.binarias.Resta;
import compilador.ast.expresiones.binarias.Suma;
import compilador.ast.expresiones.factor.Entero;
import java_cup.runtime.ComplexSymbolFactory.Location;

import java.util.ArrayList;
import java.util.List;

public class Mientras extends Sentencia {
    private Expresion condicion;
    private Bloque bloqueSentencias;

    public Mientras(Expresion condicion, Bloque bloqueSentencias) {
        super("WHILE");
        this.condicion = condicion;
        bloqueSentencias.setNombre("DO");
        this.bloqueSentencias = bloqueSentencias;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public Bloque getBloqueSentencias() {
        return bloqueSentencias;
    }

    public void setBloqueSentencias(Bloque bloqueSentencias) {
        this.bloqueSentencias = bloqueSentencias;
    }
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        return super.graficar(idPadre) +
                condicion.graficar(miId) +
                bloqueSentencias.graficar(miId);
    }

}
