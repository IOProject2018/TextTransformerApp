package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

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
}
