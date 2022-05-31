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
public class Multiplicacion extends OperacionBinaria {

    public Multiplicacion(Expresion izquierda, Expresion derecha, Tipo tipo) {
        super(izquierda, derecha);
        super.setTipo(tipo);
    }

    @Override
    protected String getNombreOperacion() {
        return "*";
    }
    
    public Multiplicacion clonar(){
        return new Multiplicacion(getIzquierda().clonar(), getDerecha().clonar(), getTipo());
    }

    @Override
    public String get_llvm_op_code() {
        return getTipo().equals(Tipo.FLOAT) ? "fmul" : "mul";
    }

}
