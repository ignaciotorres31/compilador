/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.factor;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;

/**
 *
 * @author facundo
 */
public abstract class Factor extends Expresion {
    
    public Factor(Tipo tipo) {
        super(tipo);
    }

    public Factor(Tipo tipo, String nombre) {
        super(tipo, nombre);
    }
}
