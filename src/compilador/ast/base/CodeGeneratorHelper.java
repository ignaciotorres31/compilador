package compilador.ast.base;

import java.util.ArrayList;

/**
 *
 * @author nacho torres
 */
public class CodeGeneratorHelper {
    
    private static int nextID = 0;
        
    private CodeGeneratorHelper(){}
   
    public static String getNewPointer(){
        StringBuilder ret = new StringBuilder();
        nextID+=1;
        ret.append(String.format("%s", nextID));
        return ret.toString();
    }
    
    
}
