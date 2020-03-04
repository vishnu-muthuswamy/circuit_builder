package components;

/**
 * This class is a subclass of Component and represents the power sources.
 *
 * @author Vishnu Muthuswamy
 */
public class PowerSource extends Component{

    /**
     * Initialize a PowerSource.
     * @param name      the name of the power source
     */
    public PowerSource(String name) {
        super(name, null);
    }

    /**
     * Cause a power source to be engaged.
     */
    @Override
    public void engage() {
        super.engage();
        engageLoads();
    }

}
