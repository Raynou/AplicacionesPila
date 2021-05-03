public class CharStack implements StackInterface{
    private char arr[];
    private int top;
    private int capacity;
  
    // Constructor
    CharStack(int size) {
      
      this.arr = new char[size];
      this.capacity = size;
      this.top = -1;
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
    @Override
    public int getSize() {
      return top + 1;
    }    
  
    // Verifica sí el array esta lleno
    @Override
    public Boolean isFull() {
        return top == capacity - 1;
    }
    // Verifica sí el array esta vacío
    @Override
    public Boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int getCapacity(){
        return capacity;
    }
    // Imprime los elementos del array
    @Override
    public void print() {
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

    

    @Override
    public void reverseTheStack() {
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

    

    

    

    
  
    

}
