package java8.methodref;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestDemo {
    @Test
    public void testStaticMethodRef() {
        // static method ref (BOTH: input & output)
        Function<Integer, String> sr = String :: valueOf;
        String str  = sr.apply(100);
        Assert.assertEquals("100", sr.apply(100));
    }

    @Test
    public void testInstanceRef(){
        // instance method ref (only: output)
        Supplier<String> mr = "abc" :: toUpperCase;
        Assert.assertEquals("ABC", mr.get());
    }

    @Test
    public void test3(){
        // bi
        BiFunction<String, String, Integer> bfr = String :: compareTo;
        int result2 = bfr.apply("A", "B");
        Assert.assertEquals(-1, result2);
    }
}
