public class Stack {
    private int tope; //Sí el valor del tope es -1, significa que la pila esta vacía, se encapsula el atributo para que el usuario no lo pueda modificar
    int maxStack;
    private int[] arr;
    private boolean sorted=false;

    public Stack(int maxStack){
        this.tope = -1;
        this.maxStack = maxStack;
        arr = new int[maxStack];
    }
    //Retorna el valor del tope de la pila
    public int top(){
        return tope;
    }
    //Método para apilar elementos
    public void push(int n){
        tope++; //El tope se eleva de -1 a 0
        arr[tope]=n;
    }
    //Métodos para desapilar elementos
    public void pop(){
        tope--;
    }
    //Método para imprimir uno o más elementos de la pila
    public int print(int i){
        return arr[i];
    }
    //Devuelve el último elemento apilado
    public int info(){
        return arr[tope];
    }
    /*Método para verifcar sí la pila esta llena, sí el parámetro maxStack (que es la longitud del array que define el usuario) 
    es igual a tope entonces se retorna true, sino se retorna false*/
    public boolean fullStack(){
        if(tope==maxStack-1) return true;
        else return false;
    }

    /*Método para verificar sí la pila esta vacía, verifica sí el valor del tope es -1 (es decir, que no se han hecho modificaciones en la pila) en caso de ser cierto, entonces retorna
    un true, sino se retorna un false */
    public boolean voidStack(){
        if(tope==-1) return true;
        else return false;
    }

    //Vacíar la pila
    /* El método es simple, simplemente iguala el valor del tope a -1, y como el valor del tope es el index del array, este mismo se igualará a -1, por lo que los elemenos simplemente
    se borrarán*/
    /* En este método se podrían generar errores puesto que el usuario podría modificar el atribute tope e igualarlo a 0, por ejemplo, y si llama al método print o info, entonces 
    verá el elemento que teóricamente estaba borrado */
    /* En caso de que esto en realidad sí sea un problema, podrías encapsular el atributo "tope" para que el usuario no tenga acceso directo a él */
    public void emptyStack(){
        tope = -1;
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
    /* Binary search */
    /* Para ser llamado este método, el array debe ser ordenado, ya sea de menor a mayor o de menor a mayor */
    public int binarySearchIterative(/* array, start, end y objetivo */int objective){
        int start=0, end=tope; //Start cumple el papel de left y end el papel de right
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==objective) return mid;
            if(arr[mid] <= objective) start = mid+1;
            else end = mid-1;
        }
        return -1;

    }

    /* Versión recursiva del método */
    /* public void reverseTheArray(int start, int end){

        int aux;

        if(start>=end) return;
       
        aux = arr[start];
        arr[start] = arr[end];
        arr[end] = aux;

        reverseTheArray(start+1, end-1);
    } */


    /* Sequential search  */
    /* El método simplemente va recorriendo los elementos del array uno a uno hasta encontrar el elemento que se esta buscando */
    /* Este método sirve cuando el usuario quiere buscar un método pero su pila no esta ordenada, en caso de que el array este ordenado se recomienda usar la binaryResearch por temas
    de eficiencia */
    public int sequientialSearch(int objective){
        for(int i=0; i<=tope;i++){
            if(arr[i]==objective){
                return i;
            }
        }
        return -1;
    }
    
}
