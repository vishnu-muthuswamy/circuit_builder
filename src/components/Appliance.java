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


}
