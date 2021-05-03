public class IntStack implements Stack{

    private int arr[];
    private int top;
    private int capacity;

    //Constructor
    public IntStack(int size){
        this.top = -1;
        this.capacity = size;
        this.arr = new int[size];
    }


    // Apilar elementos al array
    public void push(int x) {
        // Verifica sí el array esta lleno
      if (isFull()) {
        System.out.println("StackOverFlow");
  
        // System.exit(1) como un especie de "break", también se puede decir que "Termina el progama"
        System.exit(1);
      }
  
      // Inserta elementos en el array
      arr[++top] = x;
    }
  
    // Desapila un elemento del array
    public int pop() {
  
      // Verifica sí el stack no esta vacío
      if (isEmpty()) {
        System.out.println("Pila vacía");
        System.exit(1);
      }
  
      // Desapila el elemento que esta en el tope del array
      return arr[top--];
    }

    @Override
    public Boolean isFull() {
        return top == capacity - 1;
    }


    @Override
    public Boolean isEmpty() {
        return top == -1;
    }


    @Override
    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
          }
    }


    @Override
    public int getSize() {
        return top + 1;
    }
    
    @Override
    public int getCapacity(){
        return capacity;
    }
    //Método para obtener el i-ésimo elemento del stack
    public int getElement(int i){
        return arr[top];
    }
    /* Método de búsqueda binaria, solo funciona para arrays de tipo númerico
    que esten ordenados de manera descedendente o ascendente */
    
    public int binarySearchIterative(int objective){
        int start=0, end=top;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==objective) return mid;
            if(arr[mid] <= objective) start = mid+1;
            else end = mid-1;
        }
        return -1;

    }

    /* Simple búsqueda secuencial, solo pasa por cada uno de los elementos del
    array hasta encontrarse con su objetivo, útil para una pila desordenada. 
    Nota: no debe ser usado para una pila ordenada por temas de optimización */
    public int sequientialSearch(int objective){
        for(int i=0; i<=top;i++){
            if(arr[i]==objective){
                return i;
            }
        }
        return -1;
    }

    /* Método iterarivo estilo BubbleSort para hacer que una pila se invierta, 
    sirve para todo tipo de situaciones */
    public void reverseTheStack(){
        int aux, start=0, end=top;
        while(start<end){
            aux = arr[start];
            arr[start] = arr[end];
            arr[end] = aux;
            start++;
            end--;
        }
    }


    
}
