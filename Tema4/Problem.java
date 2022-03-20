import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.LinkedList;

public class Problem {
    public static void main(String[] args) {

        var intersectionsArray = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("Intersection " + i))
                .toArray(Intersection[]::new);
        var streetArray= IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Street("Street " + i, (i == 0 ? 1 : 2)))
                .toArray(Street[]::new);

        List<Intersection> intersections = new ArrayList<>(Arrays.asList(intersectionsArray));

        List<Street> streets = new LinkedList<>();
        streets.addAll(Arrays.asList(streetArray));
        streetArray[0].setLength(1);
        streetArray[1].setLength(3);
        streetArray[2].setLength(2);

        Set<Street> schools = new HashSet<>(Arrays.asList(streetArray));

        streets.sort(Comparator.comparing(Street::getLength));

        System.out.print("\nSorted students:\n\t");
        streets.forEach((s) -> System.out.print(s.getName() + " "));
        System.out.print("\n");

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        cityMap.put(intersectionsArray[0], Arrays.asList(streetArray[0], streetArray[1], streetArray[2]));
        cityMap.put(intersectionsArray[1], Arrays.asList(streetArray[2], streetArray[1], streetArray[0]));
        cityMap.put(intersectionsArray[2], Arrays.asList(streetArray[2], streetArray[1], streetArray[0]));
        cityMap.put(intersectionsArray[3], Arrays.asList(streetArray[1], streetArray[0], streetArray[2]));

        System.out.println("Intersections map: ");

        cityMap.forEach((intersection, streetPref) -> {
            System.out.println("\n Intersection: " + intersection.getName());
            streetPref.forEach((street -> System.out.print("\n" + street.getName())));
        });
    }
}

