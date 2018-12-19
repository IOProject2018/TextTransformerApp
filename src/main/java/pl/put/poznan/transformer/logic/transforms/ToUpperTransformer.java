package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

/**
  *  Class used to make 'upper' transformation
  */
public class ToUpperTransformer extends TextTransformerDecorator {

    public ToUpperTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    /**
     * @param textIn
     * @return sformatowany text - zamaiana tekstu na wielkie litery
     */
    public String transform(String textIn) {
        String text = super.transform(textIn);
        return text.toUpperCase();
    }
}
