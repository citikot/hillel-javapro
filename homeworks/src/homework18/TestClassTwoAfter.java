package homework18;

public class TestClassTwoAfter {
    @BeforeSuite
    public void MethodBeforeSuiteOneTwoAfter(){
        System.out.println("MethodBeforeSuiteTwoAfter");
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
    @Priority(2)
    public void MethodThreePriorityTwo(){
        System.out.println("MethodThreePriorityTwo");
    }

    @Test
    @Priority(3)
    public void MethodFourPriorityThree(){
        System.out.println("MethodFourPriorityThree");
    }

    @Test
    @Priority(3)
    public void MethodFivePriorityThree(){
        System.out.println("MethodFourPriorityThree");
    }

    @Test
    @Priority(4)
    public void MethodSixPriorityFour(){
        System.out.println("MethodFourPriorityThree");
    }

    @Test
    @Priority(5)
    public void MethodSevenPriorityFive(){
        System.out.println("MethodSevenPriorityFive");
    }

    @AfterSuite
    public void MethodAfterSuiteOneTwoAfter(){
        System.out.println("MethodAfterSuiteOneTwoAfter");
    }

    @AfterSuite
    public void MethodAfterSuiteSecondTwoAfter(){
        System.out.println("MethodAfterSuiteSecondTwoAfter");
    }

}
