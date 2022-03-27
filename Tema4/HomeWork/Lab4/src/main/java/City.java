import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;

import com.github.javafaker.Faker;

import static java.lang.System.out;


public class City{
    protected List<Street> streets = new ArrayList<>();
    protected List<Intersection> intersections = new ArrayList<>();
    private Map<Intersection, List<Street>> intersectionListMap;

    public City() {
        var intersectionsArray = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("Intersection " + i))
                .toArray(Intersection[]::new);
        var streetArray = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Street("Street " + i, (i == 0 ? 1 : 2)))
                .toArray(Street[]::new);
        streetArray[0].setLength(5);
        streetArray[1].setLength(7);
        streetArray[2].setLength(2);
        streetArray[3].setLength(6);
        streetArray[4].setLength(9);

        Map<Intersection, List<Street>> intersectionListMap = new HashMap<>();
        intersectionListMap.put(intersectionsArray[0], Arrays.asList(streetArray[0], streetArray[1], streetArray[2]));
        intersectionListMap.put(intersectionsArray[1], Arrays.asList(streetArray[2], streetArray[1], streetArray[0]));
        intersectionListMap.put(intersectionsArray[2], Arrays.asList(streetArray[2], streetArray[1], streetArray[0]));
        intersectionListMap.put(intersectionsArray[3], Arrays.asList(streetArray[1], streetArray[0], streetArray[2]));

        intersectionListMap.forEach((intersection, streetPref) -> {
            out.println("\n Intersection: " + intersection.getName());
            streetPref.forEach((street -> out.print("\n" + street.getName())));
        });

        out.println("\n\n Street that has length greater than 3 are: \n");

        Arrays.stream(streetArray).filter(element -> element.getLength() >= 3).forEach(out::println);
        out.println();
    }

    public List<Street> getStreets(){
        return streets;
    }

    public void RandomNames(int numberOfIntersections, int numberOfStreets){
        Faker faker = new Faker();
        Random value = new Random();

        var intersection = IntStream.rangeClosed(0, numberOfIntersections - 1)
                .mapToObj(i -> new Intersection(faker.name().name()))
                .toArray(Intersection[]::new);

        var street = IntStream.rangeClosed(0, numberOfStreets - 1)
                .mapToObj(i -> new Street(faker.name().lastName() + " Street") )
                .toArray(Street[]::new);

        intersections.addAll(Arrays.asList(intersection));

        streets.addAll(Arrays.asList(street));

        out.println("Streets are: ");
        out.println(streets);

        out.println();

        out.println("Intersections are: ");
        out.println(intersections);
    }
    public void Prim(){
        Map<Intersection, Integer> intersection = new HashMap<>();
        List<Street> Length = new ArrayList<>();

        Graph<Intersection, Street> graph = new Graph<Intersection, Street>() {
            @Override
            public Set<Street> getAllEdges(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public Street getEdge(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public Supplier<Intersection> getVertexSupplier() {
                return null;
            }

            @Override
            public Supplier<Street> getEdgeSupplier() {
                return null;
            }

            @Override
            public Street addEdge(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public boolean addEdge(Intersection intersection, Intersection v1, Street street) {
                return false;
            }

            @Override
            public Intersection addVertex() {
                return null;
            }

            @Override
            public boolean addVertex(Intersection intersection) {
                return false;
            }

            @Override
            public boolean containsEdge(Intersection intersection, Intersection v1) {
                return false;
            }

            @Override
            public boolean containsEdge(Street street) {
                return false;
            }

            @Override
            public boolean containsVertex(Intersection intersection) {
                return false;
            }

            @Override
            public Set<Street> edgeSet() {
                return null;
            }

            @Override
            public int degreeOf(Intersection intersection) {
                return 0;
            }

            @Override
            public Set<Street> edgesOf(Intersection intersection) {
                return null;
            }

            @Override
            public int inDegreeOf(Intersection intersection) {
                return 0;
            }

            @Override
            public Set<Street> incomingEdgesOf(Intersection intersection) {
                return null;
            }

            @Override
            public int outDegreeOf(Intersection intersection) {
                return 0;
            }

            @Override
            public Set<Street> outgoingEdgesOf(Intersection intersection) {
                return null;
            }

            @Override
            public boolean removeAllEdges(Collection<? extends Street> collection) {
                return false;
            }

            @Override
            public Set<Street> removeAllEdges(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public boolean removeAllVertices(Collection<? extends Intersection> collection) {
                return false;
            }

            @Override
            public Street removeEdge(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public boolean removeEdge(Street street) {
                return false;
            }

            @Override
            public boolean removeVertex(Intersection intersection) {
                return false;
            }

            @Override
            public Set<Intersection> vertexSet() {
                return null;
            }

            @Override
            public Intersection getEdgeSource(Street street) {
                return null;
            }

            @Override
            public Intersection getEdgeTarget(Street street) {
                return null;
            }

            @Override
            public GraphType getType() {
                return null;
            }

            @Override
            public double getEdgeWeight(Street street) {
                return 0;
            }

            @Override
            public void setEdgeWeight(Street street, double v) {

            }
        };

        for (Intersection intersection1 : intersections) {
            graph.addVertex();
            for (Street street : streets) {
                graph.addEdge();
                graph.setEdgeWeight(street, street.getLength());
            }
        }
        PrimMinimumSpanningTree<Intersection, Street> primTree = new PrimMinimumSpanningTree<>(graph);
        out.println("The shortest path that we can create is: " + primTree.getSpanningTree());
    }
}
