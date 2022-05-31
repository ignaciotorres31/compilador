/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.expresiones.factor;

import compilador.ast.base.Tipo;
import compilador.llvm.CodeGeneratorHelper;

/**
 *
 * @author Nacho
 */
public class StringLiteral extends Literal{
    private final String valor;

    public StringLiteral(String valor) {
        super(Tipo.STRING);
        this.valor = valor;
        setNombre("String");
    }

    public String getValor() {
        return valor;
    }

    public String toString() {
        return valor.toString();
    }
    
    public StringLiteral clonar(){
        return new StringLiteral(getValor());
    }

    @Override
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();        
        this.setIr_ref(CodeGeneratorHelper.getNewPointer());
        resultado.append(String.format("@str = private constant [11 x i8] c %1$s \00\"\n", 
                this.getValor()));
        return resultado.toString();
        
    }
    
}
