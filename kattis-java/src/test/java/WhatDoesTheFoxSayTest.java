import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhatDoesTheFoxSayTest {

    private static final String INPUT =
            "1\n" +
            "toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot\n" +
            "dog goes woof\n" +
            "fish goes blub\n" +
            "elephant goes toot\n" +
            "seal goes ow\n" +
            "what does the fox say?";

    private static final String OUTPUT =
            "wa pa pa pa pa pa pow";

    @Test
    public void test() throws IOException {
        ByteArrayInputStream input = new ByteArrayInputStream(INPUT.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        WhatDoesTheFoxSay.main(input, new PrintStream(output));
        assertEquals(OUTPUT, output.toString().trim());
    }
}
