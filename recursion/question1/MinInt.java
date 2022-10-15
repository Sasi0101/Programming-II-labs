import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.MinimumInArray;


import static java.lang.Math.min;

public class MinInt implements MinimumInArray {

    /* //Just to test
    public static void main(String[] numbers){
        int[] arr = {24,52,74,9,34,23,64,34};
        MinInt minInt = new MinInt();
        System.out.println("Minimum is: " + minInt.findMin(arr));
    }
    */

    /**
     *
     * @param array the array in which we need to find the min value
     * @return the minimum number of the array
     */
    public int findMin(int[] array){
        return findMinAux(array.length-1, array);
    }

    /**
     *
     * @param index index to go from the last element to the first
     * @param array in which the numbers are stored
     * @return returns the minimum number in the array
     */
    public int findMinAux(int index, int[] array){
        array[index-1] = min(array[index], array[index-1]);
        //return either the min value or call the function again with smaller index
        if(index == 1) return min(array[index], array[index-1]);
        else return findMinAux(index-1, array);
    }

}