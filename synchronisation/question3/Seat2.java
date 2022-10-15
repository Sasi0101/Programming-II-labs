import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

import java.util.concurrent.locks.ReentrantLock;

public class Seat2 implements Seat {

    private ReentrantLock reentrantLock1;
    @Override
    public void askFork1() {
            reentrantLock1.lock();
    }

    @Override
    public void askFork2() {
            reentrantLock1.lock();
    }

    @Override
    public void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {
        this.reentrantLock1 = reentrantLock1;
    }
}
