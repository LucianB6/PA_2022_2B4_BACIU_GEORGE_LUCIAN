public class Switch extends Node implements Identifiable{

    public String address;
    private static int count;

    public Switch(String address){
        this.address = address;
    }

    public Switch(){
    }

    @Override
    public String toString() {
        count++;
        return "(" + super.getName() + ")";
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
