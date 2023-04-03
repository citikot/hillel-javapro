package facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MeatRestaurantTest {

    @Mock
    MeatRestaurant mr;
    @Test
    public void getCorrectMeatMenusTest() {
        doReturn(List.of("Kotleta", "Svinina")).when(mr).getMenus();
        assertEquals(List.of("Kotleta", "Svinina"), mr.getMenus());
    }

    @Test
    public void getActualValuesInMeatMenusTest() {
        List<String> expectedValue = List.of("Meat");
        MeatRestaurant mr = new MeatRestaurant();
        assertEquals(expectedValue, mr.getMenus());
    }
}