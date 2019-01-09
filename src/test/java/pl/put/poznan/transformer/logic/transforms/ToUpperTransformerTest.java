package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ToUpperTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new ToUpperTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnUpperText() {
        String text = "tekst malymi literami";
        String result = "TEKST MALYMI LITERAMI";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    /**
     * mockito tests
     */

    @Test
    public void testTransformUpperText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("male litery")).thenReturn("MALE LITERY");

        ToUpperTransformer text = new ToUpperTransformer(textTransformerInterface);
        String result = text.transform("male litery");

        verify(textTransformerInterface).transform("male litery");
        assertEquals("MALE LITERY", result);
    }
}
