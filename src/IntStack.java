public class IntStack extends Stack {

    private int arr[];

    
    //Devuelve el último elemento apilado
    public int info(){
        return arr[tope];
    }
    
    //Método para imprimir uno o más elementos de la pila
    public int print(int i){
        return arr[i];
    }
    //Método para apilar elementos
    public void push(int n){
        tope++; //El tope se eleva de -1 a 0
        arr[tope]=n;
    }
    
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
    public int sequientialSearch(int objective){
        for(int i=0; i<=tope;i++){
            if(arr[i]==objective){
                return i;
            }
        }
        return -1;
    }

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
