#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public class ${NAME} {
    
    
    
    public static void main(String[] args){
        ${NAME} main = new ${NAME}();
        
        System.out.println(main);
    }
}
