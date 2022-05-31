/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

/**
 *
 * @author Nacho
 */
public class Disyuncion extends OperacionBinaria {
    
       public Disyuncion(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha);
        super.setTipo(Tipo.BOOLEAN);
    }
    
    @Override
    protected String getNombreOperacion() {
        return "OR";
    }
    
    public Disyuncion clonar(){
        return new Disyuncion(getIzquierda().clonar(), getDerecha().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return "or";
    }

}
