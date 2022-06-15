package compilador.ast.expresiones.factor;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;

/**
 *
 * @author Nacho
 */
public class Booleano extends Literal {
     private final Boolean valor;

    public Booleano(Boolean valor) {
        setTipo(Tipo.BOOLEAN);
        this.valor = valor;
        setNombre("Boolean");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Boolean getValor() {
        return valor;
    }

    @Override
    public String toString() {        
        return valor.toString();
    }
    
     @Override
    public Booleano clonar(){
        return new Booleano(getValor());
    }

    @Override
    public String generarCodigo(){
        return (getValor()) ? "%var"+getIdVar()+" = add i1 0, 1\n" : "%var"+getIdVar()+" = add i1 0, 0\n";
    }
}