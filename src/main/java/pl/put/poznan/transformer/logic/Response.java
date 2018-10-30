package pl.put.poznan.transformer.logic;

public class Response {
    private String transformed;


    public void setTransformed(String transformed) {
        this.transformed = transformed;
    }

    public String getTransformed() {
        return transformed;
    }

    public Response(String transformed) {
        this.transformed = transformed;
    }
}
