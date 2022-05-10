/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author facundo
 */
public class Cadena extends Expresion {
    private String valor;
    private String valorEsc;

    public Cadena(String valor) {
        setValor(valor);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
        setValorEsc();
    }

    @Override
    public String toString() {
        return valorEsc;
    }

    private void setValorEsc() {
        final String barraInv = "\\";
        Map<Character, String> reemp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        // Reemplazos
        reemp.put('\t', barraInv.concat("\\") + "t");
        reemp.put('\n', barraInv.concat("\\") + "n");
        reemp.put('\r', barraInv.concat("\\") + "r");
        reemp.put('"', barraInv.concat("\\\\") + '"');
        reemp.put('\\', barraInv.concat("\\\\\\"));

        // Agregar comillas
        sb.append(barraInv).append('"');

        // Agregar cada carácter de la cadena original, reemplazándolo si es necesario
        for (char c : valor.toCharArray()) {
            String s = reemp.get(c);
            sb.append(s == null ? c : s);
        }

        sb.append(barraInv).append('"');

        valorEsc = sb.toString();
    }

    public Expresion evaluar() {
        return this;
    }
    
}
