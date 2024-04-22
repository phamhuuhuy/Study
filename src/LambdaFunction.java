
interface Shape {
    void draw();
}

interface Addable {
    int add(int a, int b);
}

public class LambdaFunction {

    public static void main(String[] args) {
        // void method - one line
        Shape rectangle = () -> System.out.println("draw rectangle");
        rectangle.draw();

        // return value method - multiple line
        Addable addable = (a, b) -> {
            int c = 10;
            return a + b + c;
        };
        int result = addable.add(3,7);
        System.out.println(result);

        // with thread
        Thread threadLambda = new Thread(() -> System.out.println("run method called using lambda ..."));
        threadLambda.start();

    }
}
