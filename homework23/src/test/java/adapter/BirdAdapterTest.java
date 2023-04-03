package adapter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BirdAdapterTest {

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
    public void squeakExpectedMessageTest() {
        Bird sparrow = new Sparrow();
        BirdAdapter birdAdapter = new BirdAdapter(sparrow);
        birdAdapter.squeak();
        assertEquals("Chirp Chirp", outputStreamCaptor.toString()
                .trim());
    }
}