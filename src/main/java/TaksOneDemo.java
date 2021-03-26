import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaksOneDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(3);

        for (int i = 0; i < 5; i++) {
            service.execute(new Hydrogen(barrier));
            service.execute(new Hydrogen(barrier));
            service.execute(new Oxygen(barrier));
        }
        service.shutdown();
    }
}
