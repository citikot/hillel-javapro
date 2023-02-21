package homework18;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class TestRunner {

    public static void main(String[] args) {

        start(TestClassNormalPrioritized.class);
        System.out.println("*******");
        start(TestClassNoBefore.class);
        System.out.println("*******");
        start(TestClassNoAfter.class);
        System.out.println("*******");
        start(TestClassTwoBefore.class);
        System.out.println("*******");
        start(TestClassTwoAfter.class);
        System.out.println("*******");

    }

    public static void start(Class workingClass) {
        Method[] methods = workingClass.getDeclaredMethods();
        List<Method> methodsOrdered = new ArrayList<>();

        List<Method> beforeMethodsList = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                .collect(Collectors.toList());
        if (beforeMethodsList.size() > 1) {
            throw new RuntimeException("BeforeSuite or AfterSuite method must be one in the class");
        }

        List<Method> afterMethodsList = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(AfterSuite.class))
                .collect(Collectors.toList());
        if (afterMethodsList.size() > 1) {
            throw new RuntimeException("BeforeSuite or AfterSuite method must be one in the class");
        }

        List<Method> orderedTestMethodList = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .filter(method -> method.isAnnotationPresent(Priority.class))
                .sorted((m1, m2) -> m1.getAnnotation(Priority.class).value() - m2.getAnnotation(Priority.class).value())
                .toList();

        methodsOrdered.addAll(orderedTestMethodList);
        if (!beforeMethodsList.isEmpty()) {
            methodsOrdered.add(0, beforeMethodsList.get(0));
        }
        if (!afterMethodsList.isEmpty()) {
            methodsOrdered.add(methodsOrdered.size(), afterMethodsList.get(0));
        }

        methodsOrdered.forEach(method -> {
            try {
                method.invoke(workingClass.getDeclaredConstructor().newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
