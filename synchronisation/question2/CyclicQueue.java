import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.*;


public class CyclicQueue implements NumberQueue{

    /**
     * Declaring the variables we are going to use
     */
    public int[] intArray;
    public int head=0, tail=0;
    public int numberQueued = 0;

    /**
     * Handling the constructor
     * @param capacity the size of the array
     */
    public CyclicQueue(int capacity){
        //Initialising our array with a suitable size
        intArray = new int[capacity];
    }

    @Override
    public void enqueue(int i) throws IndexOutOfBoundsException{
        //If numberQueued (the number we have enqueued - the number we have dequeued) is
        //smaller than the array.length (there is still space) we add a new element to the array
        if ((numberQueued < intArray.length)) {
                head = (head + 1) % intArray.length;
                intArray[head] = i;
                numberQueued++;
            } else throw new IndexOutOfBoundsException();
    }


    @Override
    public int dequeue() throws IndexOutOfBoundsException{
        //If there are still values in the array we take it out
            if ((numberQueued > 0)) {
                numberQueued--;
                tail = (tail + 1) % intArray.length;
                return intArray[tail];
            } else throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isEmpty() {
        //Check if array is empty or not
        return numberQueued == 0;
    }

}
