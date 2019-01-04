package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class NumToStringTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new NumToStringTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldNotChangeAnything() {
        String text = "IOProject2018 bez oddzielnych liczb!...";

        assertThat(transformer.transform(text)).isEqualTo(text);
    }

    @Test
    public void shouldReturnVerbalRepresentation() {
        String text = "kosztuje 999999 złotych";
        String result = "kosztuje dziewięćset dziewięćdziesiąt dziewięć tysięcy dziewięćset dziewięćdziesiąt dziewięć złotych";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnLimitExceeded() {
        String text = "kosztuje 1000000 złotych";

        assertThat(transformer.transform(text)).isEqualTo(text);
    }

    @Test
    public void shouldReturnVerbalRest() {
        String text = "reszta 0.999";
        String result = "reszta dziewięćset dziewięćdziesiąt dziewięć tysięcznych";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldParseComposedNumber() {
        String text = "781.135";
        String result = "siedemset osiemdziesiąt jeden i sto trzydzieści pięć tysięcznych";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnRestLimitExceeded() {
        String text = "0.1279999";
        String result = "sto dwadzieścia siedem tysięcznych";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    /**
     * mockito tests
     */

    @Test
    public void testTransformParseComposedNumber() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("781.135")).thenReturn("siedemset osiemdziesiąt jeden i sto trzydzieści pięć tysięcznych");

        NumToStringTransformer text = new NumToStringTransformer(textTransformerInterface);
        String result = text.transform("781.135");

        verify(textTransformerInterface).transform("781.135");
        assertEquals("siedemset osiemdziesiąt jeden i sto trzydzieści pięć tysięcznych", result);
    }

    @Test
    public void testTransformRestLimitExceeded() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("0.135111")).thenReturn("sto trzydzieści pięć tysięcznych");

        NumToStringTransformer text = new NumToStringTransformer(textTransformerInterface);
        String result = text.transform("0.135111");

        verify(textTransformerInterface).transform("0.135111");
        assertEquals("sto trzydzieści pięć tysięcznych", result);
    }

    @Test
    public void testTransformLimitExceeded() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("mam 12345678 zl.")).thenReturn("mam 12345678 zl.");

        NumToStringTransformer text = new NumToStringTransformer(textTransformerInterface);
        String result = text.transform("mam 12345678 zl.");

        verify(textTransformerInterface).transform("mam 12345678 zl.");
        assertEquals("mam 12345678 zl.", result);
    }

    @Test
    public void testTransformNumToString() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("123.0")).thenReturn("sto dwadzieścia trzy i zero");

        NumToStringTransformer text = new NumToStringTransformer(textTransformerInterface);
        String result = text.transform("123.0");

        verify(textTransformerInterface).transform("123.0");
        assertEquals("sto dwadzieścia trzy i zero", result);
    }
}
