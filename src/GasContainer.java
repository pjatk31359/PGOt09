class GasContainer extends Container implements IHazardNotifier {
    private double pressure;

    public GasContainer(String serialNumber, double tareWeight, double maxPayload, double pressure) {
        super(serialNumber, 0, tareWeight, maxPayload);
        this.pressure = pressure;
    }

    @Override
    public void loadCargo(double mass) throws Exception {
        if (mass > maxPayload) {
            notifyHazard("Attempt to overfill gas container " + serialNumber);
            throw new Exception("OverfillException: Exceeds payload limit");
        }
        this.cargoMass = mass;
    }

    @Override
    public void emptyCargo() {
        this.cargoMass *= 0.05;  // Retains 5% of the cargo
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("Hazard Alert: " + message);
    }
}