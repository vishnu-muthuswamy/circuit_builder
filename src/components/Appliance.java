package components;

public class Appliance extends Component {
    private final int rating;

    public Appliance(String name, Component source, int rating) {
        super(name, source);
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    @Override
    public void engage() {
        if(isSwitchOn()) {
            changeDraw(getRating());
        }
    }

    @Override
    public void disengage() {
        if(isSwitchOn()) {
            changeDraw(-getRating());
        }
    }

    @Override
    public void turnOn() {
        super.turnOn();
        if(engaged()) {
            changeDraw(getRating());
        }
    }

    @Override
    public void turnOff() {
        super.turnOff();
        if(engaged()) {
            changeDraw(-getRating());
        }
    }

}
