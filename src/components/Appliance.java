package components;

public class Appliance extends Component {

    protected Appliance(String name, Component source, int draw) {
        super(name, source);
        setDraw(draw);
    }

}
