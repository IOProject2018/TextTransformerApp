package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteDuplicateWordsTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new DeleteDuplicateWordsTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnWithourPolsihCharacter() {
        String text = "raz raz dwa dwa";
        String result = "raz dwa";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }
}
