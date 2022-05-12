/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones;

import compilador.ast.expresiones.factor.Factor;

/**
 *
 * @author facundo
 */
public class Identificador extends Factor {
    public Identificador(String nombre) {
        super(Tipo.UNKNOWN, nombre);
    }

    public Identificador(String nombre, Tipo tipo) {
        super(tipo, nombre);
    }

    @Override
    public String getEtiqueta() {
        return String.format("%s\\n<%s>", getEtiqueta(), getTipo());
    }
}

