import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

import java.security.AllPermission;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        var intersectionsArray = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("Intersection " + i))
                .toArray(Intersection[]::new);
        var streetArray= IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Street("Street " + i, (i == 0 ? 1 : 2)))
                .toArray(Street[]::new);

        List<Intersection> intersections = new ArrayList<>(Arrays.asList(intersectionsArray));
        List<Street> streets = new ArrayList<>();
        streets.addAll(Arrays.asList(streetArray));
        streetArray[0].setLength(1);
        streetArray[1].setLength(3);
        streetArray[2].setLength(2);

        Set<Street> schools = new HashSet<>(Arrays.asList(streetArray));

        System.out.println("Intersections map: ");
        City city =new City();

        System.out.println(city + "\n");
        city.RandomNames(7,9);

        //city.Prim();

    }
}

