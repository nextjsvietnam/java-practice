package net.re;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        boolean value = true;
        assertEquals(value, true);
    }

    @Test
    public void testMainOutputsHelloWorld() {
        // The output has been write to screen(console)
        // So to be able to test it, you must redirect the output to a temperate memory

        // Create a ByteArrayOutputStream instance
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Create a PrintStream that writes to our ByteArrayOutputStream
        PrintStream ps = new PrintStream(baos);

        // Redirect System.out to our PrintStream
        System.setOut(ps);

        App.main(null);

        assertEquals(App.content() + "\n", baos.toString());
    }
}

/*
 * public class HelloWorldTest {
 * 
 * @Test
 * public void testMainOutputsHelloWorld() {
 * ByteArrayOutputStream outContent = new ByteArrayOutputStream();
 * System.setOut(new PrintStream(outContent));
 * 
 * HelloWorld.main(new String[]{}); // Call main to print to console
 * 
 * assertEquals("Hello, World!\n", outContent.toString(),
 * "Expected Hello, World! to be printed");
 * System.setOut(System.out); // Reset the System.out to its original stream
 * }
 * }
 */