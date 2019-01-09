package pl.put.poznan.transformer.logic.transforms;


import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class FromShortcutTransformerTest
{
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer()
    {
        transformer = new FromShortcutTransformer(new TextTransformerImpl());
    }

    @Test
    public void shortednormalTest()
    {
        String text = "I uzyskał wtedy między innymi tytuł doktora.";
        String result = "I uzyskał wtedy m.in. tytuł dra.";

        assertEquals(transformer.transform(text), (result));
    }

    @Test
    public void shortedUpperTest()
    {
        String text = "CO NA PRZYKŁAD!?";
        String result = "CO NP.!?";

        assertEquals(transformer.transform(text), (result));
     }

    @Test
    public void shortedCapitalTest()
    {
        String text = "Profesor Węglarz przeszedł na emeryturę.";
        String result = "Prof. Węglarz przeszedł na emeryturę.";

        assertEquals(transformer.transform(text), (result));
    }

    @Test
    public void shouldReturnShortForm() {
        String text = "I na przykład coś tam, coś tam.";
        String result = "I np. coś tam, coś tam.";
        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnShortFormAndUppercase() {
        String text = "PROFESOR MORZY";
        String result = "PROF. MORZY";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnShortFormAndCapitalize() {
        String text = "I tym podobne I tak dalej";
        String result = "Itp. Itd.";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnWithoutChanges() {
        String text = "Drzwi";
        String result = "Drzwi";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    /**
     * mockito tests
     */

    @Test
    public void testTransformShortFormAndCapitalize() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("I tym podobne I tak dalej")).thenReturn("Itp. Itd.");

        FromShortcutTransformer text = new FromShortcutTransformer(textTransformerInterface);
        String result = text.transform("I tym podobne I tak dalej");

        verify(textTransformerInterface).transform("I tym podobne I tak dalej");
        assertEquals("Itp. Itd.", result);
    }

    @Test
    public void testTransformWithoutChanges() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("Drzwi")).thenReturn("Drzwi");

        FromShortcutTransformer text = new FromShortcutTransformer(textTransformerInterface);
        String result = text.transform("Drzwi");

        verify(textTransformerInterface).transform("Drzwi");
        assertEquals("Drzwi", result);
    }

    @Test
    public void testTransformShortFormAndUppercase() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("PROFESOR MORZY")).thenReturn("PROF. MORZY");

        FromShortcutTransformer text = new FromShortcutTransformer(textTransformerInterface);
        String result = text.transform("PROFESOR MORZY");

        verify(textTransformerInterface).transform("PROFESOR MORZY");
        assertEquals("PROF. MORZY", result);
    }

}
