package homework13;

public class ValueCalculator {

    private static final int WORKING_ARRAY_SIZE = 1000000;
    private static final int HALF_OF_WORKING_ARRAY_SIZE = WORKING_ARRAY_SIZE / 2;
    private double[] workingArray = new double[WORKING_ARRAY_SIZE];
    private double[] workingArrayHalf1 = new double[HALF_OF_WORKING_ARRAY_SIZE];
    private double[] workingArrayHalf2 = new double[HALF_OF_WORKING_ARRAY_SIZE];


    public void comparePerformanceTimes() throws InterruptedException {

        long start = System.currentTimeMillis();
        long stop;

        System.out.println("Starting to count single thread performance");
        setWorkingArrays();
        processWorkingArraysBySingleThread();
        stop = System.currentTimeMillis();
        System.out.println("Single thread performance equals " + ((stop - start) / 1000) + " seconds");

        System.out.println("Starting to count multi thread performance");
        start = System.currentTimeMillis();
        setWorkingArrays();
        processWorkingArraysByMultiThread();
        stop = System.currentTimeMillis();
        System.out.println("Multi thread performance equals " + ((stop - start) / 1000) + " seconds");

    }

    private void setWorkingArrays() {
        for (int i = 0; i < WORKING_ARRAY_SIZE; i++) {
            workingArray[i] = Math.random() * 360;
            System.arraycopy(workingArray, 0, workingArrayHalf1, 0, HALF_OF_WORKING_ARRAY_SIZE);
            System.arraycopy(workingArray, HALF_OF_WORKING_ARRAY_SIZE, workingArrayHalf2, 0, HALF_OF_WORKING_ARRAY_SIZE);
        }
    }

    private void processWorkingArraysBySingleThread() {
        for (int i = 0; i < HALF_OF_WORKING_ARRAY_SIZE; i++) {
            workingArrayHalf1[i] = calculateNewData(workingArrayHalf1[i], i);
            workingArrayHalf2[i] = calculateNewData(workingArrayHalf2[i], i);
        }
        concatArrays();
    }

    private void processWorkingArraysByMultiThread() throws InterruptedException {
        ArrayProcessingThread arrayProcess1 = new ArrayProcessingThread(workingArrayHalf1);
        ArrayProcessingThread arrayProcess2 = new ArrayProcessingThread(workingArrayHalf2);
        Thread thread1 = new Thread(arrayProcess1);
        Thread thread2 = new Thread(arrayProcess2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            workingArrayHalf1 = arrayProcess1.getArray();
            thread2.join();
            workingArrayHalf2 = arrayProcess2.getArray();
        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }
        concatArrays();
    }

    private void concatArrays() {
        System.arraycopy(workingArrayHalf1, 0, workingArray, 0, HALF_OF_WORKING_ARRAY_SIZE);
        System.arraycopy(workingArrayHalf2, 0, workingArray, HALF_OF_WORKING_ARRAY_SIZE, HALF_OF_WORKING_ARRAY_SIZE);
    }

    private double calculateNewData (double a, int i){
        return (double) (a * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
