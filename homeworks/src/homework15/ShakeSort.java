package homework15;

import java.util.Arrays;

public class ShakeSort {
    public static int[] array = new int[] {1,5,2,6,7,3,-10,4,-5,99,8,10,15,17,-100,100};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(array));
        doShakeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void doShakeSort(int[] array){
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex){
            for (int i = rightIndex; i > leftIndex; i--) {
                if (array[i - 1] > array[i]){
                    swapElems(i - 1, i);
                }
            }
            leftIndex++;
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i] > array[i + 1]){
                    swapElems(i, i + 1);
                }
            }
            rightIndex--;
        }
    }

    private static void swapElems(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
