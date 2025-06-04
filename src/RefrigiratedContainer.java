class RefrigeratedContainer extends Container {
    private String productType;
    private double requiredTemperature;

    public RefrigeratedContainer(String serialNumber, double tareWeight, double maxPayload, String productType, double requiredTemperature) {
        super(serialNumber, 0, tareWeight, maxPayload);
        this.productType = productType;
        this.requiredTemperature = requiredTemperature;
    }

    @Override
    public void loadCargo(double mass) throws Exception {
        if (mass > maxPayload) {
            throw new Exception("OverfillException: Exceeds payload limit");
        }
        this.cargoMass = mass;
    }

    @Override
    public String toString() {
        return super.toString() + " [ProductType=" + productType + ", RequiredTemperature=" + requiredTemperature + "]";
    }
}