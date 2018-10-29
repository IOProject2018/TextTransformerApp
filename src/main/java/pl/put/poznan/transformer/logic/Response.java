package pl.put.poznan.transformer.logic;

public class Response {
    private String original;
    private String transformed;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public void setTransformed(String transformed) {
        this.transformed = transformed;
    }

    public String getTransformed() {
        return transformed;
    }

    public Response(String original, String transformed) {
        this.original = original;
        this.transformed = transformed;
    }
}
