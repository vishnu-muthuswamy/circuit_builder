package components;

/**
 * This class is a subclass of Component and represents the outlets.
 *
 * @author Vishnu Muthuswamy
 */
public class Outlet extends Component{

    /**
     * Initialize an Outlet.
     * @param name      the name of the outlet
     * @param source    the power source of the outlet
     */
    public Outlet(String name, Component source) {
        super(name, source);
    }

    /**
     * Cause an outlet to be engaged.
     */
    @Override
    public void engage() {
        super.engage();
        engageLoads();
    }

    /**
     * Cause an outlet to be disengaged.
     */
    @Override
    public void disengage() {
        super.disengage();
        disengageLoads();
    }

}
