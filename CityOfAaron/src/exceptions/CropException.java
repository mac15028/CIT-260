package exceptions;

public class CropException extends Exception {
    /**
     * Default constructor
     * Purpose: Initializes data members to default values
     */
    public CropException() {}
    
    /**
     * Parameterized constructor
     * Purpose: Initializes data members to value passed as a parameter
     * @param string
     */
    public CropException(String string) {
        super(string);
    }
}
