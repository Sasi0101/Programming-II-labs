

public class Belt extends CyclicQueue {

    /**
     * Creating a new cyclicQueue
     * @param capacity the size of the array
     */
    public Belt(int capacity){
            super(capacity);
    }

    @Override
    public synchronized void enqueue(int i) throws IllegalThreadStateException {
        if(numberQueued == intArray.length){
            try {
                //Try waiting until it gets notified
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalThreadStateException();
            }
        }
        //Do the enqueue and than notify all the threads
            super.enqueue(i);
           this.notifyAll();
    }

    @Override
    public synchronized int dequeue() throws IllegalThreadStateException{
        if(isEmpty()) {
            //Try waiting until it gets notified
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Saving the super.dequeue to a variable so we can notify all the threads
        int i = super.dequeue();
        this.notifyAll();
        return i;
    }
}
