package compilador.ast.base;

import compilador.ast.sentencias.Sentencia;
import java.util.*;

public class Programa extends Nodo {
    
    private ArrayList<Sentencia> cuerpo;
    private String ir_ref;

    public Programa(ArrayList<Sentencia> cuerpo) {
        super("Bloque Programa");
        this.cuerpo = cuerpo;
    }

    public ArrayList<Sentencia> getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(ArrayList<Sentencia> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getIr_ref() {
        return ir_ref;
    }

    public void setIr_ref(String ir_ref) {
        this.ir_ref = ir_ref;
    }
    
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        for(Nodo prog : getCuerpo()){
            grafico += prog.graficar(getId());
        }
        return grafico;
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
