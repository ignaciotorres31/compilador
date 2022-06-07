/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package compilador.ast.base;

/**
 *
 * @author Nacho
 */
public enum Tipo {
    BOOLEAN,
    INTEGER,
    FLOAT,
    STRING,
    UNKNOWN;
    
    public static Tipo getTipoDato(String tipoStr) {
        
        switch (tipoStr.toUpperCase()){
            case "BOOLEAN":
                return Tipo.BOOLEAN;
            case "INTEGER":
                return Tipo.INTEGER;
            case "FLOAT":
                return Tipo.FLOAT;
            case "STRING":
                return Tipo.STRING;
        }
        return Tipo.UNKNOWN;
    }
}