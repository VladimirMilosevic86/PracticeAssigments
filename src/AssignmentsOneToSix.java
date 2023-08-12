import java.text.DecimalFormat;

public class AssignmentsOneToSix {

    /* 1) Napraviti funkciju koja kao argument prima niz Stringova, i String koji zelimo da lociramo u tom nizu.
    Kao rezultat vratiti true/false ukoliko se nalazi/ne nalazi u nizu. */
    public static boolean find(String rec, String[] niz){
        for (String s : niz) {
            if (rec.equalsIgnoreCase(s))
                return true;
        }
        return false;
    }

    /* 2) Napraviti funkciju koja prima niz celih brojeva i kao rezultat vraca nov niz gde je svaki
    element pomnozen sa Pi. */
    public static double[] pomnozenoSaPI(int[] brojevi) {
        double[] niz = new double[brojevi.length];
        final double PI = 3.14;
        DecimalFormat df = new DecimalFormat("#.##"); //pravi patern da ogranici na samo dve decimale
        for (int i = 0; i < niz.length; i++) {
            niz[i] = Double.parseDouble(df.format(brojevi[i] * PI)); //formatira niz[i] na dve decimale
        }
        return niz;
    }

    /* 3) Napraviti funkciju koja ce za prosledjeni String obrnuti redosled karaktera. */

    //3. OPCIJA A -meni se ova vise dopada :)
    public static String reverse(String rec){
        char[] nizSlova = rec.toCharArray(); //pretvara promenljivu string u niz karaktera
        String obrnutaRec = ""; //postavljamo pocetnu vrednost na prazan String
        for (int i = nizSlova.length - 1; i >= 0 ; i--) { //krece od poslednjeg elementa u nizu
            obrnutaRec += nizSlova[i];
        }
        return obrnutaRec;
    }
    //3. OPCIJA B
    /*
    public static String reverse(String rec){
        String obrnutaRec = "";
        for (int i = 0; i < rec.length(); i++) {
            obrnutaRec = rec.charAt(i) + obrnutaRec;
        }
        return obrnutaRec;
    }
    */

    /* 4) Napraviti funkciju koja ce primati niz Stringova, String koji zelimo da zamenimo,
    i String sa kojim zelimo da ga zamenimo u tom nizu. */
    public static void replaceWith(String[] niz, String oldString, String newString){
        for (int i = 0; i < niz.length; i++) {
            if (niz[i].equalsIgnoreCase(oldString))
                niz[i] = newString;
        }
    }

    /* 5) Napraviti funkciju koja prima String, String zapis ce biti u vidu nekog broja(npr "123", "741",..),
    funkcija treba ovaj String da pretvori u ceo broj i da ispise svaki broj koji je deljiv sa tim brojem. */
    public static void deljivSa(String broj) {
        int ceoBroj = Integer.parseInt(broj);
        for (int i = 1; i <= ceoBroj; i++) {
            if(ceoBroj % i == 0)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    /* 6) Napraviti funkciju koja prima dva niza celih brojeva (ne moraju da budu iste velicine),
     porediti svaki broj na istoj poziciji i u zavisnosti od toga koji je veci dodati ga u rezultujuci
     niz, ako jednom nizu ponestane elemenata za poredjenje sa drugim nizom, samo ispisati
     preostale elemente. */ //niz1[2, 3, 6, 8, 10] niz2[1, 4, 5]
     public static int[] najveci(int[] niz1, int[] niz2){
         int[] rezultatNiz;
         int[] duziNiz;
         int[] kraciNiz;

         if (niz1.length > niz2.length){
             duziNiz = niz1;
             kraciNiz = niz2;
             rezultatNiz = new int[niz1.length];
         }
         else {
             duziNiz = niz2;
             kraciNiz = niz1;
             rezultatNiz = new int[niz2.length];
         }

         for (int i = 0; i < duziNiz.length; i++) {
             if (i < kraciNiz.length) {
                 if (niz1[i] >= niz2[i])
                     rezultatNiz[i] = niz1[i];
                 else
                     rezultatNiz[i] = niz2[i];
             } // od linije 91 do 95 moze umesto if-else: rezultatNiz[i] = Math.max(niz1[i], niz2[i]);
             else
                 rezultatNiz[i] = duziNiz[i];
         }

         return rezultatNiz;
     }

    //Opste funkcije
    public static void ispisNiza (double[] niz){
        for (double d : niz){
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public static void ispisNiza (String[] niz){
        for (String s : niz){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void ispisNiza (int[] niz){
        for (int i : niz){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //Test Zadatak 1)
        System.out.println("TEST ZADATAK 1:");
        String[] nizImena = {"Marko", "Strahinja", "Dragoljub", "Amanda", "Katarina"};
        System.out.println(find("Milica", nizImena));

        System.out.println("-------------------------------------------------------");

        //Test zadatak 2)
        System.out.println("TEST ZADATAK 2:");
        int[] nizCelihBrojeva = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] nizRealnihBrojeva = pomnozenoSaPI(nizCelihBrojeva);
        System.out.println("Ovo je niz nakon sto je svaki element pomnozen sa PI:");
        ispisNiza(nizRealnihBrojeva);

        System.out.println("-------------------------------------------------------");

        //Test zadatak 3)
        System.out.println("TEST ZADATAK 3:");
        String obrnutaRec = reverse("Vladimir");
        System.out.println("Obrnut redosled karaktera je: " + obrnutaRec);

        System.out.println("-------------------------------------------------------");

        //Test zadatak 4
        System.out.println("TEST ZADATAK 4:");
        System.out.println("Ovo je niz sa zamenjenim imenom: ");
        replaceWith(nizImena, "Dragoljub", "Vladimir");
        ispisNiza(nizImena);

        System.out.println("-------------------------------------------------------");

        //Test zadatak 5
        System.out.println("TEST ZADATAK 5:");
        System.out.print("Navedeni broj je deljiv sa: ");
        deljivSa("741");

        System.out.println("-------------------------------------------------------");

        //Test zadatak 6
        System.out.println("TEST ZADATAK 6:");
        System.out.print("Najveci niz je: ");
        int[] niz1 = {2, 3, 6, 8, 10};
        int[] niz2 = {1, 4, 5};
        int[] najveciNiz = najveci(niz1, niz2);
        ispisNiza(najveciNiz);

    }
}
