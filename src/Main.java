import java.io.IOException;

public class Main {

    // Панфилов Алексей БАСО-02-18
    // Практическая работа: 3 производителя, 2 потребителя

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
