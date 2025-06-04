abstract class Container {
    protected String serialNumber;
    protected double cargoMass;
    protected double tareWeight;
    protected double maxPayload;

    public Container(String serialNumber, double cargoMass, double tareWeight, double maxPayload) {
        this.serialNumber = serialNumber;
        this.cargoMass = cargoMass;
        this.tareWeight = tareWeight;
        this.maxPayload = maxPayload;
    }

    public abstract void loadCargo(double mass) throws Exception;

    public void emptyCargo() {
        this.cargoMass = 0;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Container " + serialNumber + " [cargoMass=" + cargoMass + ", tareWeight=" + tareWeight + ", maxPayload=" + maxPayload + "]";
    }
}

interface IHazardNotifier {
    void notifyHazard(String message);
}

public class ContainerManagement {
    public static void main(String[] args) {
        try {
            ContainerShip ship = new ContainerShip(20, 5, 100000);

            LiquidContainer liquidContainer = new LiquidContainer("KON-L-1", 2000, 10000, true);
            GasContainer gasContainer = new GasContainer("KON-G-1", 1500, 8000, 10);
            RefrigeratedContainer refrigeratedContainer = new RefrigeratedContainer("KON-C-1", 1200, 5000, "Bananas", 13.3);

            liquidContainer.loadCargo(5000); // Should be fine
            gasContainer.loadCargo(8500); // Should throw exception
            refrigeratedContainer.loadCargo(4000);

            ship.addContainer(liquidContainer);
            ship.addContainer(refrigeratedContainer);

            ship.printShipInfo();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}