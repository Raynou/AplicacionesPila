public class CharStack extends Stack {
    char arr[];

    //Constructor
    public CharStack(int maxStack){
        this.tope = -1;
        this.maxStack = maxStack;
        arr = new char[maxStack];
    }

    //Método para imprimir uno o más elementos de la pila
    public char print(int i){
        return arr[tope];
    }

    //Métodos para desapilar elementos
    public int popChar(){
        return arr[--tope];
    }

    //Método para apilar elementos
    public void push(char n){
        tope++; //El tope se eleva de -1 a 0
        arr[tope]=n;
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
        int start=0, end=tope;
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
        int start=0, end=tope;
        while(start<end){
            aux = arr[start];
            arr[start] = arr[end];
            arr[end] = aux;
            start++;
            end--;
        }
    }
    /* Método sobrecargado pensado para ser usado con el método isPalindrome*/

    public Boolean checkParenthesis(String exprString){
        for(int i=0; i<exprString.length(); i++){
            /* Left parenthesis array */
            if(exprString.charAt(i)=='(' || exprString.charAt(i)=='[' || exprString.charAt(i)=='{'){
                /* Save the character on the array */
                arr[i]=exprString.charAt(i);
            }
            
        }

        char auxArr[]=new char[exprString.length()];
        for(int i=0; i<exprString.length();i++){
            if(exprString.charAt(i)==')' || exprString.charAt(i)==']' || exprString.charAt(i)=='}'){
                /* Save the character on the array */
                auxArr[i]=exprString.charAt(i);
            }
        }

        /* Recupera el tope del array original y el tope del auxiliar */
        if(auxArr.length==arr.length) return true;
        else return false;        
    }

}
