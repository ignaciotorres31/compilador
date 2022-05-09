/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package compilador.ast.expresiones;

/**
 *
 * @author facundo
 */
public enum OperadorComparacion {
    IGUAL_IGUAL,
    DESIGUAL,
    MAYOR,
    MAYOR_IGUAL,
    MENOR,
    MENOR_IGUAL;

    public static String getStrOp(OperadorComparacion op) {
        
        switch (op) {
            case IGUAL_IGUAL: 
                return "==";
            case DESIGUAL:
                return "!=";
            case MAYOR:
                return ">";
            case MAYOR_IGUAL:
                return ">=";
            case MENOR: 
                return "<";
            case MENOR_IGUAL:
                return "<=";
            default: 
                throw new IllegalStateException("Tipo de comparación inesperada: " + op);
        }
        
    }
    
    public static OperadorComparacion getTipoOpCmp(String opStr) {
        
        switch (opStr) {
            case "==":
                return OperadorComparacion.IGUAL_IGUAL;
            case "!=": 
                return OperadorComparacion.DESIGUAL;
            case ">":
                return OperadorComparacion.MAYOR;
            case ">=":
                return OperadorComparacion.MAYOR_IGUAL;
            case "<":
                return OperadorComparacion.MENOR;
            case "<=":
                return OperadorComparacion.MENOR_IGUAL;
            default:
                throw new IllegalStateException("Operador relacional inesperado: " + opStr);                
        }
        
    }
}