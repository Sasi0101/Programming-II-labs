import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Consumer extends FactoryWorker {
    public NumberQueue belt;
    public int id;
    public String jobType;

    public Consumer(int id, NumberQueue belt) {
        super("Consumer", id, belt);
        this.belt = belt;
        this.id = id;
    }


    @Override
    public synchronized void message(int i) throws IllegalThreadStateException{
            System.out.println(jobType + "  " + id + "  " + i);
    }

    @Override
    public synchronized int action() throws IllegalThreadStateException {
            return belt.dequeue();
    }

    @Override
    public synchronized void run() throws IllegalThreadStateException{
            while(!Thread.currentThread().isInterrupted()) {
                Thread.currentThread().run();
            }
    }
}
