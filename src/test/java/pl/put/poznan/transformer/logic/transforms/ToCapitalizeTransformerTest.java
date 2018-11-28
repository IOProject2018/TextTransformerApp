package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

public class ToCapitalizeTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new ToCapitalizeTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnCapitalizeText() {
        String text = "pierwsze litery male";
        String result = "Pierwsze Litery Male";

        Assert.assertEquals(result, transformer.transform(text));
    }
}
