package components;

/**
 * This class is a subclass of Component and represents the appliances.
 *
 * @author Vishnu Muthuswamy
 */
public class Appliance extends Component {
    /** the rating of the circuit breaker */
    private final int rating;

    /**
     * Initialize an Appliance.
     * @param name      the name of the appliance
     * @param source    the power source of the appliance
     * @param rating    the rating of the appliance
     */
    public Appliance(String name, Component source, int rating) {
        super(name, source);
        this.rating = rating;
    }

    /**
     * Get the rating of an appliance.
     * @return  the rating of an appliance
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Engage another component with an appliance.
     */
    @Override
    public void engage() {
        if(isSwitchOn()) {
            changeDraw(getRating());
        }
    }

    /**
     * Disengage another component with an appliance.
     */
    @Override
    public void disengage() {
        if(isSwitchOn()) {
            changeDraw(-getRating());
        }
    }

    /**
     * Turn on an appliance.
     */
    @Override
    public void turnOn() {
        super.turnOn();
        if(engaged()) {
            changeDraw(getRating());
        }
    }

    /**
     * Turn off an appliance.
     */
    @Override
    public void turnOff() {
        super.turnOff();
        if(engaged()) {
            changeDraw(-getRating());
        }
    }

}
