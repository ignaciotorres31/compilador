package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;
import compilador.ast.expresiones.valor.Entero;
import compilador.ast.expresiones.valor.Flotante;

public class FlotanteAEntero extends OperacionUnaria {
    
    public FlotanteAEntero(Expresion expresion) {
        super("Flotante a entero", expresion, Tipo.INTEGER);
    }

    @Override
    public Expresion evaluar(){
        Expresion expr = getExpresion().evaluar();
        if (!(expr instanceof Flotante)) {
            return this;
        }

        double nroOriginal = ((Flotante) expr).getValor();
        return new Entero((int) Math.round(nroOriginal));
    }
}
