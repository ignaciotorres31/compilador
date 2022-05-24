package compilador.ast.base;

import compilador.ast.expresiones.Expresion;

public abstract class  Nodo {
    private String nombre;

    public Nodo() {}

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    protected String getId() {
        return "nodo_" + this.hashCode();
    }

    protected String getEtiqueta() {
        if (this.nombre != null) {
            return this.nombre;
        }
        final String name = this.getClass().getName();
        final int pos = name.lastIndexOf('.') + 1;
        return name.substring(pos);
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String graficar(String idPadre){
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s\"]\n", this.getId(), this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }

    public abstract String generarCodigo();
}