public class App {
    public static void main(String[] args) throws Exception {
      /* Ejercicio 1. Array invertido */
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

      CharStack palindromeStack = new CharStack(3);

      palindromeStack.push('a');
      palindromeStack.push('n');
      palindromeStack.push('a');
        
      System.out.println("");
      palindromeStack.print();

      System.out.println("");

      palindromeStack.reverseTheStack();

      palindromeStack.print();
      System.out.println();

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
        /* Se filtran todos los paréntesis, corchetes y/o llaves izquierdos */
        if(expression.charAt(i)=='(' || expression.charAt(i)=='[' || expression.charAt(i)=='{'){
            /* Se apilan en el stack */
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
      System.out.println(infixToPfix(infExpression));


  }   

  /* Método para convertir una expresión infija a postija */
	static String infixToPfix(String exp){
		String postFixExp = new String("");
		
    CharStack stack = new CharStack(exp.length());
		for (int i = 0; i<exp.length(); ++i){
			char auxChar = exp.charAt(i);
			
			// Sí el elemento que se ha encontrado es un operando
			// entonces, añade este al string "result".
			if (Character.isLetterOrDigit(auxChar))
				postFixExp += auxChar;
			
			// Sí el carácter es igual a un '('
			// entonces, guarda ese elemento en el stack.
			else if (auxChar == '(')
				stack.push(auxChar);
			
			// Sí el elemento escandeado es igual a ')',
			// entonces desapila  e imprime los elementos del stack
			// hasta que un '(' sea encontrado.
			else if (auxChar == ')'){
        /* Mientras el stack no esté vacío y el último elemento no sea '(', simplemente se desapilan los elementos de la pila y se añaden al string "result"*/
				while (!stack.isEmpty() && stack.peek() != '(')
				 postFixExp += stack.pop();
				
					stack.pop();
			}
			else{ // Un operador ha sido encontrado
        /* Mientras la pila no esté vacía or sí y el valor (que se le asignó en el método Prec) sea menor o igual al valor del último elemento de la pila, entonces 
        desapila el último elemento de la pila y añádelo a la expresión final*/
				while (!stack.isEmpty() && setPriority(auxChar) <= setPriority(stack.peek())){
					postFixExp += stack.pop();
			}

        // Guarda el operador en la pila
				stack.push(auxChar);
			}
	
		}

    /* Aquí simplemente se vacía el stack */
		while (!stack.isEmpty()){
			if(stack.peek() == '(')
				return "Carácter inválido";
			postFixExp += stack.pop();
		}
		return postFixExp;
	}

  // Básicamente, el método recibe un carácter y le asigna un número por el que va a definir su importancia
	static int setPriority(char ch)
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

