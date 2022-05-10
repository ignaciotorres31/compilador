package compilador.ast.sentencias;
        
import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Identificador;

public class DecVar extends Declaracion {
    
    public DecVar(Identificador ident) {
        super(ident);
    }

    @Override
    public Expresion evaluar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
