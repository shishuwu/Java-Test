package jasons.algo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author shishu
 */
public class Wave {

    private List<Integer> initList() {
        List<Integer> result = new ArrayList<Integer>();
        result.add(2);
        result.add(1);
        result.add(4);
        result.add(3);
        result.add(5);
        return result;
    }

    public List<Integer> wave(List<Integer> a) {
        if (a == null || a.isEmpty()) {
            return null;
        }
        Collections.sort(a);

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {

            if (i % 2 == 0) {
                if ((i + 1) < a.size()) {
                    result.add(a.get(i + 1));
                }
                result.add(a.get(i));
            }
        }
        return result;
    }

    public List<Integer> wave2(List<Integer> A) {

        Collections.sort(A);
        int n = A.size();

        for (int i = 2; i <= n; i += 2) {
            exch(A, i - 2, i - 1);
        }

        return A;

    }

    private void exch(List<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    @Test
    public void test() throws Exception {
        Wave test = new Wave();
        System.out.println(test.wave(test.initList()));
        System.out.println(test.wave2(test.initList()));
    }
}
