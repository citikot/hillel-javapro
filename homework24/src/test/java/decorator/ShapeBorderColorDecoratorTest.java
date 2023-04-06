package decorator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ShapeBorderColorDecoratorTest {

    ShapeBorderColorDecorator decoratedCircle = Mockito.spy(new ShapeBorderColorDecorator(new Circle(), Color.RED));

    @Test
    void drawDecorateCircleWithBorder() {
        decoratedCircle.draw();
        verify(decoratedCircle, times(1)).setBorderColor();
    }

}