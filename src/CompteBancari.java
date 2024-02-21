import java.util.Scanner;
import java.util.*;
public class CompteBancari {
    Scanner teclat = new Scanner(System.in);
    private String iban = "a", titular;
    private double saldo;
    private ArrayList <String> arraylist = new ArrayList<>();
    private final int minim = -50;
    private final int acienda = 3000;
    public CompteBancari() {
    }

    public void omplir() {
        while (comproIban(this.iban) != true) {
            System.out.println("Introdueix IBAN");
            String ibantemp = teclat.nextLine();
            if (comproIban(ibantemp)) {
                this.iban = ibantemp;
            } else {
                System.err.println("IBAN erroneo");
            }
        }
        System.out.println("Introduce nombre y apellidos");
        this.titular = teclat.nextLine();
        System.out.println("Quantitat de dines en el compte");
        this.saldo = teclat.nextDouble();
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

    public void ingreso() {
        double cant;
        String save;
        System.out.println("Selecciona la cantidad a ingresar");
        cant = teclat.nextDouble();
        if (cant > 0){
            this.saldo += cant;
            save = "+" + cant;
            arraylist.add(save);
        } else {
            System.err.println("Error en el ingreso");
        }
        if(cant >= 3000){
            System.err.println("SE AVISARA A ACIENDA");
        }
        if(arraylist.size() > 100){
            arraylist.remove(0);
        }
    }
    public void retirada(){
        double cant;
        String save;
        System.out.println("Selecciona la cantidad a retirar");
        cant = teclat.nextDouble();
        if(( this.saldo - cant) < minim){
            System.err.println("No ha sido posible realizar la operación");
        } else if(this.saldo - cant < 0 &&  this.saldo -cant > minim){
            System.out.println("Realizando operacion");
            System.err.println("Aviso \"estas en numeros rojos\" ");
            this.saldo -=cant;
            save = "-"+cant;
            arraylist.add(save);
        } else if(this.saldo -cant > 0){
            System.out.println("Realizando operacion");
            this.saldo -=cant;
            save = "-"+cant;
            arraylist.add(save);
        }
        if(arraylist.size() > 100){
            arraylist.remove(0);
        }
    }
    public void recorrearray(){
        for(String i: arraylist){
            System.out.println(i);
        }
    }

    private boolean comproIban(String a) {
        boolean comprobar = false;
        int let = 0, num = 0;
        a = a.toUpperCase();
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
