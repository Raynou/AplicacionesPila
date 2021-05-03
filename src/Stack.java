public abstract class Stack {
    protected int tope;
    public int maxStack;
    //Retorna el valor del tope de la pila
    public int top(){
        return tope;
    }
    
    //Métodos para desapilar elementos
    public void pop(){
        tope--;
    }
    /*Método para verifcar sí la pila esta llena, sí el parámetro maxStack (que es la longitud del array que define el usuario) 
    es igual a tope entonces se retorna true, sino se retorna false*/
    public boolean fullStack(){
        /* if(tope==maxStack-1) return true;
        else return false; */
        return tope == maxStack - 1;
    }

    /*Método para verificar sí la pila esta vacía, verifica sí el valor del tope es -1 (es decir, que no se han hecho modificaciones en la pila) en caso de ser cierto, entonces retorna
    un true, sino se retorna un false */
    public boolean voidStack(){
        /* if(tope==-1) return true;
        else return false; */
        return tope == -1;
    }
    public void emptyStack(){
        tope = -1;
    }
    
    
}
