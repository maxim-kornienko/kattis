import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ToiletTest {

    private String input;

    private String[] output;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"UUUDDUDU", new String[]{"6", "7", "4"}},
                {"DDDD", new String[]{"5", "0", "0"}},
                {"DUUDDUDU", new String[]{"7", "8", "5"}}
        });
    }

    public ToiletTest(String input, String[] output) {
        this.input = input;
        this.output = output;
    }

    @Test
    public void test() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Toilet.main(in, new PrintStream(out));

        String[] result = new String(out.toByteArray()).split(System.lineSeparator());
        assertEquals(Arrays.toString(output), Arrays.toString(result));
    }
}
