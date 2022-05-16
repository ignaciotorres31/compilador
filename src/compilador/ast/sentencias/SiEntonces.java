package compilador.ast.sentencias;

import compilador.ast.base.Bloque;
import compilador.ast.expresiones.Expresion;

public class SiEntonces extends Seleccion {
    
    private Bloque bloqueSiEntonces;
    private Bloque bloqueSino;

    public SiEntonces(Expresion condicion, Bloque bloqueSiEntonces, Bloque bloqueSino) {
        super("IF", condicion);
        bloqueSiEntonces.setNombre("THEN");
        bloqueSino.setNombre("ELSE");
        this.bloqueSiEntonces = bloqueSiEntonces;
        this.bloqueSino = bloqueSino;
    }
    public SiEntonces(Expresion condicion, Bloque bloqueSiEntonces) {
        super("IF", condicion);
        bloqueSiEntonces.setNombre("THEN");
        this.bloqueSiEntonces = bloqueSiEntonces;
    }

    public Bloque getBloqueSiEntonces() {
        return bloqueSiEntonces;
    }
    public void setBloqueSiEntonces(Bloque bloqueSiEntonces) {
        this.bloqueSiEntonces = bloqueSiEntonces;
    }

    public Bloque getBloqueSino() {
        return bloqueSino;
    }
    public void setBloqueSino(Bloque bloqueSino) {
        this.bloqueSino = bloqueSino;
    }
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + 
            super.getCondicion().graficar(miId) +
            bloqueSiEntonces.graficar(miId);
        if(getBloqueSino() != null){
            grafico += getBloqueSino().graficar(getId());
        }
        return grafico;
    }

    
}
