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
      testStack.pop();

      testStack.print();

      System.out.println("\n==================");

      /* Ejercicio 1. Array invertido */
      IntStack myStack = new IntStack(10);
      
      for(int i=0; i<myStack.getCapacity();i++) myStack.push(i);
      /* Se llena la pila con un ciclo */
      
      
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

  /* Método para convertir una expresión infija a postija */
	static String infixToPostfix(String exp){
		// initializing empty String for result
		String result = new String("");
		
		// initializing empty stack
    CharStack stack = new CharStack(exp.length());
		for (int i = 0; i<exp.length(); ++i){
			char c = exp.charAt(i);
			
			// Sí el elemento que se ha encontrado es un operando
			// entonces, añade este al string "result".
			if (Character.isLetterOrDigit(c))
				result += c;
			
			// Sí el carácter es igual a un '('
			// entonces, guarda ese elemento en el stack.
			else if (c == '(')
				stack.push(c);
			
			// Sí el elemento escandeado es igual a ')',
			// entonces desapila  e imprime los elementos del stack
			// hasta que un '(' sea encontrado.
			else if (c == ')'){
        /* Mientras el stack no esté vacío y el último elemento no sea '(', simplemente se desapilan los elementos de la pila y se añaden al string "result"*/
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();
				
					stack.pop();
			}
			else{ // Un operador ha sido encontrado
        /* Mientras la pila no esté vacía or sí y el valor (que se le asignó en el método Prec) sea menor o igual al valor del último elemento de la pila, entonces 
        desapila el último elemento de la pila y añádelo a la expresión final*/
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
					result += stack.pop();
			}

        // Guarda el operador en la pila
				stack.push(c);
			}
	
		}
	
		// pop all the operators from the stack
    /* Aquí simplemente se vacía el stack */
		while (!stack.isEmpty()){
			if(stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

  // Básicamente, el método recibe un carácter y le asigna un número por el que va a definir su importancia
	static int Prec(char ch)
	{
    /* Aquí se define la jerarquía de los signos de las operaciones */
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
}

/* Tienes toda la noche para arreglar este code en cuestiones de semántica y entender que puñetas hace XD */