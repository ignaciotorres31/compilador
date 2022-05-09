/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.valor;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;

/**
 *
 * @author facundo
 */
public abstract class Valor extends Expresion {
    
    public Valor(Tipo tipo) {
        super(tipo);
    }

    public Valor(Tipo tipo, String nombre) {
        super(tipo, nombre);
    }
}
