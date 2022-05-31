/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.factor;

import compilador.ast.base.Tipo;
import compilador.llvm.CodeGeneratorHelper;

/**
 *
 * @author Nacho
 */
public class Entero extends Literal {
    
    private Integer valor;

    public Entero(Integer valor) {
        super(Tipo.INTEGER);
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
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();        
        this.setIr_ref(CodeGeneratorHelper.getNewPointer());
        resultado.append(String.format("%1$s = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer,"+
                "i32 0, i32 0), i32 %2$s\n",this.getIr_ref(),  
                this.getValor()));
        return resultado.toString();
        
    }
}
