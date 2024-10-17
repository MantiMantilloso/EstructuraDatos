package EI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        double[] array1 = {23232.1, 2131231,123123, 1231.3, 3232.3, 32932.2, 3,32, 32};
        System.out.println(arrayMax(array1));

        ArrayList<Integer> list1 = new ArrayList<Integer>();

        int n = 10000;
        for (int i = 0; i < n; i++) {
            list1.add(1);
        }

        long startTime = System.currentTimeMillis();
        iterateArray(list1);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");
    }
    public static double arrayMax(double[] arr) {
        int n = arr.length;
        double max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static void iterateArray(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println('\n');
    }
}