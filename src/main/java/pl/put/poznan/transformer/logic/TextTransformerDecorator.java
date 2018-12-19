package pl.put.poznan.transformer.logic;

public abstract class TextTransformerDecorator implements TextTransformerInterface {
    private TextTransformerInterface textTransformer;

    public TextTransformerDecorator(TextTransformerInterface textTransformer) {
        this.textTransformer = textTransformer;
    }

    @Override
    public String transform(String text) {
        return textTransformer.transform(text);
    }
}
