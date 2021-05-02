public class App {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        
        stack.push(1); 
        stack.push(2); 
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Posición del último elemento: "+stack.top());
        //stack.pop();
        //System.out.println(stack.top());
        System.out.println("Pila completa: ");
       for(int i=0; i<=stack.top();i++){
           System.out.println(stack.print(i));
        }
       System.out.println("El último elemento apilado es: " + stack.info()); 
       
       //Sí el método fullstack retorna true se imprime el mensaje de "Pila llena"
       if(stack.fullStack()) System.out.println("Pila llena");
       else System.out.println("La pila aún no esta llena");

       //Sí el método retorna un true, se imprime "La pila esta vacía", sino, se imprime "La pila no esta vacía"
       if(stack.voidStack()) System.out.println("La pila esta vacía");
       else System.out.println("La pila no esta vacía");

       /* Aquí se hace una prueba para vacíar la pila */
       System.out.println("==========================="+"\n");
       stack.emptyStack();
       if(stack.voidStack()) System.out.println("La pila esta vacía");
       else System.out.println("La pila no esta vacía");

       stack.push(67);
       stack.push(290);
       stack.push(27);
       stack.push(14);
       stack.push(390);
       
       /* Se vuelve a llenar la pila */
       /* Se imprimen los nuevos valores  pusheados, en caso de no existir, no se imprime nada */
       for(int i=0; i<=stack.top();i++){
        System.out.println(stack.print(i));
      }

      System.out.println("Último elemento insertado: "+stack.info());

      /* Se imprime denuevo la pila, para verificar que el último elemento no haya sido desapilado */
      /* Sería eficiente integrar el método para introducir e imprimir valores del array, para ahorrar líneas de código */
      for(int i=0; i<=stack.top();i++){
        System.out.println(stack.print(i));
        /* Expected output:
        67
        290
        27 */
      }

      System.out.println("Array invertido");
      //stack.reverseTheArray(0, stack.top());
      stack.reverseTheStack();
      //System.out.println(stack.info());
      for(int i=0; i<=stack.top();i++){
        System.out.println(stack.print(i));
      }
      int result=stack.sequientialSearch(390);
      if(result == -1){
          System.out.println("Elemento no encontrado");
      }else{
          System.out.println("Elemento encontrado en el index: "+result);
      }
    }
}
