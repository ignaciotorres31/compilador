package compilador.ast.expresiones.factor;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;

/**
 *
 * @author Nacho
 */
public class Entero extends Literal {
    
    private Integer valor;

    public Entero(Integer valor) {
        setTipo(Tipo.INTEGER);
        this.valor = valor;
        setNombre("Integer");
    }

    public Integer getValor() {
        return this.valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
    
    public Entero clonar(){
        return new Entero(getValor());
    }

    @Override
    public String generarCodigo(){
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        return "%var"+getIdVar()+" = add i32 0, "+getValor()+"\n";
    }
}
