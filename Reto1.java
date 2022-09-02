import java.util.Scanner;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto1{

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    
    public static String calcularRiesgo(double imc, int edad){                  
        String riesgo = "";         
        if (imc < 22 && edad < 45) riesgo = "Bajo";         
        if (imc < 22 && edad >= 45) riesgo = "Medio";         
        if (imc >= 22 && edad < 45) riesgo = "Medio";
        if (imc >= 22 && edad >= 45) riesgo = "Alto";                      
        return riesgo;     
    }          
    public static double calcularIMC(double masa, double altura){             
        return masa / (altura * altura);     
    }          

    public static boolean validarEntrada(double masa, double altura, int edad){              
        if ((masa < 0 || masa > 150)                  
                || (altura < 0.1 || altura > 2.5)                  
                || (edad < 0 || altura > 110))
        {             
            return false;     
    }                 
        return true;
    }

    
    /**
    * método principal
    */
    public void run(){
        /*
        solución propuesta
        */
        //Scanner sc = new Scanner(System.in);           
        String[] input = this.scanner.nextLine().split(" ");                  
        double masa = Double.parseDouble(input[0]);         
        double altura = Double.parseDouble(input[1]);         
        int edad = Integer.parseInt(input[2]);           
        double imc = calcularIMC(masa, altura); // calcula el IMC                  
        if(validarEntrada(masa, altura, edad)){             
        System.out.println(String.format("%.1f", imc) + " " + calcularRiesgo(imc, edad));    
        }
        else{
            System.out.println("ERROR");
        }
    }

}