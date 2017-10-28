package jetty;

/**
 * Created by khanh on 27/10/2017.
 */
public class Test {

    // static initialization
    static {
        System.out.println("test");
    }

//    private TestOrderCreateInstance test1 = new TestOrderCreateInstance();

    // other way to init
    private TestOrderCreateInstance test1;

    {
        test1 = new TestOrderCreateInstance();
    }

    private TestOrderCreateInstance2 test2;

    public Test() {
        test2 = new TestOrderCreateInstance2();
    }

    public static void main(String[] args) {
        new Test();
    }

    private class TestOrderCreateInstance {

        public TestOrderCreateInstance() {
            System.out.println(TestOrderCreateInstance.class.getSimpleName());
        }

    }

    private class TestOrderCreateInstance2 {

        public TestOrderCreateInstance2() {
            System.out.println(TestOrderCreateInstance2.class.getSimpleName());
        }

    }

}
