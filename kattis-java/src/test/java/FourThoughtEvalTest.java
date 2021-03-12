import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourThoughtEvalTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2 + 3", 5),
                Arguments.of("3 - 2", 1),
                Arguments.of("2 + 3 * 7", 23),
                Arguments.of("5 * 3 - 4 / 2", 13)
        );
    }

    @MethodSource("parameters")
    @ParameterizedTest
    void test(String expression, int value) {
        assertEquals(value, FourThought.eval(FourThought.toPostfix(expression.split(" "))));
    }
}
