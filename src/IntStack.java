public class IntStack extends Stack {

    private int arr[];

    //Constructor
    public IntStack(int maxStack){
        this.tope = -1;
        this.maxStack = maxStack;
        arr = new int[maxStack];
    }

    /* public int top(){
        return tope;
    } */

    //Devuelve el último elemento apilado
    public int info(){
        return arr[tope];
    }

    public int popInt(){
        return arr[tope--];
    }
    
    //Método para imprimir uno o más elementos de la pila
    public void print(){
        for (int i = 0; i <= tope; i++) {
            System.out.print(arr[i] + ", ");
          }
    }
    //Método para apilar elementos
    public void push(int n){
        arr[++tope]=n;
    }

    /* Método de búsqueda binaria, solo funciona para arrays de tipo númerico
    que esten ordenados de manera descedendente o ascendente */
    
    public int binarySearchIterative(int objective){
        int start=0, end=tope;
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
        for(int i=0; i<=tope;i++){
            if(arr[i]==objective){
                return i;
            }
        }
        return -1;
    }

    /* Método iterarivo estilo BubbleSort para hacer que una pila se invierta, 
    sirve para todo tipo de situaciones */
    public void reverseTheStack(){
        int aux, start=0, end=tope;
        while(start<end){
            aux = arr[start];
            arr[start] = arr[end];
            arr[end] = aux;
            start++;
            end--;
        }
    }
}
