package compilador.ast.base;
        
import compilador.ast.sentencias.Sentencia;

import java.util.List;

public class Bloque extends Sentencia {
    private List<Sentencia> sentencias;

    public Bloque(List<Sentencia> sentencias) {
        super("Bloque");
        this.sentencias = sentencias;
    }

    public void setSentencias(List<Sentencia> sentencias) {
        this.sentencias = sentencias;
    }

    public List<Sentencia> getSentencias() {
        return sentencias;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        for(Nodo sen : getSentencias()){
            grafico += sen.graficar(getId());
        }
        return grafico;
    }
}
