public class Solution<c,r> {

    public Solution(Event c3, COMPUTER_LAB r3) {
        int number = Integer.parseInt(String.valueOf(r3));
        number = number + 1;
        System.out.println("Sala noua pentru evenimentul " + c3 + " este " + number );
    }
    private Solution(Event c3, LECTURE_HALL r3) {
        int number = Integer.parseInt(String.valueOf(r3));
        number = number + 1;
        System.out.println("Sala noua pentru evenimentul " + c3 + " este " + number );
    }

}
