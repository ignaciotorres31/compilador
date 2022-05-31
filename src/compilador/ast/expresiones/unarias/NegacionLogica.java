/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.factor.Booleano;

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
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
