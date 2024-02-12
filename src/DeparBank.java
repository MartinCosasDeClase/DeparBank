import java.util.Scanner;

public class DeparBank {
    public static void main(String[] args) {
        int menu;
        Scanner teclat = new Scanner(System.in);
        CompteBancari c1 = new CompteBancari();
        System.out.println(c1.getIban());
        c1.omplir();
        System.out.println(c1.getIban());
    }
}
