class StaticVariable {
    public static String STATIC = "static";
}

class StaticMethod {
    public static void print(String method) {
        System.out.println(StaticVariable.STATIC + " " + method);
    }
}

class StaticBlock {
    private static String subject;

    static {
        System.out.println("Khối static được gọi");
    }

    static {
        subject = "Khối static (static blocks)";
    }

    StaticBlock () {
        System.out.println("hàm main() được gọi");
        System.out.println("Subject = " + subject);
    }
}

class StaticClass {
    static class NestedStaticClass {
        public static String STATIC_CLASS = "static class";
    }

    public void printStaticClass() {
        System.out.println(NestedStaticClass.STATIC_CLASS);
    }
}

public class StaticAndFinal {

    public static void main(String[] args) {
        System.out.println(StaticVariable.STATIC + " variable");

        StaticMethod.print("method print");

        StaticBlock staticBlock = new StaticBlock();

        StaticClass staticClass = new StaticClass();
        staticClass.printStaticClass();


    }
}
