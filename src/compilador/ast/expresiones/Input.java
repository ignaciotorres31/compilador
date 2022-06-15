 package compilador.ast.expresiones;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;

/**
 *
 * @author Nacho
 */
public class Input extends Expresion{
    
    public Input(Tipo tipo){
        setTipo(tipo);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    @Override
    public Input clonar(){
        return new Input(getTipo());
    }
    
    private String getTipo_llvm(String tipo){
        return (tipo == "INTEGER") ? "i32" : ((tipo == "FLOAT") ? "double" : "i1");
    }
    
    @Override
    public String generarCodigo(){
        StringBuilder codigo = new StringBuilder();
        codigo.append(String.format("%%temp%s = alloca %s\n", getIdVar(), getTipo_llvm(getTipo().toString())));
        if(getTipo()==Tipo.INTEGER){
            codigo.append(String.format("%%dest%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i32* %%temp%s)\n", getIdVar(), getIdVar()));
        }else if(getTipo()==Tipo.FLOAT){
            codigo.append(String.format("%%dest%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.double_read_format, i64 0, i64 0), double* %%temp%s)\n", getIdVar(), getIdVar()));
        }
        else if(getTipo()==Tipo.BOOLEAN){
            codigo.append(String.format("%%dest%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.int_read_format, i64 0, i64 0), i1* %%temp%s)\n", getIdVar(), getIdVar()));
        }
        codigo.append(String.format("%%var%s = load %s, %s* %%temp%s\n", getIdVar(), getTipo_llvm(getTipo().toString()), getTipo_llvm(getTipo().toString()), getIdVar()));
        return codigo.toString();
    }
}
