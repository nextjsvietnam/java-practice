package net.re;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpInput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void shouldAnswerWithTrue() {
        boolean value = true;
        assertEquals(value, true);
    }

    @Test
    public void testHelloWorld() {

        App.helloWorld();
        assertEquals(App.content() + "\n", testOut.toString());

    }

    @Test
    public void testScanInputs() {
        String simulatedUserInput = "10 20 30\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(testIn);

        int[] expected = { 10, 20, 30 };
        int[] actual = App.scanInputs();
        assertArrayEquals(expected, actual, "The scanned inputs should match the expected values.");
    }

    @Test
    public void testReadStandardInput() {
        // mock
        String simulatedUserInput = "1 2 3\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(testIn);

        App.readStandardInput();
        String expectedOutput = App.readStandardInputCommand() + "1\n2\n3\n";
        assertEquals(expectedOutput, testOut.toString());
    }
}
