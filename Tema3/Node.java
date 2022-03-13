import javax.xml.stream.Location;
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {

    private String name;
    private static Map<Node, Integer> cost;

    public Node() {
        this.cost = new HashMap<>();
    }

    public Node(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public static void setCost(Node node, int value){
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Cost " + cost;
    }
    /*
        Map<Node, Integer> cost = new HashMap<>();

        for(Map.Entry pairEntry: nodes.entrySet()){
            System.out.println(pairEntry.getKey() + ":" + pairEntry.getValue());
        }
*/

}

