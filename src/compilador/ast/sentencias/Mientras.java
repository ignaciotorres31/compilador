package compilador.ast.sentencias;
        
import compilador.ast.base.Bloque;
import compilador.ast.expresiones.Expresion;

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

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
