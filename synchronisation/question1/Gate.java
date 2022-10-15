public class Gate implements Runnable{
    int enteredH;
    private final Counter counter;

    public Gate(Counter counter, int enteredHere){
        enteredH = enteredHere;
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < enteredH; i++) {
            counter.addOne();
        }
    }

}