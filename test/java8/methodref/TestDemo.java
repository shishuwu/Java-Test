package java8.methodref;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class TestDemo {
    @Test
    public void testStaticMethodRef() {
        // static method ref (BOTH: input & output)
        Function<Integer, String> sr = String::valueOf;
        String str = sr.apply(100);
        assertEquals("100", sr.apply(100));
    }

    @Test
    public void testInstanceRef() {
        // instance method ref (only: output)
        Supplier<String> mr = "abc"::toUpperCase;
        assertEquals("ABC", mr.get());
    }

    @Test
    public void testMultipeParams() {
        // bi
        BiFunction<String, String, Integer> bfr = String::compareTo;
        int result2 = bfr.apply("A", "B");
        assertEquals(-1, result2);
    }

    @Test
    public void testConstructRef() {
        BiFunction<Long, String, Message> constructFunc = Message::new;
        Message msg = constructFunc.apply(1L, "this is a message");

        assertEquals(1L, (long) msg.getId());
        assertEquals("this is a message", msg.getName());
    }


    @Data
    @AllArgsConstructor
    class Message {
        public Long id;
        public String name;

//        public Message(Long id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public Long getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
    }
}
