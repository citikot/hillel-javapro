package adapter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SparrowTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void flyCorrectMessageTest() {
        Bird sparrow = new Sparrow();
        sparrow.fly();
        assertEquals("Flying", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void makeCorrectSoundTest() {
        Bird sparrow = new Sparrow();
        sparrow.makeSound();
        assertEquals("Chirp Chirp", outputStreamCaptor.toString()
                .trim());
    }
}