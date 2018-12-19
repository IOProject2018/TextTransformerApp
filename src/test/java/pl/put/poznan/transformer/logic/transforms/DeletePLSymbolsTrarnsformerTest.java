package pl.put.poznan.transformer.logic.transforms;


import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DeletePLSymbolsTrarnsformerTest
{
    private TextTransformerInterface transformer;

    @Before
    public void setupTransformer()
    {
        transformer = new DeletePLSymbolsTrarnsformer(new TextTransformerImpl());
    }

    @Test
    public void noPLnormalTest()
    {
        String text = "zażółć gęślą jaźń";
        String result = "zazulc gesla jazn";

        assertEquals(transformer.transform(text), (result));
    }

    @Test
    public void noPLCapitalizeTest()
    {
        String text = "Zażółć Gęślą jaźń Ćmy";
        String result = "Zazulc Gesla jazn Cmy";

        assertEquals(transformer.transform(text), (result));
    }

    @Test
    public void noPLUpperTest()
    {
        String text = "ZAŻÓŁĆ GĘŚLĄ JAŹŃ";
        String result = "ZAZOLC GESLA JAZN";

        assertEquals(transformer.transform(text), (result));
    }


}
