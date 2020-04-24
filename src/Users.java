import javax.print.attribute.HashDocAttributeSet;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Users implements Runnable {
    private static ExecutorService usersExec;
    private MyQueue queue;
    private int el;

    public Users(MyQueue queue){
        init();
        this.queue = queue;
    }

    private void init(){
        usersExec = Executors.newFixedThreadPool(2);
    }

    public void getElements(){

        try {
            Thread.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(queue.getSize() > 0) {

            usersExec.submit(() -> {
                el = queue.get();
            });

        }
        usersExec.shutdown();
        check();

    }

    private void check(){
        while (true){
            if(queue.getSize() >= 100) getElements();
        }
    };

    @Override
    public void run() {
        getElements();
    }

}
