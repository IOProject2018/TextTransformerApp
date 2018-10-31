package pl.put.poznan.transformer.logic;

/**
  *  Class used to make 'upper' transformation
  */
public class ToUpperTransformer implements TextTransformerInterface {
    public String transform(String text) {
        return text.toUpperCase();
    }
}
