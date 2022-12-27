package homework9.commontasks;

import java.util.*;

public class ListsManipulations {
    public static void main(String[] args) {
        Integer[] integerArray = {0, 15, 31, 0, 15, 31, 21, 18, 21, 89};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(0, 15, 31, 0, 15, 31, 21, 18, 21, 89));
        List<String> stringList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "three", "two", "two"));

        System.out.println(countOccurance(stringList, "two"));
        System.out.println(toList(integerArray));
        System.out.println(findUnique(integerList));
        calcOccurance(stringList);
        System.out.println(findOccurrence(stringList));
    }


    public static int countOccurance(List<String> stringList, String stringToCount) {
        int counter = 0;
        for (String elem : stringList) {
            if (elem.equals(stringToCount)) {
                counter++;
            }
        }
        return counter;
    }

    public static List<Integer> toList(Integer[] integerArray) {
        List<Integer> list = new ArrayList<>();
        for (int elem : integerArray) {
            list.add(elem);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> integerList) {
        return new ArrayList<>(new HashSet<>(integerList));
    }

    public static void calcOccurance(List<String> stringList) {
        Map<String, Integer> result = new HashMap<>();
        for (String elem : stringList) {
            if (result.putIfAbsent(elem, 1) != null) {
                result.put(elem, result.get(elem) + 1);
            }
        }

        // output as required in task 4 **
        for (String elem : result.keySet()) {
            System.out.println(elem + ": " + result.get(elem));
        }
    }

    public static List<WordCounter> findOccurrence(List<String> stringList) {
        Map<String, Integer> mappedDistribution = new HashMap<>();
        for (String elem : stringList) {
            if (mappedDistribution.putIfAbsent(elem, 1) != null) {
                mappedDistribution.put(elem, mappedDistribution.get(elem) + 1);
            }
        }

        // output as required in task 4 ***
        List<WordCounter> outputList = new ArrayList<>();
        for (String elem : mappedDistribution.keySet()) {
            outputList.add(new WordCounter(elem, mappedDistribution.get(elem)));
        }
        return outputList;
    }
}
