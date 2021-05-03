public class CharStack{
    // store elements of stack
    private char arr[];
    // represent top of stack
    private int top;
    // total capacity of the stack
    private int capacity;
  
    // Creating a stack
    CharStack(int size) {
      // initialize the array
      // initialize the stack variables
      arr = new char[size];
      capacity = size;
      top = -1;
    }
  
    // push elements to the top of stack
    public void push(char x) {
      if (isFull()) {
        System.out.println("Stack OverFlow");
  
        // terminates the program
        System.exit(1);
      }
  
      // insert element on top of stack
      arr[++top] = x;
    }
  
    // pop elements from top of stack
    public char pop() {
  
      // if stack is empty
      // no element to pop
      if (isEmpty()) {
        System.out.println("STACK EMPTY");
        // terminates the program
        System.exit(1);
      }
  
      // pop element from top of stack
      return arr[top--];
    }
  
    // return size of the stack
    public int getSize() {
      return top + 1;
    }
  
    // check if the stack is empty
    public Boolean isEmpty() {
      return top == -1;
    }
  
    // check if the stack is full
    public Boolean isFull() {
      return top == capacity - 1;
    }
  
    // display elements of stack
    public void printStack() {
      for (int i = 0; i <= top; i++) {
        System.out.print(arr[i] + ", ");
      }
    }

    //return the element at the top of the array
    public char peek(){
        return arr[top];
    }

    //Method for get i element
    public char getElement(int i){
        return arr[top];
    }


    public Boolean isPalindrome(/* No recibe nada */){
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
