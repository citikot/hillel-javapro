package homework12;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    public <T> List<T> toList(T[] array){
        return Arrays.asList(array);
    }
}
