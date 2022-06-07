package compilador.ast.base;

/**
 *
 * @author facundo
 */
public class NombreIncremental {
    
    private Integer numero;
    
    public NombreIncremental(){
        this.numero = 0;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public Integer incrementar(){
        return this.numero += 1;
    }
    
    
}
