package components;

import java.util.Collection;
import java.util.LinkedList;

public abstract class Component {
    private final String name;
    private final Component source;
    private int draw;
    private int power;
    private int switchState;
    private Collection<Component> loads;

    protected Component(String name, Component source) {
        this.name = name;
        this.source = source;
        this.draw = 0;
        this.power = 0;
        this.switchState = 0;
        this.loads = new LinkedList<>();

        if (source != null) {
            this.source.attach(this);
        }
    }

    public String getName() {
        return this.name;
    }

    protected Component getSource() {
        return this.source;
    }

    protected void attach(Component load) {
        addLoad(load);
        if(engaged()) {
            load.engage();
        }
    }

    protected void changeDraw(int delta) {
        this.draw += delta;
    }

    public void engage() {
        this.power = 1;
    }

    public void disengage() {
        this.power = 0;
    }

    protected boolean engaged() {
        if (power == 1) {
            return true;
        }
        return false;
    }

    protected void setDraw(int draw) {
        this.draw = draw;
    }

    protected int getDraw() {
        return this.draw;
    }

    protected Collection<Component> getLoads() {
        return this.loads;
    }

    protected void addLoad(Component newLoad) {
        this.loads.add(newLoad);
    }

    protected void engageLoads() {
        for(Component load: getLoads()) {
            load.engage();
        }
    }

    protected void disengageLoads() {
        for(Component load: getLoads()) {
            load.disengage();
        }
    }

    public void turnOn() {
        this.switchState = 1;
    }

    public void turnOff() {
        this.switchState = 1;
    }

    public boolean isSwitchOn() {
        if(this.switchState == 1) {
            return true;
        }
        return false;
    }

    public void display() {

    }

    public String toString() {

    }

}
