package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

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
}
