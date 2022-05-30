/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.base;

/**
 *
 * @author facundo
 */
public class NombreIncremental {
    
    private Integer numero = 1;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public Integer increment(){
        return this.numero += 1;
    }
    
    
}
