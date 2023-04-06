package template;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class StoreOrderTest {

    @Spy
    StoreOrder storeOrder = new StoreOrder();

    @Test
    void processOrderWhenIsGift() {
        StoreOrder storeOrder1 = Mockito.spy(storeOrder);
        boolean isGift = true;
        storeOrder1.processOrder(isGift);
        verify(storeOrder1, times(1)).selectGoods();
        verify(storeOrder1, times(1)).payment();
        verify(storeOrder1, times(1)).giftWrap();
        verify(storeOrder1, times(1)).delivery();
    }

    @Test
    void processOrderWhenNotGift() {
        StoreOrder storeOrder1 = Mockito.spy(storeOrder);
        boolean isGift = false;
        storeOrder1.processOrder(isGift);
        verify(storeOrder1, times(1)).selectGoods();
        verify(storeOrder1, times(1)).payment();
        verify(storeOrder1, never()).giftWrap();
        verify(storeOrder1, times(1)).delivery();
    }

    @Test
    void isGiftTrue() {
        storeOrder.setGift(true);
        assertTrue(storeOrder.isGift());
    }

    @Test
    void isGiftFalse() {
        storeOrder.setGift(false);
        assertFalse(storeOrder.isGift());
    }

}