package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

/**
 * Class used to make 'lower' transformation
 */

public class ToLowerTransformer extends TextTransformerDecorator {

    public ToLowerTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    /**
     * @param textIn
     * @return sformatowany text - zamiana na małe litery
     */
    public String transform(String textIn) {
        String text = super.transform(textIn);
        return text.toLowerCase();
    }
}