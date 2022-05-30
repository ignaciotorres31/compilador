package compilador.ast.base;
        
import compilador.ast.sentencias.Sentencia;
import java.util.ArrayList;

public class Bloque extends Sentencia {
    private ArrayList<Sentencia> sentencias;

    public Bloque(ArrayList<Sentencia> sentencias) {
        super("Bloque");
        this.sentencias = sentencias;
    }

    public void setSentencias(ArrayList<Sentencia> sentencias) {
        this.sentencias = sentencias;
    }

    public ArrayList<Sentencia> getSentencias() {
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

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
