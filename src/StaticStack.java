public class StaticStack {
    int tope; //Sí el valor del tope es -1, significa que la pila esta vacía
    int maxStack;
    int[] arr;
    public StaticStack(int maxStack){
        this.tope = -1;
        this.maxStack = maxStack;
        arr = new int[maxStack];
    }
    public int imprimirValorMaximo(){
        return arr.length;
    }
    public void apilar(int n){
        tope++; //El tope se eleva de -1 a 0
        System.out.println(tope); //Devuelve el valor del tope
        n = arr[tope];
    }
}
