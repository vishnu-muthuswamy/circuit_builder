package components;

/**
 * This class is a subclass of Component and represents the circuit breakers.
 *
 * @author Vishnu Muthuswamy
 */
public class CircuitBreaker extends Component{
    /** the limit of the circuit breaker */
    private final int limit;

    /**
     * Initialize a CircuitBreaker.
     * @param name      the name of the circuit breaker
     * @param source    the power source of the circuit breaker
     * @param limit    the limit of the circuit breaker
     */
    public CircuitBreaker(String name, Component source, int limit) {
        super(name, source);
        this.limit = limit;
    }

    /**
     * Get the limit of a circuit breaker.
     * @return  the limit of a circuit breaker
     */
    public int getLimit() {
        return this.limit;
    }

    /**
     * Cause a circuit breaker to be engaged.
     */
    @Override
    public void engage() {
        if(isSwitchOn()) {
            if(engaged()) {
                super.engage();
                engageLoads();
            }
        }
    }

    /**
     * Cause a circuit breaker to be disengaged.
     */
    @Override
    public void disengage() {
        super.disengage();
        disengageLoads();
    }

    /**
     * Turn on a circuit breaker.
     */
    @Override
    public void turnOn() {
        super.turnOn();
        engage();
        if(getDraw() > this.limit) {
            turnOff();
        }
    }

    /**
     * Turn off a circuit breaker.
     */
    @Override
    public void turnOff() {
        super.turnOff();
        if(engaged()) {
            disengage();
        }
    }

}
