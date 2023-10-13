//ATIVIDADE 1
import java.util.Scanner;

public class atv1 {
    public static void main(String[] args) {

     Scanner insert = new Scanner(System.in);

     System.out.print("Informe o numero de anos:");
     String anos = insert.next().replace(",",".");

     System.out.print("Informe o numero de meses:");
     String mes = insert.next().replace(",",".");

     System.out.print("Informe o numero de dias:");
     String dias = insert.next().replace(",",".");

     double resul1 = Double.parseDouble(anos);
     double resul2 = Double.parseDouble(mes);
     double resul3 = Double.parseDouble(dias);

     double Tdia = (resul1*365)+(resul2*30)+resul3;

     System.out.println("O numero toltal de dias foi:"+Tdia);



     insert.close();
    }


//ATIVIDADE 2

public class atv1 {
    public static void main(String[] args) {

        double a = (double) 8.9;
        int b = (int) 7;
        double c = (double) 4.5;
        int d = (int) 6;

        double media1= (a + b )/2;
        
        System.out.println("primeira média:"+media1);
        
        double media2= (c + d )/2;
        
        System.out.println("segunda média:"+media2);
        
        double Fmedia= (media1 + media2)/2;
        
        System.out.println("media das médias:"+Fmedia);


    }

}

//ATIVIDADE 3

import java.util.Scanner;

public class atv1 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("escreva seu saldo");
    String saldo = entrada.next().replace(",",".");

    double Saldo = Double.parseDouble(saldo);

    Double saldop = (Saldo/100)+Saldo;
    Double saldon = ((Saldo/100)-Saldo)*(-1);

    System.out.println("Seu Saldo de ganhos:"+saldop);
    System.out.println("Seu Saldo de perdas:"+saldon);



    entrada.close();
    }

}

//ATIVIDADE 4

import java.util.Scanner;

public class atv1 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("escreva quanto vale o salario minimo");
    String SM = entrada.next().replace(",",".");

    System.out.println("escreva seu salario");
    String SP = entrada.next().replace(",",".");

    Double sm = Double.parseDouble(SM);
    Double sp = Double.parseDouble(SP);

    Double Final = sp/sm;

    System.out.println("Salario minimo é: "+sm+"\nSeu salario é: "+sp+"\nO numero em salarios minimos: "+Final);



    entrada.close();
    }

//ATIVIDADE 5

import java.util.Scanner;

public class atv1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("escreva um numero:");
        double num1 = entrada.nextDouble();
        

        System.out.println("o numero antes é:"+( num1-1));
        System.out.println("o numero depois é:"+( num1+1));


    }

}

//ATIVIDADE 6

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.*;

public class atv1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String val = JOptionPane.showInputDialog("digite o valor:");
        String quant = JOptionPane.showInputDialog("digite a quantidade:");
        String cod = JOptionPane.showInputDialog("digite o codigo:");
        String tax = JOptionPane.showInputDialog("digite a taxa (0-100):");

        Double valor = Double.parseDouble(val);
        Double quantidade = Double.parseDouble(quant);
        Double taxa = Double.parseDouble(tax);


        var resul = valor * quantidade;
        var resulf = (taxa / 100) * resul;
        double txa = (resul-resulf);


        JFrame frame = new JFrame("Resposta");
        final JLabel label = new JLabel("Seu valor é: "+ (resul+txa));
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}



