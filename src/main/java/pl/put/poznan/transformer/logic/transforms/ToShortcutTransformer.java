package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * The class used to converting shortcuts to full words
 */

public class ToShortcutTransformer extends TextTransformerDecorator {

    public ToShortcutTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    /**
     * The function that makes text transformation
     * @param textIn text with shortcuts before transformation
     * @return text without shortcuts
     */
    public String transform(String textIn) {
        String text = super.transform(textIn);
        text = text.replaceAll("np.", "na przykład");
        text = text.replaceAll("Np.", "Na przykład");
        text = text.replaceAll("NP.", "NA PRZYKŁAD");
        text = text.replaceAll("m.in.", "między innymi");
        text = text.replaceAll("M.in.", "Między innymi");
        text = text.replaceAll("M.IN.", "MIĘDZY INNYMI");
        text = text.replaceAll("itp.", "i tym podobne");
        text = text.replaceAll("Itp.", "I tym podobne");
        text = text.replaceAll("ITP.", "I TYM PODOBNE");
        text = text.replaceAll("itd.", "i tak dalej");
        text = text.replaceAll("Itd.", "I tak dalej");
        text = text.replaceAll("ITD.", "I TAK DALEJ");
        text = text.replaceAll("prof.", "profesor");
        text = text.replaceAll("Prof.", "Profesor");
        text = text.replaceAll("PROF.", "PROFESOR");
        text = text.replaceAll(" dr ", " doktor ");
        text = text.replaceAll(" Dr ", " Doktor ");
        text = text.replaceAll(" DR ", " DOKTOR ");
        return text;
    }


}
