
import java.util.LinkedList;
import java.util.Queue;

public class Queuepro {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        //Add a data in queue
        queue.offer("Mobile");
        queue.offer("Laptop");
        queue.offer("Tv");
        queue.offer("Tablet");

        //display
        System.out.println(queue);

        //remove 
        queue.poll();

        //display
        System.out.println(queue);

        //display the front element
        System.out.println(queue.element());
    }
}
