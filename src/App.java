public class App {
    public static void main(String[] args) throws Exception {

      /* Ejercicio 1. Array invertido */
      IntStack myStack = new IntStack(7);

      for(int i=0; i<myStack.top();i++){
        myStack.push(i);
      }
      for(int i=0; i<myStack.top();i++){
         System.out.println(myStack.print(i));
      }
      myStack.reverseTheStack();

      for(int i=0; i<myStack.top();i++){
         System.out.println(myStack.print(i));
    }        
  }       
}
