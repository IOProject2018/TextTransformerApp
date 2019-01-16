package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ToCapitalizeTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new ToCapitalizeTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnCapitalizeText() {
        String text = "pierwsze litery male";
        String result = "Pierwsze Litery Male";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    /**
     * mockito tests
     */

    @Test
    public void testTransformUpperText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("male litery")).thenReturn("Male Litery");

        ToCapitalizeTransformer text = new ToCapitalizeTransformer(textTransformerInterface);
        String result = text.transform("male litery");

        verify(textTransformerInterface).transform("male litery");
        assertEquals("Male Litery", result);
    }
}
