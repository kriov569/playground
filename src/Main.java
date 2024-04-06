import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
public class Main {
    /*
            Дан массив целых чисел длиной n и числа k
            Нужно вывести все подмассивы длиной k  входящих в исходный массив
         */
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int k = 2;

        printSubarray(arr, k);
     }

    private static void printSubarray(ArrayList<Integer> arr, int k) {
        LinkedList<Integer> subList = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            subList.add(arr.get(i));
        }

        System.out.println(subList);

        for (int i = k; i < arr.size(); i++) {
            subList.add(arr.get(i));
            subList.remove();
            System.out.println(subList);
        }
    }
}