import java.util.ArrayList;
import java.util.List;

public class Stack {
    int tope; //Sí el valor del tope es -1, significa que la pila esta vacía
    List<Integer> stackList = new ArrayList<>();

    public Stack(){
        this.tope = -1;
    }

    public void apilar(int n){
        tope++; //El tope se eleva de -1 a 0
        System.out.println(tope); //Devuelve el valor del tope
        stackList.add(n);
    }
}
