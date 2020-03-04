package components;

public class PowerSource extends Component{

    protected PowerSource(String name) {
        super(name, null);
    }

    @Override
    public void engage() {
        super.engage();
        engageLoads();
    }

}
