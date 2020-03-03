package components;

import java.util.Collection;
import java.util.LinkedList;

public abstract class Component {
    private final String name;
    private final Component source;
    private int draw;
    private Collection<Component> loads;

    protected Component(String name, Component source) {
        this.name = name;
        this.source = source;
        this.draw = 0;
        this.loads = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    protected Component getSource() {
        return this.source;
    }

    protected void attach​(Component load) {
        loads.add(load);
    }

    protected void changeDraw​(int delta) {
        this.draw += delta;
    }

    public void engage() {

    }

    public void disengage() {

    }

    protected boolean engaged() {
        return false;
    }

    protected void setDraw(int draw) {
        this.draw = draw;
    }

    protected int getDraw() {
        return draw;
    }


    protected Collection<Component> getLoads() {
        return loads;
    }

    protected void addLoad​(Component newLoad) {

    }

    protected void engageLoads() {

    }

    protected void disengageLoads() {

    }

    protected void hasSwitch() {

    }

    public void display() {

    }

    public String toString() {

    }

}
