package homework13;

public class ArrayProcessingThread implements Runnable{
    double[] array;

    public ArrayProcessingThread(double[] array){
        this.array = array;
    }
    @Override
    public void run() {
        for (int i = 0; i < array.length; i++){
            array[i] = (double) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public double[] getArray() {
        return array;
    }
}
