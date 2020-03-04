package components;

public class Outlet extends Component{

    protected Outlet(String name, Component source) {
        super(name, source);
    }

    @Override
    public void engage() {
        super.engage();
        engageLoads();
    }

    @Override
    public void disengage() {
        super.disengage();
        disengageLoads();
    }

}
