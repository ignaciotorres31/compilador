package compilador.ast.sentencias;

import compilador.ast.base.Bloque;
import compilador.ast.expresiones.Expresion;

public class SiEntonces extends Seleccion {
    
    private Bloque bloqueSiEntonces;

    public SiEntonces(String nombre, Expresion condicion, Bloque bloqueSiEntonces) {
        super(nombre, condicion);
        bloqueSiEntonces.setNombre("THEN");
        this.bloqueSiEntonces = bloqueSiEntonces;
    }

    public SiEntonces(Expresion condicion, Bloque bloqueSiEntonces) {
        super("Bloque\\nIF-THEN", condicion);
        bloqueSiEntonces.setNombre("THEN");
        this.bloqueSiEntonces = bloqueSiEntonces;
    }

    public Bloque getBloqueSiEntonces() {
        return bloqueSiEntonces;
    }

    public void setBloqueSiEntonces(Bloque bloqueSiEntonces) {
        this.bloqueSiEntonces = bloqueSiEntonces;
    }

    @Override
    public Expresion evaluar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}