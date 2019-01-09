package pl.put.poznan.transformer.logic.transforms;


import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;


public class DeleteDuplicateWordsTransformerTest
{
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer()
    {
        transformer = new DeleteDuplicateWordsTransformer(new TextTransformerImpl());
    }



    @Test
    public void shouldReturnWithoutDuplicate() {
        String text = "raz raz dwa dwa";
        String result = "raz dwa";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }

    /**
     * mockito tests
     */

    @Test
    public void testTransformNormalText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("bla bla")).thenReturn("bla");

        DeleteDuplicateWordsTransformer text = new DeleteDuplicateWordsTransformer(textTransformerInterface);
        String result = text.transform("bla bla");

        verify(textTransformerInterface).transform("bla bla");
        assertEquals("bla", result);
    }

    @Test
    public void testTransformUpperText() {
        TextTransformerInterface textTransformerInterface = mock(TextTransformerInterface.class);
        when(textTransformerInterface.transform("COS COS TAM")).thenReturn("COS TAM");

        DeleteDuplicateWordsTransformer text = new DeleteDuplicateWordsTransformer(textTransformerInterface);
        String result = text.transform("COS COS TAM");

        verify(textTransformerInterface).transform("COS COS TAM");
        assertEquals("COS TAM", result);
    }
}
