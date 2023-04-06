package decorator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ShapeFillColorDecoratorTest {

    ShapeFillColorDecorator decoratedRectangle = Mockito.spy(new ShapeFillColorDecorator(new Rectangle(), Color.GREEN));

    @Test
    void drawDecorateCircleWithBorder() {
        decoratedRectangle.draw();
        verify(decoratedRectangle, times(1)).setBorderColor();
    }

}