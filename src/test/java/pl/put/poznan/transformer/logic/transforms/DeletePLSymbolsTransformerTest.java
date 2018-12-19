package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

public class DeletePLSymbolsTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new DeletePLSymbolsTrarnsformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnWithourPolsihCharacter() {
        String text = "tekst z pólskimi żnakami ą ę";
        String result = "tekst z polskimi znakami a e";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }
}
