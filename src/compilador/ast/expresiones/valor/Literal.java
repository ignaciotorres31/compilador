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
public abstract class Literal extends Valor {
    
    public Literal(Tipo tipo) {
        super(tipo);
    }

    @Override
    public String getEtiqueta() {
        return String.format("%s\\n<%s>", this, getTipo());
    }

    // *** Funciones auxiliares para literales numéricos usados por el constant folding ***

    public static Number getNumero(Expresion expr) {
        if (expr instanceof Flotante) {
            return ((Flotante) expr).getValor();
        } else if (expr instanceof Entero) {
            return ((Entero) expr).getValor();
        } else {
            throw new IllegalStateException("Tipo de expresión inesperado: " + expr);
        }
    }

    public static Literal crearNumero(Number valor, Tipo tipo) {
        
        switch (tipo){
            case INTEGER:
                return new Entero(valor.intValue());
            case FLOAT:
                return new Flotante(valor.doubleValue());
            default:
                throw new IllegalStateException("Tipo de literal inesperado: " + tipo);
                
        }
    }
}
