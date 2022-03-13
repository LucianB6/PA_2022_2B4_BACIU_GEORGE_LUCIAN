public class Main {
    public static void main(String[] args) {
        Computer c1 = new Computer();
        c1.setName("v1 Computer A");
        Computer c2 = new Computer();
        c2.setName("v2 Computer B");
        Computer c3 = new Computer();
        c3.setName("v3 Computer C");
        Computer c4 = new Computer();
        c4.setName("v4 Computer D");
        Router c5 = new Router();
        c5.setName("v5 Router E");
        Router c6 = new Router();
        c6.setName("v6 Rounter F");
        Switch c7 = new Switch();
        c7.setName("v7 Switch G");
        Switch c8 = new Switch();
        c8.setName("v8 Switch H");
        Storage storage = new Storage() {
            @Override
            public int getStorageCapacity() {
                return 0;
            }
        };
        Network network = new Network();
        Node node = new Node() {
            @Override
            public int compareTo(Node o) {
                return 0;
            }
        };
        Network.addNode(c1);
        Node.setCost(c1, 21);
        Network.addNode(c2);
        Node.setCost(c2, 25);
        Network.addNode(c3);
        Node.setCost(c3, 12);
        Network.addNode(c4);
        Node.setCost(c4, 44);
        Network.addNode(c5);
        Node.setCost(c5, 11);
        Network.addNode(c6);
        Node.setCost(c6, 64);
        Network.addNode(c7);
        Node.setCost(c7, 12);
        Network.addNode(c8);
        Node.setCost(c8, 66);

        System.out.print(network +"\n"+ node);
    }
}
