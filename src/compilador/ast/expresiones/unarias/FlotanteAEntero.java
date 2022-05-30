package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.factor.Entero;
import compilador.ast.expresiones.factor.Flotante;

public class FlotanteAEntero extends OperacionUnaria {
    
    public FlotanteAEntero(Expresion expresion) {
        super("Flotante a entero", expresion, Tipo.INTEGER);
    }

    public Expresion evaluar(){
        Expresion expr = getExpresion();
        if (!(expr instanceof Flotante)) {
            return this;
        }

        double nroOriginal = ((Flotante) expr).getValor();
        return new Entero((int) Math.round(nroOriginal));
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
