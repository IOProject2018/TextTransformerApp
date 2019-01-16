package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ToLowerTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new ToLowerTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnLowerText() {
        String text = "TEKST DUZYMI LITERAMI";
        String result = "tekst duzymi literami";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    /**
     * mockito tests
     */

    @Test
    public void testTransformUpperText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("BIG SMALL")).thenReturn("big small");

        ToLowerTransformer text = new ToLowerTransformer(textTransformerInterface);
        String result = text.transform("BIG SMALL");

        verify(textTransformerInterface).transform("BIG SMALL");
        assertEquals("big small", result);
    }
}
