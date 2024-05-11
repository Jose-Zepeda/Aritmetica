package org.example.Evaluación;
import org.example.Pilas.PilaLineal;

public class Aritmetica {



    //evaluar una expresión aritmética
    public static int evaluar(String expresion) throws Exception {
        PilaLineal operandos = new PilaLineal();
        PilaLineal operadores = new PilaLineal();
        int resultado = 0;
        int operando1, operando2;
        char operador;
        int i = 0;

        //Recorre toda la expresion y categoriza los operadores de los numeros y se salta los espacios en blanco

        while (i < expresion.length()){
            //Si el caracter es un espacio en blanco se salta
            if (expresion.charAt(i) == ' '){
                i++;
            } else if (expresion.charAt(i) == '+' || expresion.charAt(i) == '-' || expresion.charAt(i) == '*' || expresion.charAt(i) == '/'){
                operadores.insertar(expresion.charAt(i));
                //Se salta al siguiente caracter
                i++;
            } else {
                //Si el caracter no es un operador se toma como un numero
                String numero = "";
                while (i < expresion.length() && expresion.charAt(i) != ' ' && expresion.charAt(i) != '+' && expresion.charAt(i) != '-' && expresion.charAt(i) != '*' && expresion.charAt(i) != '/'){
                    numero += expresion.charAt(i);
                    i++;
                }
                //Se inserta el numero en la pila de operandos
                operandos.insertar(Integer.parseInt(numero));
            }
        }
        //Se evalua la expresion
        while (!operadores.pilaVacia())
        {
            //Se extraen los operandos y el operador
            try {
                operando2 = (int) operandos.quitar();
                operando1 = (int) operandos.quitar();
                operador = (char) operadores.quitar();
                //Se realiza la operacion correspondiente
                switch (operador){
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }
                operandos.insertar(resultado);

                //Si la pila de operandos tiene un solo elemento se termina la evaluacion
            } catch (Exception e) {
                //Si hay un error se imprime el mensaje
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
}
