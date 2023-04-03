package facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FishRestaurantTest {

    @Mock
    FishRestaurant fr;
    @Test
    public void getCorrectFishMenusTest() {
        when(fr.getMenus()).thenReturn(List.of("Losos", "Forel"));
        assertEquals(List.of("Losos", "Forel"), fr.getMenus());
    }

    @Test
    public void getActualValuesInFishMenusTest() {
        List<String> expectedValue = List.of("Kil'ka");
        FishRestaurant fr = new FishRestaurant();
        FishRestaurant frSpy = Mockito.spy(fr);
        assertEquals(expectedValue, frSpy.getMenus());
    }
}