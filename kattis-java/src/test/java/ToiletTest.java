import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToiletTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("UUUDDUDU", new String[]{"6", "7", "4"}),
                Arguments.of("DDDD", new String[]{"5", "0", "0"}),
                Arguments.of("DUUDDUDU", new String[]{"7", "8", "5"})
        );
    }

    @MethodSource("parameters")
    @ParameterizedTest
    void test(String input, String[] output) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Toilet.main(in, new PrintStream(out));

        String[] result = out.toString().split(System.lineSeparator());
        assertEquals(Arrays.toString(output), Arrays.toString(result));
    }
}
