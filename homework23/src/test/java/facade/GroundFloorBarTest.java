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
    FishRestaurant fr;

    @Spy
    GroundFloorBar barSpy = new GroundFloorBar();

    @Test
    public void getCorrectGroundFloorBarMenusTest() {
        when(fr.getMenus()).thenReturn(List.of("Losos", "Forel"));
        assertEquals(List.of("Losos", "Forel"), fr.getMenus());
    }

    @Test
    public void getActualValuesInFishMenusTest() {
        Map<String, Integer> expectedValue = Map.of("Proseco", 1965);
        assertEquals(expectedValue, barSpy.getVineCard());
    }
}