package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

public class InverseTextTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new InverseTextTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnReversedText() {
        String text = "IOProject2018";
        String result = "8102tcejorPOI";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }
}
