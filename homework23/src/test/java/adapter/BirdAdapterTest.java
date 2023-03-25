package adapter;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BirdAdapterTest {

    Bird bird = mock(Sparrow.class);
    BirdAdapter birdAdapter = new BirdAdapter(bird);

    @Test
    public void squeak_OK(){
        birdAdapter.squeak();
        verify(bird, times(1)).makeSound();
    }
}
