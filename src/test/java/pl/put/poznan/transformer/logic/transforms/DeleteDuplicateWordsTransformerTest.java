package pl.put.poznan.transformer.logic.transforms;


import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

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
    public void noDuplicateTest()
    {
        String text = "Tu są są podwójne słowa słowa";
        String result = "Tu są podwójne słowa";

        assertEquals(transformer.transform(text), result);
    }

    @Test
    public void shouldReturnWithoutDuplicate() {
        String text = "raz raz dwa dwa";
        String result = "raz dwa";

        assertThat(transformer.transform(text)).isEqualTo(result);
    }
}
