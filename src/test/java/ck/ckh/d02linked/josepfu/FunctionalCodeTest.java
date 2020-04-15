package ck.ckh.d02linked.josepfu;

import lombok.*;
import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.Arrays.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Joe
 * @create 2020/3/13 19:52
 */
public class FunctionalCodeTest {
    @Test
    public void t1() {
        // string 类本来就是 不可更改的, 在jdk8中, 有效final的变量可以不写final
        String name = "sf";
        // name = "s"; // 重新给 name 赋值, error, 编译器认为不是 有效final 的
        final int i = 1;
        new Thread(() -> {
            // lambda 表达式中必须是由有效 final 的变量, error, 编译报错
            // 因为lambda引用的是 值 , 而不是变量
            System.out.println(name + i);
        }, "t1").start();
    }

    @Test
    public void t2() {
        Function<Integer, Integer> add = (x) -> x + 2;
        ThreadLocal<DateFormatter> threadLocal = ThreadLocal.withInitial(
                () -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy"))
        );
        User u1 = new User(18, "java");
        User u2 = new User(23, "java");
        User u3 = new User(13, "java");

        IntSummaryStatistics statistics = Stream.of(u1, u2, u3, u2)
                .mapToInt(User::getAge).summaryStatistics();
        System.out.println(statistics);
//                .filter(str -> Character.isDigit(str.charAt(0)))
//                .max(Comparator.comparing(User::getAge)).get();
//        assertEquals(asList("1asd"),collect);


        Integer reduce = Stream.of(1, 2, 3, 4)
                .reduce(1, (a, b) -> a * b);
        // reduce 接受的是 运算符, 返回当前值
        System.out.println(reduce);


    }

    @Test
    public void t3() {
        Optional emp = Optional.empty();
        Optional alsoemp = Optional.ofNullable(5);

        System.out.println("emp.isPresent() = " + emp.isPresent());
        System.out.println("alsoemp.isPresent() = " + alsoemp.isPresent());


        assertEquals("ads", emp.orElse("ads"));
    }

    @Test
    public void simpleMovingAverage() {
        double[] values = {0, 1, 2, 3, 4, 3.5};
        double[] sums = copyOf(values, values.length);
        int n = 3;

        // sums = [0.0, 1.0, 3.0, 6.0, 10.0, 13.5]
        Arrays.parallelPrefix(sums, Double::sum);
//        System.out.println(Arrays.toString(sums));
        int start = n - 1;
        double[] array = IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n;
                })
                .toArray();
        // array = [1.0, 2.0, 3.0, 3.5]
        System.out.println("array = " + Arrays.toString(array));

    }


}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class User {
    private int age;
    private String name;
}
