package components;

public class PowerSource extends Component{

    protected PowerSource(String name, Component source) {
        super(name, source);
    }

    @Override
    public void engage() {
        super.engage();
        for(Component load: super.getLoads()) {
            load.engage();
        }
    }

}
