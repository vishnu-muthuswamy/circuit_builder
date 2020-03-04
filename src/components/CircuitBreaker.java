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
            for (Component load : super.getLoads()) {
                load.engage();
            }
        }
    }

    @Override
    public void turnOff() {
        super.turnOff();

        if (engaged()) {
            for (Component load : super.getLoads()) {
                load.disengage();
            }
        }
    }

    public int getLimit() {
        return this.limit;
    }

}
