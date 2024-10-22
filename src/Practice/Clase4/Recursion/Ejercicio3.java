package Practice.Clase4.Recursion;

public class Ejercicio3 {
    public static boolean isPalindrome(String str) {
        if(str == null || str.isEmpty() || str.length() == 1)
            return true;
        else if (str.charAt(0) == str.charAt(str.length()-1)){
                return isPalindrome(str.substring(1, str.length()-1));
            }
        else return false;
    }

    public static void main(String[] args) {

        String hola = "Hola";
        String ejemplosi1 = "aba";
        String ejemplosi2 = "sobreverbos";

        System.out.println(isPalindrome(ejemplosi1));
        System.out.println(isPalindrome(hola));
        System.out.println(isPalindrome(ejemplosi2));


    }
}
