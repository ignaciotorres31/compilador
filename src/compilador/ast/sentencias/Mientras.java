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
        super("Bloque WHILE");
        this.condicion = condicion;
        bloqueSentencias.setNombre("Cuerpo WHILE");
        this.bloqueSentencias = bloqueSentencias;
    }

    /** Construir WHILE a partir de FOR */
    private Mientras(Identificador ident, int valorIni, int valorFin, int salto, Bloque bloque) {
        super("Bloque WHILE");
        bloque.setNombre("Cuerpo WHILE");
        this.bloqueSentencias = bloque;

        if (salto == 0) {
            throw new IllegalStateException("No se permite que el iterador de FOR tenga salto 0.");
        }

        List<Nodo> sentencias = bloque.getSentencias();

        Entero litSalto = new Entero(salto);
        if (valorIni > valorFin) salto = -salto;

        // Crear condición del WHILE según los valores del FOR
        Entero litValorFin = new Entero(valorFin);
        if (salto > 0) {
            this.condicion = new MenorIgual(ident, litValorFin);
        } else {
            this.condicion = new MayorIgual(ident, litValorFin);
        }

        // Añadir incremento o decremento del contador al final del bloque for
        Expresion inc;
        if (salto > 0) {
            inc = new Suma(ident, litSalto);
        } else {
            inc = new Resta(ident, litSalto);
        }

        Asignacion asigInc = new Asignacion(ident, inc);
        sentencias.add(asigInc);
    }

    public static Bloque crearBloquePara(Identificador ident, int valorIni, int valorFin, int salto,
                                         Bloque bloque, Location posIzq, Location posDer) {
        List<Nodo> sentencias = new ArrayList<>();
        sentencias.add(new Asignacion(ident, new Entero(valorIni)));

        Mientras mientras = new Mientras(ident, valorIni, valorFin, salto, bloque);
        sentencias.add(mientras);

        return new Bloque("WHILE", sentencias);
    }

    
    public static Bloque crearBloquePara(Identificador ident, int valorIni, int valorFin,
                                         Bloque bloque, Location posIzq, Location posDer) {
        return crearBloquePara(ident, valorIni, valorFin, 1, bloque, posIzq, posDer);
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

}
