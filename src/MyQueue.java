import java.util.ArrayDeque;
import java.util.Queue;

public class MyQueue {
    private static Queue<Integer> queue;

    public MyQueue(){
        queue = new ArrayDeque<>(200);
    }

    public static int get() {
        return queue.poll();
    }

    public static void add(int value) {
        queue.offer(value);
    }

    public static int getSize(){
        return queue.size();
    }
}
