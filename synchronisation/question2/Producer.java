import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

import java.util.Random;

public class Producer extends FactoryWorker {

    /**
     * Declaring the variables we are going to use
     */
    public String jobType;
    public int id;
    public NumberQueue belt;
    public Random rand = new Random();

    public Producer(int id, NumberQueue belt) throws IllegalThreadStateException{
        super("Producer", id, belt);
        this.id = id;
        this.belt = belt;

    }

    @Override
    public synchronized void message(int i) throws IllegalThreadStateException{
            System.out.println(jobType + "  " + id + "  " + i);

    }

    @Override
    public synchronized int action() throws IllegalThreadStateException {
        int randomNumber = rand.nextInt();
        belt.enqueue(randomNumber);
        return randomNumber;
    }

    @Override
    public synchronized void run() throws IllegalThreadStateException{
        while(!(Thread.currentThread().isInterrupted())) {
            Thread.currentThread().run();
        }
    }
}
