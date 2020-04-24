import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producers implements Runnable {
    private Random random;
    private MyQueue queue;
    private ExecutorService prodExec;

    public Producers(MyQueue queue){
        init();
        this.queue = queue;
    }

    private void init(){
        prodExec = Executors.newFixedThreadPool(3);
        random = new Random();
    }

    public void addElements(){
        while(queue.getSize() < 100) {

            prodExec.submit(() -> {
                queue.add(random.nextInt() % 100 + 1);
            });
        }
        prodExec.shutdown();
        check();
    }

    private void check(){
        while (true){
            if(queue.getSize() <= 80) addElements();
        }
    };

    @Override
    public void run() {
        addElements();
    }

}
