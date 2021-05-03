public class App {
    public static void main(String[] args) throws Exception {

      /* Pruebas básicas */
      IntStack testStack = new IntStack(6);
      testStack.push(1);
      testStack.push(2);
      testStack.push(3);
      testStack.push(4);
      testStack.push(5);
      testStack.push(6);

      /* Imprime el array entero */
      for(int i=0; i<=testStack.maxStack-1;i++)
         System.out.print(testStack.print(i)+", ");

      /* Ahora simplemente haz pop */
      System.out.println();
      testStack.popInt();

      for(int i=0; i<=testStack.maxStack-1;i++)
         System.out.print(testStack.print(i)+", ");

      System.out.println("\n==================");

      /* Ejercicio 1. Array invertido */
      IntStack myStack = new IntStack(10);

      /* Se llena la pila con un ciclo */
      for(int i=0; i<=myStack.maxStack-1;i++) myStack.push(i);
      
      /* Primero se imprime la pila de manera normal */
      System.out.println("Pila normal: ");

      for(int i=0; i<=myStack.maxStack-1;i++)
         System.out.print(myStack.print(i)+", ");
      

      System.out.println("\nPila invertida: ");

      /* Se llama al método para invertir la pila */
      myStack.reverseTheStack();

      /* Se imprime de nuevo la pila, pero esta vez estará en reversa */
      for(int i=0; i<=myStack.maxStack-1;i++)
         System.out.print(myStack.print(i)+", ");
            

      /* Ejercicio 2. Palíndromo */

      CharStack palindromeStack = new CharStack(3);

      palindromeStack.push('a');
      palindromeStack.push('n');
      palindromeStack.push('a');
        
      System.out.println("");
      for(int i=0; i<=palindromeStack.maxStack-1;i++)
        System.out.print(palindromeStack.print(i));

      System.out.println("");

      /* palindromeStack.reverseTheStack();

      for(int i=0; i<=palindromeStack.maxStack-1;i++)
        System.out.print(palindromeStack.print(i)); */

      if(palindromeStack.isPalindrome()){
        System.out.println("Es palíndromo");
      }else{
        System.out.println("No es palíndromo");
      }

      /* Para mejorar este ejercicio y orientarlo al usuario, podrías usar
      un scanner que le pida al usuario un string y ese string pasarlo con el push,
      no se necetaría hacer un array extra, porque el método chartAt se 
      encargaría del trabajo */


      /* Ejercicio 3. Válidar paréntesis */
      String expression = "(A+B)*(B/C)";
      CharStack parenthesisArr = new CharStack(expression.length());

      /* Se hace un bucle para guardar los paréntesis izquierdos */

      for(int i=0; i<expression.length(); i++){
        /* Left parenthesis array */
        if(expression.charAt(i)=='(' || expression.charAt(i)=='[' || expression.charAt(i)=='{'){
            /* Save the character on the array */
            parenthesisArr.push(expression.charAt(i));
        }
        
      }

      for(int i=0; i<parenthesisArr.top();i++){
        switch(parenthesisArr.print(i)){
          case '(':
          for(int j=0; j<expression.length(); j++) if(expression.charAt(j)==')') parenthesisArr.pop(); 
            break;
          case '[':
          for(int j=0; j<expression.length(); j++) if(expression.charAt(j)==']') parenthesisArr.pop(); 
            break;
          case '{':
          for(int j=0; j<expression.length(); j++) if(expression.charAt(j)=='}') parenthesisArr.pop(); 
            break;
        }
      }

      if(parenthesisArr.voidStack()) System.out.println("Los paréntesis están correctos");
      else System.out.println("Ha ocurrido un error con los paréntesis");


      /* Ejercicio 4. Pasar una expresión de infija a postfija*/
      String infExpression = "X+Z*W";
      CharStack operatorCharStack = new CharStack(infExpression.length());

      /* Expected output: AB+ */
      for(int i=0; i<infExpression.length(); i++){
        if(infExpression.charAt(i)=='+' || infExpression.charAt(i)=='-') operatorCharStack.push(infExpression.charAt(i));
        else if(infExpression.charAt(i)=='*' || infExpression.charAt(i)=='/') operatorCharStack.push(infExpression.charAt(i));
        else if(infExpression.charAt(i)=='^') operatorCharStack.push(infExpression.charAt(i));
        else{
          /* Sino simplemente lo imprimes */
          System.out.print(infExpression.charAt(i));
        }
      }

     System.out.print(operatorCharStack.popChar());


  }       
}
