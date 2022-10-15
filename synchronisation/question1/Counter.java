import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.UnitCounter;

public class Counter implements UnitCounter {

    int counter = 0;
    @Override
    public void addOne() {
        synchronized (this) {
            counter++;
        }
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
