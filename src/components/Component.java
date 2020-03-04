package components;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * This class is used to represent any component.
 *
 * @author Vishnu Muthuswamy
 */
public class Component {
    /** the name of the component */
    private final String name;
    /** the power source of the component */
    private final Component source;
    /** the current draw of the component */
    private int draw;
    /** indicates whether or not the component is transmitting power */
    private int power;
    /** indicates whether or not the component is switched on */
    private int switchState;
    /** indicates whether or not the component is blown */
    private int blown;
    /** the list of loads */
    private Collection<Component> loads;

    /**
     * Initialize a Component.
     * @param name      the name of the component
     * @param source    the power source of the component
     */
    protected Component(String name, Component source) {
        this.name = name;
        this.source = source;
        this.draw = 0;
        this.power = 0;
        this.switchState = 0;
        this.loads = new LinkedList<>();
        this.blown = 0;

        if (source != null) {
            this.source.attach(this);
        }
    }

    /**
     * Get the component's name.
     * @return  component's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the component's power source
     * @return  power source
     */
    protected Component getSource() {
        return this.source;
    }

    /**
     * Attach the component to its load and engage the load if the component is engaged.
     * @param   load    the component's load
     */
    protected void attach(Component load) {
        addLoad(load);
        if(load.engaged()) {
            load.engage();
        }
    }

    /**
     * Change the current drawn from a power source by a component and the currents drawn by its parent components.
     * @param   delta   the change in current
     */
    protected void changeDraw(int delta) {
        this.draw += delta;

        if(this.blown == 0) {
            if (this instanceof CircuitBreaker) {
                if (getDraw() > ((CircuitBreaker) this).getLimit()) {
                    this.blown = 1;
                    turnOff();
                }
            }
        }
        if(getSource() != null) {
            getSource().changeDraw(delta);
        }
    }

    /**
     * Change the state of the component to being engaged.
     */
    public void engage() {
        this.power = 1;
    }

    /**
     * Change the state of the component to being disengaged.
     */
    public void disengage() {
        this.power = 0;
    }

    /**
     * Indicate whether or not a parent component is being engaged.
     * @return  true if the parent component is being engaged and false otherwise
     */
    protected boolean engaged() {
        if (getSource().power == 1) {
            return true;
        }
        return false;
    }

    /**
     * Set the current draw to a particular amount.
     */
    protected void setDraw(int draw) {
        this.draw = draw;
    }

    /**
     * Get the current draw.
     * @return  current draw
     */
    protected int getDraw() {
        return this.draw;
    }

    /**
     * Get the list of loads of a component.
     * @return  the list of loads of a component
     */
    protected Collection<Component> getLoads() {
        return Collections.unmodifiableCollection(loads);
    }

    /**
     * Add a load to a component.
     */
    protected void addLoad(Component newLoad) {
        this.loads.add(newLoad);
    }

    /**
     * Cause the loads of a component to be engaged.
     */
    protected void engageLoads() {
        for(Component load: getLoads()) {
            load.engage();
        }
    }

    /**
     * Cause the loads of a component to be disengaged.
     */
    protected void disengageLoads() {
        for(Component load: getLoads()) {
            load.disengage();
        }
    }

    /**
     * Turn on a switchable component and indicate that it has not blown.
     */
    public void turnOn() {
        this.blown = 0;
        this.switchState = 1;
    }

    /**
     * Turn off a switchable component.
     */
    public void turnOff() {
        this.switchState = 0;
    }

    /**
     * Check whether a switchable component is turned on.
     * @return   true if it is and false otherwise
     */
    public boolean isSwitchOn() {
        if(this.switchState == 1) {
            return true;
        }
        return false;
    }

    /**
     * Display the circuit(s) as a tree(s).
     */
    public void display() {
        displayTree(0, this);
    }

    /**
     * Display the circuit(s) as a tree(s) using recursion.
     */
    private void displayTree(int indentation, Component component) {
        String treeString = "+ " + component.toString();

        indentation += 3;
        System.out.print(treeString.indent(indentation));

        for(Component load: component.getLoads()) {
            if(load == null) {
                break;
            }
            else {
                displayTree(indentation, load);
            }
        }
    }

    /**
     * Display information regarding a component.
     * @return  information regarding a component as a string
     */
    @Override
    public String toString() {
        return Reporter.identify(this);
    }

}
