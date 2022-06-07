package compilador.ast.expresiones.factor;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;

/**
 *
 * @author Nacho
 */
public class Flotante extends Literal {
    private final Float valor;

    public Flotante(Float valor) {
        setTipo(Tipo.FLOAT);
        this.valor = valor;
        setNombre("Float");
    }

    public Float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
    
    public Flotante clonar(){
        return new Flotante(getValor());
    }

    @Override
    public String generarCodigo(){
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        return "%var"+getIdVar()+" = fadd double 0.0, "+getValor()+"\n";
    }
}
