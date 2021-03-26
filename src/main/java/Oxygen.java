import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Oxygen implements Runnable {
    private final String oxygen = "O";
    private final CyclicBarrier cyclicBarrier;

    public Oxygen(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    private void releaseOxygen() {
        System.out.print(oxygen);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        releaseOxygen();
    }
}