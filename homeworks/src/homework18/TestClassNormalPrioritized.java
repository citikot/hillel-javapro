package homework18;

public class TestClassNormalPrioritized {

    @BeforeSuite
    public void MethodBeforeSuiteNormalPrioritized(){
        System.out.println("MethodBeforeSuiteNormalPrioritized");
    }

    @Test
    @Priority(1)
    public void MethodOnePriorityOne(){
        System.out.println("MethodOnePriorityOne");
    }

    @Test
    @Priority(2)
    public void MethodTwoPriorityTwo(){
        System.out.println("MethodTwoPriorityTwo");
    }

    @Test
    @Priority(4)
    public void MethodThreePriorityFour(){
        System.out.println("MethodThreePriorityFour");
    }

    @Test
    @Priority(3)
    public void MethodFourPriorityThree(){
        System.out.println("MethodFourPriorityThree");
    }

    @Test
    @Priority(1)
    public void MethodFivePriorityOne(){
        System.out.println("MethodFivePriorityOne");
    }

    @Test
    @Priority(2)
    public void MethodSixPriorityTwo(){
        System.out.println("MethodSixPriorityTwo");
    }

    @Test
    @Priority(5)
    public void MethodSevenPriorityFive(){
        System.out.println("MethodSevenPriorityFive");
    }

    @AfterSuite
    public void MethodAfterSuiteNormalPrioritized(){
        System.out.println("MethodAfterSuiteNormalPrioritized");
    }
}
