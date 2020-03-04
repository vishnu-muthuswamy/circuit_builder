package components;

public class CircuitBreaker extends Component{
    private final int limit;

    protected CircuitBreaker(String name, Component source, int limit) {
        super(name, source);
        this.limit = limit;
    }

    @Override
    public void engage() {
        super.engage();
        if(isSwitchOn()) {
            turnOn();
        }
    }

    @Override
    public void turnOn() {
        super.turnOn();
        if(engaged()) {
            engageLoads();
        }
    }

    @Override
    public void turnOff() {
        super.turnOff();
        if (engaged()) {
            getSource().changeDraw(-limit);
            disengageLoads();
        }
    }

    public int getLimit() {
        return this.limit;
    }

}
