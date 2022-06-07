package compilador.ast.expresiones.factor;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;


/**
 *
 * @author facundo
 */
public abstract class Constante extends Expresion {
    
   private Tipo tipo;
    
   @Override
    public abstract Constante clonar();

    @Override
    public String graficar(String idPadre){
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s : %3$s\"]\n", this.getId(), this.getNombre(), this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }
}
