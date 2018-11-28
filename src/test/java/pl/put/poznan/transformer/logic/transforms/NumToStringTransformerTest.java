package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

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
}
