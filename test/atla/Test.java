package atla;

public class Test {
    public static void main3(String[] args) {
        int[] a = { 1 };
        Test t = new Test();
        t.increment(a);
        System.out.println(a[a.length - 1]);
    }

    void increment(int[] i) {
        i[i.length - 1]++;
    }

    // ==========================
    public void divide(int a, int b) {
        try {
            int c = a / b;
        }
        catch (Exception e) {
            System.out.print("Exception ");
        }
        finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        new Test().divide(4, 0);
    }
}
