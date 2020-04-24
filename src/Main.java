import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program started!");
        MyQueue queue = new MyQueue();

        Thread p = new Thread(new Producers(queue));
        Thread u = new Thread(new Users(queue));

        p.start();
        u.start();

        while (true) {
            try {
                if (!(System.in.read() != 'q')) System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
