package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

/**
 *  Class used to make 'inverse' transformation
 *  Inverse whole text with the same size of characters
 */
public class InverseTextTransformer extends TextTransformerDecorator {

    public InverseTextTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    /**
     * @param textIn
     * @return sformatowany text - obrócenie ciągu znaków
     */
    public String transform(String textIn) {
        String text = super.transform(textIn);
        StringBuilder result = new StringBuilder();
        result.append(text);
        result = result.reverse();
        return result.toString();
    }
}
