import java.util.*;
import java.util.List;

public class Network {

    private static List<Node> nodes;

    public Network(){
        this.nodes = new ArrayList<>();
    }
    public Network(List<Node> nodes){
        this.nodes = nodes;
    }
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public static void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Locations are:  " + nodes + " "
                ;
    }
}
