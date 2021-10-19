public class App {
    public static void main(String[] args) throws Exception {
      /* Ejercicio 1. Array invertido */
      System.out.println("Ejercicio 1. Array invertido");
      IntStack myStack = new IntStack(10);

      /* Se llena la pila con un ciclo */
      for(int i=0; i<myStack.getCapacity();i++) myStack.push(i);
      
      
      /* Primero se imprime la pila de manera normal */
      System.out.println("Pila normal: ");

      myStack.print();
      

      System.out.println("\nPila invertida: ");

      /* Se llama al método para invertir la pila */
      myStack.reverseTheStack();

      /* Se imprime de nuevo la pila, pero esta vez estará en reversa */
      myStack.print();
            

      /* Ejercicio 2. Palíndromo */
      System.out.println("\n\nEjercicio 2. Palíndromo");

      CharStack palindromeStack = new CharStack(3);

      palindromeStack.push('a');
      palindromeStack.push('n');
      palindromeStack.push('a');
        
      palindromeStack.print();

      System.out.println("");

      palindromeStack.reverseTheStack();
      if(palindromeStack.isPalindrome()){
        System.out.println("Es palíndromo\n");
      }else{
        System.out.println("No es palíndromo\n");
      }

      /* Para mejorar este ejercicio y orientarlo al usuario, podrías usar
      un scanner que le pida al usuario un string y ese string pasarlo con el push,
      no se necetaría hacer un array extra, porque el método chartAt se 
      encargaría del trabajo */


      /* Ejercicio 3. Válidar paréntesis */
      System.out.println("Ejercicio 3. Válidar paréntesis");

      String expression = "(A+B)*(B/C)";
      CharStack parenthesisArr = new CharStack(expression.length());

      for(int i=0; i<expression.length(); i++){
        if(expression.charAt(i)=='(' || expression.charAt(i)=='[' || expression.charAt(i)=='{'){
            parenthesisArr.push(expression.charAt(i));
        }
        
      }

      for(int i=0; i<parenthesisArr.getSize();i++){
        switch(parenthesisArr.getElement(i)){
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

      if(!parenthesisArr.isFull()) System.out.println("Los paréntesis están correctos en la expresión " + expression+"\n");
      else System.out.println("Ha ocurrido un error con los paréntesis\n");


      /* Ejercicio 4. Pasar una expresión de infija a postfija*/
      System.out.println("Ejercicio 4. De infija a postfija");

      // String infExpression = "4*(5+6-(8/2^3)-7)-1";
      String infExpression = "Z*W+Y";
      System.out.println(infixToPfix(infExpression));


    }   

  /* Método para convertir una expresión infija a postija */
    static String infixToPfix(String exp){
      String postFixExp = new String("");	
      CharStack stack = new CharStack(exp.length());
      for (int i = 0; i<exp.length(); ++i){
        char auxChar = exp.charAt(i);
        if (Character.isLetterOrDigit(auxChar))
          postFixExp += auxChar;
        else if (auxChar == '(')
          stack.push(auxChar);
        else if (auxChar == ')'){
          while (!stack.isEmpty() && stack.peek() != '('){
            postFixExp += stack.pop();
          }
          stack.pop();
        }
        else{
          while (!stack.isEmpty() && setPriority(auxChar) <= setPriority(stack.peek())){
            postFixExp += stack.pop();
          }
          stack.push(auxChar);
        }
      }
      
      while (!stack.isEmpty()){
        if(stack.peek() == '(')
        return "Carácter inválido";

        postFixExp += stack.pop();
      }
      return postFixExp;
    }
    // Método para definir la proridad de caracteres
    static int setPriority(char ch){
      switch (ch){
        case '+':
        case '-':
          return 1;
        case '*':
        case '/':
          return 2;
        case '^':
          return 3;
      }
      return -1;
    }
}

