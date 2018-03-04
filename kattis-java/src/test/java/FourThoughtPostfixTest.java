import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FourThoughtPostfixTest {

    private String infix;
    private String postfix;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"2 + 3", "2 3 +"},
                {"3 - 2", "3 2 -"},
                {"2 + 3 * 7", "2 3 7 * +"},
                {"5 * 3 - 4 / 2", "5 3 * 4 2 / -"},
                {"a + b * c - d", "a b c * + d -"}
        };
    }

    public FourThoughtPostfixTest(String input, String output) {
        this.infix = input;
        this.postfix = output;
    }


    @Test
    public void test() {
        String[] result = FourThought.toPostfix(infix.split(" "));
        assertEquals(postfix, FourThought.unsplit(result));
    }
}
