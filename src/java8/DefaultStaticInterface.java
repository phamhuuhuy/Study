package java8;

interface Interface1 {
    default void doSomething() {
        System.out.println("interface 1");
    }
}

interface Interface2 {
    default void doSomething() {
        System.out.println("interface 2");
    }
}

class Parent {
    public void doSomething() {
        System.out.println("interface 2");
    }
}

class MultiInheritance implements Interface1, Interface2 {
    @Override
    public void doSomething() {
        Interface1.super.doSomething();
        Interface2.super.doSomething();
    }
}

class MultiInheritance2 extends Parent implements Interface2 {}

interface Interface4 {

    void speak();

    default void setColor(String color) {
        System.out.println("Draw shape with color " + color);
    }

    static void setLeg(int leg) {
        System.out.println("Animal has " + leg);
    }
}

class Inheritance implements Interface4 {

    @Override
    public void speak() {
        Interface4.setLeg(5);
        System.out.println("quack quack");
    }

}

public class DefaultStaticInterface {
    public static void main(String[] args) {

        Interface4 inheritance = new Inheritance();
        inheritance.speak();
        inheritance.setColor("red");

        Interface4.setLeg(5);

        MultiInheritance m = new MultiInheritance();
        m.doSomething(); // Execute in Interface 1 , Interface 2

        MultiInheritance2 m1 = new MultiInheritance2();
        m1.doSomething(); // Execute in java8.Parent
    }
}
