/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

/**
 *
 * @author facundo
 */
public class Suma extends OperacionBinaria {

    
    public Suma(Expresion izquierda, Expresion derecha, Tipo tipo, String idVar) {
        super(izquierda, derecha, tipo, idVar);
    }

    @Override
    protected String getNombreOperacion() {
        return "+";
    }
    
    public Suma clonar(){
        return new Suma(getIzquierda().clonar(), getDerecha().clonar(), getTipo(), getIdVar());
    }

    @Override
    public String get_llvm_op_code() {
        return getTipo().equals(Tipo.FLOAT) ? "fadd" : "add";
    }

}
