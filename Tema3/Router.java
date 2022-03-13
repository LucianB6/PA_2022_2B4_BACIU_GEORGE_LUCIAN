public class Router extends Node implements Identifiable{

    public String address;
    private static int count;

    public Router(String address){
        this.address = address;
    }

    public Router(){
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
