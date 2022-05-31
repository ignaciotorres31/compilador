/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.factor.Booleano;
import compilador.llvm.CodeGeneratorHelper;

/**
 *
 * @author facundo
 */
public class NegacionLogica extends OperacionUnaria {
    
    
    public NegacionLogica(Expresion expresion) {
        super("NOT", expresion, Tipo.BOOLEAN);
    }
    
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
        this.setIr_ref(CodeGeneratorHelper.getNewPointer());
        resultado.append(String.format("%1$s = %2$s i32 %3$s, 1\n", this.getIr_ref(), 
                this.get_llvm_op_code(), this.getExpresion().getIr_ref()));
        return resultado.toString();
    }
   
}
