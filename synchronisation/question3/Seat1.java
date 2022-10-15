import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

import java.util.concurrent.locks.ReentrantLock;

public class Seat1 implements Seat {

    private ReentrantLock reentrantLock;
    @Override
    public void askFork1() {
        reentrantLock.lock();
    }

    @Override
    public void askFork2() {
        reentrantLock.lock();
    }

    @Override
    public void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {
        this.reentrantLock = reentrantLock;
    }
}
