package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

public class LatexSymbolsTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new LatexSymbolsTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnLatexLike() {
        String text = "tekst ze znakiem $";
        String result = "tekst ze znakiem \\$";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }
}
