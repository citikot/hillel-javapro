package homework15;

import java.util.Arrays;

public class QuickSort {
    public static int[] array = new int[]{8, 15, -100, 100, 80, 1, 10, 18, 17, 300, 4, 96, 185, 156, -456, 18, 19, 220, 380, 122, 7};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(array));
        doQuickSort(0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void doQuickSort(int leftIndex, int rightIndex) {
        int rightPivot = rightIndex;
        int leftPivot = leftIndex;
        int tmp = 0;

        if (leftIndex < rightIndex) {
            while (leftPivot < rightPivot) {
                if (array[leftPivot] > array[rightPivot]) {
                    tmp = array[leftPivot];
                    for (int j = leftPivot; j < rightPivot; j++) {
                        array[j] = array[j + 1];
                    }
                    array[rightPivot] = tmp;
                    rightPivot--;
                    leftPivot = leftIndex;
                } else {
                    leftPivot++;
                }
            }

            if (rightPivot == array.length - 1) {
                doQuickSort(leftIndex, rightPivot - 1);
            } else {
                doQuickSort(rightPivot + 1, rightIndex);
                doQuickSort(leftIndex, rightPivot - 1);
            }
        }
    }
}

