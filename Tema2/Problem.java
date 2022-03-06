/*
Programul asteapta sa se ofere o lista de sali pe care acestea le prelucreaza in clasele oferite
Daca una din sali cu numarul ei se repeta, programul va genera o urmatoare sala
Am construit clasa Room care returneaza numarul salii
Clasa event care returneaza evenimentul
Lecture_Hall si COmputer_HAll care precizeaza ce contine sala respectiva
SI clasa solution pentru generarea de noi sali in caz de repetare
 */
public class Problem {

   public static void main(String[] args){
       Event c1 = new Event("C1");
       Event c2 = new Event("L2");
       Event c3 = new Event("C1");
       Event c4 = new Event("L4");
       COMPUTER_LAB r1 = new COMPUTER_LAB("321");
       LECTURE_HALL r2 = new LECTURE_HALL("432");
       COMPUTER_LAB r3 = new COMPUTER_LAB("321");
       LECTURE_HALL r4 = new LECTURE_HALL("123");

       if(c1.equals(c2) && r1.equals(r2)){
           System.out.println("Sala " + c2 + " " + r2 +" este deja rezervata");
       }
       else {
           System.out.println(c1 + " -> " + r1);
           System.out.println(c2 + " -> " + r2);
       }

       if(c1.equals(c3) && r1.equals(r3)) {
           System.out.println("Sala " + c3 + " " + r3 + " este deja rezervata");
           Solution s3 = new Solution(c3,r3);
       }
       else {
           System.out.println(c3 + " -> " + r3);
       }

       if(c1.equals(c4) && r1.equals(r4)){
           System.out.println("Sala " + c4 + " " + r4 + " este deja rezervata");
       }
       else {
           System.out.println(c4 + " -> " + r4);
       }
   }
}


