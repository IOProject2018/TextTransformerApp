package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;

public class ToShortcutTransformerTest {
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer() {
        transformer = new ToShortcutTransformer(new TextTransformerImpl());
    }

    @Test
    public void shouldReturnLongForm() {
        String text = "I np. coś tam, coś tam.";
        String result = "I na przykład coś tam, coś tam.";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnLongFormAndUppercase() {
        String text = "PROF. MORZY";
        String result = "PROFESOR MORZY";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnLongFormAndCapitalize() {
        String text = "Itp. Itd.";
        String result = "I tym podobne I tak dalej";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    @Test
    public void shouldReturnWithoutShortcut() {
        String text = "Drzwi";
        String result = "Drzwi";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

}
