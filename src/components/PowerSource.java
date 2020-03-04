package components;

public class PowerSource extends Component{

    public PowerSource(String name) {
        super(name, null);
    }

    @Override
    public void engage() {
        super.engage();
        engageLoads();
    }

}
