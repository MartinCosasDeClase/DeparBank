import java.util.Scanner;

public class CompteBancari {
    Scanner teclat = new Scanner(System.in);
    private String iban, titular;
    private double saldo;

    public CompteBancari() {
    }

    public void omplir() {
        System.out.println("Introdueix IBAN");
        String ibantemp = teclat.nextLine();
        if (comproIban(ibantemp)) {
            this.iban = ibantemp;
        }
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void dadesCompte() {
        System.out.println("IBAN: " + this.iban + "\nTitular: " + this.titular + "\nSaldo: " + this.saldo);
    }

    public void iban() {
        System.out.println("IBAN: " + this.iban);
    }

    public void titular() {
        System.out.println("El titular de la cuenta es " + this.titular);
    }

    public void saldo() {
        System.out.println("El saldo es: " + this.saldo);
    }

    public boolean ingreso() {
        boolean ñarlos = true;
        System.out.println("Selecciona la cantidad a ingresar");
        return ñarlos;
    }

    private boolean comproIban(String a) {
        boolean comprobar = false;
        int let = 0, num = 0;
        char[] compro = a.toCharArray();
        for (int i : compro) {
            if (let != 2) {
                for (char j = 'A'; j != 'Z'; j++) {
                    if (i == j) {
                        let++;
                    }
                }
            } else if (i > 1 && let == 2) {
                for (int h = 0; h != 10; h++) {
                    if ((i-48) == h) {
                        num++;
                    }
                }
            } else {
                comprobar = false;
                break;
            }

        }
        if (let == 2 && num == 22) {
            comprobar = true;
        }
        return comprobar;
    }
}
