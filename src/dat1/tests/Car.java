package dat1.tests;

/**
 * @author K. Atas 
 */
public class Car {
    private final String make;
    private final String model;
    
    /**
     * Constructs a new <tt>Car</tt> given its make and model.
     * 
     * @param make the make of this <tt>Car</tt>.
     * @param model the model of this <tt>Car</tt>.
     */
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    /**
     * Gets the make, or brand name, of this <tt>Car</tt>.
     * 
     * @return the make of this <tt>Car</tt>.
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the model of this <tt>Car</tt>.
     * 
     * @return the model of this <tt>Car</tt>.
     */
    public String getModel() {
        return model;
    }
    
    /**
     * Returns a string representation of this <tt>Car</tt>.
     */
    public String toString() {
        return String.format("%s %s", make, model);
    }
}