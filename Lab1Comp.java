import java.util.Random;

public class Lab1Comp {

    int calcul() {

        int n = (int) (Math.random() * 1_000_000);
        return n;
    }
    static void verificareCuvant(int l,int c,char[][] cuvant){
        int k = 0;
        int m = 1;
        for (int i = 0 ; i <= l; i++){
            for(int j = 0; j <= c; j++) {
                if(cuvant[i][k] == cuvant[m][j]) {
                    System.out.println(cuvant[i][j]);

                    }
                k++;
            }
        m = m + 1;
        k = 0;
        }
        //return false;
    }
    /*static void generareCuv(int l, int c, char[][] cuvant) {
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j <= c; j++) {
                 if(verificareCuvant(l, c, cuvant) == true)
                    System.out.println(cuvant[1][j]);
            }
        }
    }
*/

    public static void main(String args[]) {

        System.out.println("Hello World!");

        String[] languagesFrom = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        String[] languagesTo = new String[10];
        System.arraycopy(languagesFrom, 0, languagesTo, 0, 10);
        for (String coffee : languagesTo) {
            System.out.print(coffee + " ");
        }
        Lab1Comp obj1 = new Lab1Comp();
        int rand = obj1.calcul();
        System.out.println(rand);

        int b = 3;

        int mult = rand * b;
        int bin = 10101;

        System.out.println("The multiplication is = " + mult);
        System.out.println("Binary Number = " + bin);

        mult = mult + 0b10101;

        //int k = Integer.valueOf(String.valueOf(mult) + String.valueOf(bin));
        System.out.println(mult);
        mult = mult + 0xFF;
        System.out.println(mult);
        int digit;
        int sum = 0;
        while (mult > 0) {
            digit = mult % 10;
            sum = sum + digit;
            mult = mult / 10;

            if (mult == 0 && sum >= 10) {
                mult = sum;
                sum = 0;
            }
        }

        System.out.println("The sum is: " + sum);

        System.out.println("Willy-nilly, this semester I will learn " + languagesTo[sum]);
        //String res = k + ff;
        //System.out.println(res);

        /*int n = 7;
        int p = 4;
        Random r = new Random();
        String words = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < n; i++){
            System.out.println(words.charAt(r.nextInt(words.length())));
        */

        int a = 97; // codul ASCII pentru litera a
        int z = 122; // codul ASCII pentru litera z

        int p = 4;
        int n = 7;

        System.out.println("n = " + n + " p = " + p);

        Random random = new Random();
        for(int i = 1; i <= n; i++) {
            String words = random.ints(a, z + 1)
                    .limit(p)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            System.out.println(i + "." + words);
                }
        int l = 2;
        int c = 2;
        char[][] cuvinte = {{'L','C','A'},
                            {'L','D','A'},
                            {'O','M','C'},
                            };
        verificareCuvant(l,c,cuvinte);
            }
        }
