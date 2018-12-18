package pl.put.poznan.transformer.logic.transforms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;


        import static org.junit.Assert.*;

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
        String text = "Tu są są podwójne słowa słowa.";
        String result = "Tu są podwójne słowa.";

        assertEquals(transformer.transform(text), (result));
    }


}