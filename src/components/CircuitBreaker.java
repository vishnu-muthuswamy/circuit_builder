package components;

public class CircuitBreaker extends Component{
    private final int limit;

    public CircuitBreaker(String name, Component source, int limit) {
        super(name, source);
        this.limit = limit;
    }

    public int getLimit() {
        return this.limit;
    }

    @Override
    public void engage() {
        if(isSwitchOn()) {
            if(engaged()) {
                super.engage();
                engageLoads();
            }
        }
    }

    @Override
    public void disengage() {
        super.disengage();
        disengageLoads();
    }

    @Override
    public void turnOn() {
        super.turnOn();
        engage();
        if(getDraw() > this.limit) {
            turnOff();
        }
    }

    @Override
    public void turnOff() {
        super.turnOff();
        if(engaged()) {
            disengage();
        }
    }

}
