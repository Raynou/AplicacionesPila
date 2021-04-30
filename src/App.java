public class App {
    public static void main(String[] args) throws Exception {
        StaticStack stack = new StaticStack(2);
        System.out.println(stack.imprimirValorMaximo());
        stack.apilar(1);
        stack.apilar(2);
    }
}
