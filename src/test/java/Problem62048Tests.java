import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Problem62048Tests {
    public long solution(int w, int h) {
        if (w == h) {
            return w*h - w;
        }
        float ratio = (float)h/w;
        long sum = 0;

        int gcd = getGcd(w, h);
        int unitH = h / gcd;
        int unitW = w / gcd;
        int max = Math.max(unitH, unitW);
        int q = h / unitH;
        int r = h % unitH;

        int trash = q * (max + 1) + r;
        if (r / 2 >= unitH) {
            trash++;
        }
        System.out.println(String.format("unitH %d, unitW %d q %d r %d", unitH, unitW, q, r));
        return w*h-trash;


//        for (int x = 0; x < w; x++) {
//            for (int y = 0; y < h; y++) {
//                // (x,y) ~ (x+1, y)
//                if ((float)y/(x+1) < ratio && (float)y/x > ratio) {
//                    sum++;
//                    continue;
//                }
//                // (x,y+1) ~ (x+1, y+1)
//                if ((float)(y+1)/(x+1) < ratio && (float)(y+1)/x > ratio) {
//                    sum++;
//                    continue;
//                }
//            }
//        }
//
//        return w*h - sum;
    }

    static int getLcm(int a, int b) {
        return a*b/getGcd(a,b);
    }

    static int getGcd(int a, int b) {
        while(b!=0) {
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }

    // argument source method
    private static Stream<Arguments> provideSources() {
        return Stream.of(
                Arguments.of(
                        // numbers
                        8, 12,
                        // expected
                        80),
                Arguments.of(
                        // numbers
                        3, 6,
                        // expected
                        12),
                Arguments.of(
                        // numbers
                        2, 3,
                        // expected
                        2),
                Arguments.of(
                        // numbers
                        1, 2,
                        // expected
                        0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSources")
    void testSolution(int w, int h, long expected) {
        long result = solution(w, h);

        Assertions.assertEquals(expected, result);

    }
}
