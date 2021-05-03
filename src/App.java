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
      testStack.print();

      /* Ahora simplemente haz pop */
      System.out.println();
      testStack.popInt();

      testStack.print();

      System.out.println("\n==================");

      /* Ejercicio 1. Array invertido */
      IntStack myStack = new IntStack(10);

      /* Se llena la pila con un ciclo */
      for(int i=0; i<=myStack.maxStack-1;i++) myStack.push(i);
      
      /* Primero se imprime la pila de manera normal */
      System.out.println("Pila normal: ");

      myStack.print();
      

      System.out.println("\nPila invertida: ");

      /* Se llama al método para invertir la pila */
      myStack.reverseTheStack();

      /* Se imprime de nuevo la pila, pero esta vez estará en reversa */
      myStack.print();
            

      /* Ejercicio 2. Palíndromo */

      CharStack palindromeStack = new CharStack(3);

      palindromeStack.push('a');
      palindromeStack.push('n');
      palindromeStack.push('a');
        
      System.out.println("");
      palindromeStack.print();

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

      if(!parenthesisArr.isFull()) System.out.println("Los paréntesis están correctos");
      else System.out.println("Ha ocurrido un error con los paréntesis");


      /* Ejercicio 4. Pasar una expresión de infija a postfija*/
      String infExpression = "X+Z*W";
      System.out.println(infixToPostfix(infExpression));


  }   
  
  /* Java implementation to convert
    infix expression to postfix*/
    // Note that here we use Stack class for Stack operations

	// A utility function to return
	// precedence of a given operator
	// Higher returned value means
	// higher precedence
	static int Prec(char ch)
	{
		switch (ch)
		{
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
	
	// The main method that converts
	// given infix expression
	// to postfix expression.
	static String infixToPostfix(String exp){
		// initializing empty String for result
		String result = new String("");
		
		// initializing empty stack
    CharStack stack = new CharStack(exp.length());
		for (int i = 0; i<exp.length(); ++i)
		{
			char c = exp.charAt(i);
			
			// If the scanned character is an
			// operand, add it to output.
			if (Character.isLetterOrDigit(c))
				result += c;
			
			// If the scanned character is an '(',
			// push it to the stack.
			else if (c == '(')
				stack.push(c);
			
			// If the scanned character is an ')',
			// pop and output from the stack
			// until an '(' is encountered.
			else if (c == ')')
			{
				while (!stack.isEmpty() &&
						stack.peek() != '(')
					result += stack.pop();
				
					stack.pop();
			}
			else // an operator is encountered
			{
				while (!stack.isEmpty() && Prec(c)
						<= Prec(stack.peek())){
				
					result += stack.pop();
			}
				stack.push(c);
			}
	
		}
	
		// pop all the operators from the stack
		while (!stack.isEmpty()){
			if(stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}
}

/* Tienes toda la noche para arreglar este code en cuestiones de semántica y entender que puñetas hace XD */