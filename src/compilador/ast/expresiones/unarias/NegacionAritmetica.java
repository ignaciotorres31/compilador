package compilador.ast.expresiones.unarias;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;

/**
 *
 * @author facundo
 */
public class NegacionAritmetica extends OperacionUnaria {
    private String operacion;
    
   public NegacionAritmetica(Expresion expresion, String operacion, Tipo tipo) {
        super("-", expresion, tipo);
        this.operacion = operacion;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public NegacionAritmetica clonar(){
        return new NegacionAritmetica(getExpresion().clonar(), getOperacion(), getTipo());
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    @Override
    public String generarCodigo(){
        StringBuilder codigo = new StringBuilder();      
        codigo.append(this.getExpresion().generarCodigo());
        if(getExpresion().getTipo() == Tipo.INTEGER){
            codigo.append(String.format("%%var%s = %s %s 0, %%var%s\n", getIdVar(), getOperacion(), get_llvm_type_code(), getExpresion().getIdVar()));
        }else if(getTipo() == Tipo.FLOAT){
            codigo.append(String.format("%%var%s = %s %s 0.0,%%var%s\n", getIdVar(), getOperacion(), get_llvm_type_code(), getExpresion().getIdVar()));
        }
        return codigo.toString();
    }

    @Override
    public String get_llvm_op_code() {
        return getTipo().equals(Tipo.FLOAT) ? "fsub" : "sub";
    }

}