
package java8.interfaceEnhance;


public class TestDemo {
}

/**
 * Interface supports:
 * <pre>
 * - constant
 * - abstract method
 * - default method (new)
 * - static method (new)
 * </pre>
 */
interface IMessage {
    public static final String STR = "THIS IS A STRING";

    public void print();

    default void fun() {
        System.out.println("this is a default method after java 8");
    }

    static void get() {
        System.out.println("this is a static method after java 8");
    }
}