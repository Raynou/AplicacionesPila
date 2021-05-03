public class CharStack{
    // store elements of stack
    private char arr[];
    // Representa el elemento tope del array
    private int top;
    // total capacity of the stack
    private int capacity;
  
    // Constructor
    CharStack(int size) {
      
      arr = new char[size];
      capacity = size;
      top = -1;
    }
  
    // Apilar elementos al array
    public void push(char x) {
        // Verifica sí el array esta lleno
      if (isFull()) {
        System.out.println("Stack OverFlow");
  
        // System.exit(1) como un especie de "break", también se puede decir que "Termina el progama"
        System.exit(1);
      }
  
      // Inserta elementos en el array
      arr[++top] = x;
    }
  
    // Desapila un elemento del array
    public char pop() {
  
      // Verifica sí el stack no esta lleno
      // no element to pop
      if (isEmpty()) {
        System.out.println("STACK EMPTY");
        // terminates the program
        System.exit(1);
      }
  
      // Desapila el elemento que esta en el tope del array
      return arr[top--];
    }
  
    // Retorna la longitud del stack
    public int getSize() {
      return top + 1;
    }
  
    // Verifica sí el array esta vacío
    // Me da curiosidad como funciona este método, es diferente... ¿Cuál es la diferencia entre Boolean y boolean?
    public Boolean isEmpty() {
      return top == -1;
    }
  
    // Verifica sí el array esta lleno
    public Boolean isFull() {
      return top == capacity - 1;
    }
  
    // Imprime los elementos del array
    public void printStack() {
      for (int i = 0; i <= top; i++) {
        System.out.print(arr[i] + ", ");
      }
    }

    //Retorna el elemento que esta en el tope del array sin desapilarlo
    public char peek(){
        return arr[top];
    }

    //Método para obtener el i-ésimo elemento del stack
    public char getElement(int i){
        return arr[top];
    }


    
    public Boolean isPalindrome(){
        char auxArr[]=new char[arr.length];
        String origWord = new String(arr); 
        origWord.trim();
        for(int i=0; i<auxArr.length;i++){
            auxArr[i] = origWord.charAt(i);
        }

        reverseTheStack(auxArr);

        String auxWord = new String(auxArr);
        auxWord.trim();
        if(auxWord.equals(origWord)) return true;
        else return false;

             
    }

    /* Método iterativo para invertir el stack */

    public void reverseTheStack(){
        char aux;
        int start=0, end=top;
        while(start<end){
            aux = arr[start];
            arr[start] = arr[end];
            arr[end] = aux;
            start++;
            end--;
        }
    }    

    /* Método sobrecargado pensado para ser usado con el método isPalindrome*/
    public void reverseTheStack(char arr[]){
        char aux;
        int start=0, end=top;
        while(start<end){
            aux = arr[start];
            arr[start] = arr[end];
            arr[end] = aux;
            start++;
            end--;
        }
    }
    /* Método sobrecargado pensado para ser usado con el método isPalindrome*/


    public void print(){
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
          }
    }

}
