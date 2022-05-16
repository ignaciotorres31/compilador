package compilador.ast.base;

import java.util.*;

public class Programa extends Nodo {
    
    private ArrayList<Nodo> cuerpo;

    public Programa(ArrayList<Nodo> cuerpo) {
        super("Bloque Programa");
        this.cuerpo = cuerpo;
    }

    public ArrayList<Nodo> getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(ArrayList<Nodo> cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        for(Nodo prog : getCuerpo()){
            grafico += prog.graficar(getId());
        }
        return grafico;
    }

}
