
package compilador.ast.expresiones.factor;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;

/**
 *
 * @author facundo
 */
public abstract class Literal extends Factor {
    
    public Literal(Tipo tipo) {
        super(tipo);
    }

    @Override
    public String getEtiqueta() {
        return String.format("%s\\n<%s>", this, getTipo());
    }

    public static Number getNumero(Expresion expr) {
        if (expr instanceof Flotante) {
            return ((Flotante) expr).getValor();
        } else if (expr instanceof Entero) {
            return ((Entero) expr).getValor();
        } else {
            throw new IllegalStateException("Tipo de expresión inesperado: " + expr);
        }
    }

    public static Literal crearNumero(Number valor, Tipo tipo) {
        
        switch (tipo){
            case INTEGER:
                return new Entero(valor.intValue());
            case FLOAT:
                return new Flotante(valor.floatValue());
            default:
                throw new IllegalStateException("Tipo de literal inesperado: " + tipo);
                
        }
    }
}
