import java.util.Scanner;

public class DeparBank {
    public static void main(String[] args) {
        int menu;
        Scanner teclat = new Scanner(System.in);
        CompteBancari c1 = new CompteBancari();
        c1.omplir();

        do {
            System.out.println("Bienvenido a DeparBank, que operación desea realizar");
            System.out.println("1.-Dades del compte\n2.-IBAN\n3.-Titular\n4.-Saldo\n5.-Ingrés\n6.-Retirada\n7.-Moviments\n8.-Eixir");

            menu = teclat.nextInt();
            switch (menu) {
                case 1:
                    c1.dadesCompte();
                    break;
                case 2:
                    c1.iban();
                    break;
                case 3:
                    c1.titular();
                    break;
                case 4:
                    c1.saldo();
                    break;
                case 5:
                    c1.ingreso();
                    break;
                case 6:
                    c1.retirada();
                    break;
                case 7:
                    c1.recorrearray();
                    break;
                case 8:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Esa opcion no esta reconocida");
            }
        }while (menu != 8);
    }
}
