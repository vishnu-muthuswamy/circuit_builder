package components;

public class Appliance extends Component {
    private final int rating;

    protected Appliance(String name, Component source, int rating) {
        super(name, source);
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    @Override
    public void engage() {
        if(isSwitchOn()) {
            setDraw(this.rating);
            changeDraw(getDraw());
        }
    }

    @Override
    public void disengage() {
        if(isSwitchOn()) {
            setDraw(this.rating);
            changeDraw(-getDraw());
        }
    }

    @Override
    public void turnOn() {
        super.turnOn();
        if(engaged()) {
            setDraw(this.rating);
            changeDraw(getDraw());
        }
    }

    @Override
    public void turnOff() {
        super.turnOff();
        if(engaged()) {
            setDraw(this.rating);
            changeDraw(-getDraw());
        }
    }

}
