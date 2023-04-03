package facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GroundFloorBarTest {

    @Mock
    GroundFloorBar bar;

    @Spy
    GroundFloorBar barSpy = new GroundFloorBar();

    @Test
    public void getCorrectGroundFloorBarMenusTest() {
        when(bar.getVineCard()).thenReturn(Map.of("Bordo", 1980));
        assertEquals(Map.of("Bordo", 1980), bar.getVineCard());
    }

    @Test
    public void getActualValuesInVineCardTest() {
        Map<String, Integer> expectedValue = Map.of("Proseco", 1965);
        assertEquals(expectedValue, barSpy.getVineCard());
    }
}