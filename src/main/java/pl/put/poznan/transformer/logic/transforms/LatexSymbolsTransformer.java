package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

/**
 *  Class used to make 'latex like' transformation
 */
public class LatexSymbolsTransformer extends TextTransformerDecorator {

    public LatexSymbolsTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    public String transform(String textIn) {
        String text = super.transform(textIn);
        text = text.replace("&", "\\&");
        text = text.replace("$", "\\$");
        return text;
    }
}
