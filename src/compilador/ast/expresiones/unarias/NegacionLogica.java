package compilador.ast.expresiones.unarias;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;

/**
 *
 * @author facundo
 */
public class NegacionLogica extends OperacionUnaria {
    
    
    public NegacionLogica(Expresion expresion) {
        super("NOT", expresion, Tipo.BOOLEAN);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    @Override
    public NegacionLogica clonar(){
        return new NegacionLogica(getExpresion().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return "xor";
    }
    
    @Override
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();     
        resultado.append(this.getExpresion().generarCodigo());
        resultado.append(String.format("%%var%s = xor i1 %%var%s, 1\n", getIdVar(), getExpresion().getIdVar()));
        return resultado.toString();
    }   
}
