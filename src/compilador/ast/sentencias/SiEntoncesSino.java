package compilador.ast.sentencias;

import compilador.ast.base.Bloque;
import compilador.ast.expresiones.Expresion;


public class SiEntoncesSino extends SiEntonces {
    
    private Bloque bloqueSino;

    public SiEntoncesSino(Expresion condicion, Bloque bloqueSiEntonces, Bloque bloqueSino) {
        super("IF-THEN", condicion, bloqueSiEntonces);
        bloqueSino.setNombre("ELSE");
        this.bloqueSino = bloqueSino;
    }

    public Bloque getBloqueSino() {
        return bloqueSino;
    }

    public void setBloqueSino(Bloque bloqueSino) {
        this.bloqueSino = bloqueSino;
    }
    
}
