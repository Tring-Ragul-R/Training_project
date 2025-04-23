
import java.util.*;

public class Array {

    static int size;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Array Size");
        try {
            size = scanner.nextInt();
            if (size > 0) {
                arr = new int[size];
                System.out.println("Enter the value");

                //Insert a value

                for (int i = 0; i < size; i++) {
                    arr[i] = scanner.nextInt();
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Enter proper value");
        }

        //update a element
        arr[2] = 54;
        
        //traverse a array 

        System.out.println(Arrays.toString(arr));
    }
}
