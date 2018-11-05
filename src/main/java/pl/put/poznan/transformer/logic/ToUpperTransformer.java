package pl.put.poznan.transformer.logic;

/**
  *  Class used to make 'upper' transformation
  */
public class ToUpperTransformer implements TextTransformerInterface {
    /**
     * @param text
     * @return sformatowany text - zamaiana tekstu na wielkie litery
     */
    public String transform(String text) {
        return text.toUpperCase();
    }
}
