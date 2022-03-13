import javax.xml.stream.Location;

public class Computer extends Node implements Identifiable, Storage {

    private String address;
    private int storageCapacity;
    private static int count;

    public Computer(String address, String name, int storageCapacity){
        super(name);
        this.address = address;
        this.storageCapacity = storageCapacity;
    }

    public Computer(){
    }

    @Override
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }
    public void setStorageCapacity(int storageCapacity){
        this.storageCapacity = storageCapacity;
        }

    @Override
    public int compareTo(Node o) {
        return 0;
    }

    public String toString(){

        return "(" + super.getName() + ")";
    }
}
