package pl.put.poznan.transformer.logic.transforms;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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


    /**
     * mockito tests
     */

    @Test
    public void testTransformNormalText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("są się łoś iść żółw")).thenReturn("sa sie los isc zolw");

        DeletePLSymbolsTrarnsformer text = new DeletePLSymbolsTrarnsformer(textTransformerInterface);
        String result = text.transform("są się łoś iść żółw");

        verify(textTransformerInterface).transform("są się łoś iść żółw");
        assertEquals("sa sie los isc zolw", result);
    }

    @Test
    public void testTransformUpperText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("ŚNI GĘŚ")).thenReturn("SNI GES");

        DeletePLSymbolsTrarnsformer text = new DeletePLSymbolsTrarnsformer(textTransformerInterface);
        String result = text.transform("ŚNI GĘŚ");

        verify(textTransformerInterface).transform("ŚNI GĘŚ");
        assertEquals("SNI GES", result);
    }

    @Test
    public void testTransformCapitalizeText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("Koń Ćmy Ósmy")).thenReturn("Kon Cmy Osmy");

        DeletePLSymbolsTrarnsformer text = new DeletePLSymbolsTrarnsformer(textTransformerInterface);
        String result = text.transform("Koń Ćmy Ósmy");

        verify(textTransformerInterface).transform("Koń Ćmy Ósmy");
        assertEquals("Kon Cmy Osmy", result);
    }
}
