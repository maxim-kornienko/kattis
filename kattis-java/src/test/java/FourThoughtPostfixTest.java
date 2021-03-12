import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourThoughtPostfixTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2 + 3", "2 3 +"),
                Arguments.of("3 - 2", "3 2 -"),
                Arguments.of("2 + 3 * 7", "2 3 7 * +"),
                Arguments.of("5 * 3 - 4 / 2", "5 3 * 4 2 / -"),
                Arguments.of("a + b * c - d", "a b c * + d -")
        );
    }

    @MethodSource("parameters")
    @ParameterizedTest
    void test(String infix, String postfix) {
        String[] result = FourThought.toPostfix(infix.split(" "));
        assertEquals(postfix, FourThought.unsplit(result));
    }
}
