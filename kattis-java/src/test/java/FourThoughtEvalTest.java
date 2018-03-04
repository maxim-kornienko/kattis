import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FourThoughtEvalTest {

    private String expression;
    private int value;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"2 + 3", 5},
                {"3 - 2", 1},
                {"2 + 3 * 7", 23},
                {"5 * 3 - 4 / 2", 13}
        };
    }

    public FourThoughtEvalTest(String expression, int value) {
        this.expression = expression;
        this.value = value;
    }

    @Test
    public void test() {
        assertEquals(value, FourThought.eval(FourThought.toPostfix(expression.split(" "))));
    }
}
