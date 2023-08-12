import java.util.Scanner;

/* * 7) Napraviti program koji(ovaj zadatak mozda bolje uraditi u posebnoj klasi) :
 a) Ima funkciju koja omogucava korisniku da unese u niz 6 brojeva(nebitno kojih).
 public static int[] unesiBrojeve()
 b) Funkciju koja generise nasumicnih 30 brojeva.(Ovde ce nam trebati Math.random()
 funkcija koja generise Random broj, ali je problem sto generise jedan double broj sa dugom
 decimalom, osmislite kako bi vi taj broj skratili i pretvorili ga u ceo broj)
 public static int[] randomBrojevi()
 c) Funkcija koja ispisuje korisniku koliko je brojeva pogodio i koje brojeve je pogodio.
 public static void bingo(int[] niz1, int[] niz2)*/
public class AssignmentSeven {

    //Zadatak 7) a)
    public static int[] unesiBrojeve(){
        Scanner sc = new Scanner(System.in);
        int elementNiza;
        int[] niz = new int[6];
        int pokusaj = 0;

        System.out.print("Unesi 6 celih brojeva (od 1 do 100): ");
        while (pokusaj < niz.length) {
            elementNiza = sc.nextInt();
            niz[pokusaj] = elementNiza;
            pokusaj++;
        }

        return niz;
    }

    //Zadatak 7) b)
    public static int[] randomBrojevi(){
        int[] niz = new int[30];

        for (int i = 0; i < niz.length; i++) {
            double nasumicanBroj = Math.random() * 100 + 1;
            int elementNiza = (int)nasumicanBroj;
            niz[i] = elementNiza;
        }

        return niz;
    }

    //zadatak 7) c)
    public static void bingo(int[] niz1, int[] niz2){
        int brojac = 0;
        System.out.println("Pogodjeni brojevi: ");
        for (int i = 0; i < niz1.length; i++) {
            for (int j = 0; j < niz2.length; j++) {
                if (niz1[i] == niz2[j]) {
                    brojac++;
                    System.out.println(niz1[i] + " ");
                    if (brojac == 0)
                        System.out.println("Niste pogodili nijedan broj!");
                }
            }
        }
    }

    public static void ispisNiza (int[] niz){
        for (int i : niz){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //Test zadatak 7a
        System.out.println("TEST ZADATAK 7a: ");
        int[] niz = unesiBrojeve();
        System.out.print("Tvoj niz je: ");
        ispisNiza(niz);

        System.out.println("-------------------------------------------------------");

        //Test zadatak 7b
        System.out.println("TEST ZADATAK 7b: ");
        int[] randomNiz = randomBrojevi();
        System.out.print("Niz od 30 nasumicnih brojeva: ");
        ispisNiza(randomNiz);

        System.out.println("-------------------------------------------------------");

        //Test zadatak 7c
        System.out.println("TEST ZADATAK 7c: ");
        bingo(niz, randomNiz);

    }
}
