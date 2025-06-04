import java.util.ArrayList;
import java.util.List;

class ContainerShip {
    private List<Container> containers;
    private double maxSpeed;
    private int maxContainerNum;
    private double maxWeight;

    public ContainerShip(double maxSpeed, int maxContainerNum, double maxWeight) {
        this.containers = new ArrayList<>();
        this.maxSpeed = maxSpeed;
        this.maxContainerNum = maxContainerNum;
        this.maxWeight = maxWeight;
    }

    public void addContainer(Container container) throws Exception {
        if (containers.size() >= maxContainerNum) {
            throw new Exception("Cannot add more containers, ship capacity reached.");
        }
        containers.add(container);
    }

    public void removeContainer(String serialNumber) {
        containers.removeIf(container -> container.getSerialNumber().equals(serialNumber));
    }

    public void printShipInfo() {
        System.out.println("Container Ship Info: MaxSpeed=" + maxSpeed + ", MaxContainers=" + maxContainerNum + ", MaxWeight=" + maxWeight);
        System.out.println("Containers on board:");
        for (Container container : containers) {
            System.out.println(container);
        }
    }
}