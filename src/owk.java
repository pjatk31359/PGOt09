class LiquidContainer extends Container implements IHazardNotifier {
    private boolean isHazardous;

    public LiquidContainer(String serialNumber, double tareWeight, double maxPayload, boolean isHazardous) {
        super(serialNumber, 0, tareWeight, maxPayload);
        this.isHazardous = isHazardous;
    }

    @Override
    public void loadCargo(double mass) throws Exception {
        double limit = isHazardous ? maxPayload * 0.5 : maxPayload * 0.9;
        if (mass > limit) {
            notifyHazard("Attempt to overfill hazardous liquid container " + serialNumber);
            throw new Exception("OverfillException: Exceeds allowed limit");
        }
        this.cargoMass = mass;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("Hazard Alert: " + message);
    }
}