package Practice.Clase2;
import ADT.LinkedStack;

public class Ejercicio2 {


    public static void main(String[] args) {
        LinkedStack<Integer> S = new LinkedStack<Integer>();
        LinkedStack<Integer> T = new LinkedStack<Integer>();

        for (int i = 0; i < 10; i++) {
            S.push(2*i);
            T.push(2*i-1);
        }
        System.out.println(S);
        System.out.println(S.top());
        System.out.println(T);
        System.out.println(T.top());
        transfer(S,T);
        System.out.println(S);
        System.out.println(T);
    }
    /*
    public static void transfer(LinkedStack<Integer> S, LinkedStack<Integer> T){

        LinkedStack<Integer> temp = new LinkedStack<>();
        while(!S.isEmpty()){
            temp.push(S.pop());
        }
        while(!T.isEmpty()){
            S.push(T.pop());
        }
        while(!temp.isEmpty()){
            T.push(temp.pop());
        }
        */
    public static void transfer(LinkedStack<Integer> S, LinkedStack<Integer> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }




}
