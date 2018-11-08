package pl.put.poznan.transformer.model;

/**
 * Class used to be serialized to JSON as a response to the user's query
 */
public class Response {
    /**
     * Stores transformation returned to user
     */
    private String transformed;


    public void setTransformed(String transformed) {
        this.transformed = transformed;
    }

    public String getTransformed() {
        return transformed;
    }

    /**
     * Class constructor
     * @param transformed is a return value to be returned to user
     */
    public Response(String transformed) {
        this.transformed = transformed;
    }
}
