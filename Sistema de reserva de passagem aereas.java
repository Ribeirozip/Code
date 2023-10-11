// main class

package proto;

public class Viagens {
    public static void main(String[] args) {


        Azul v1 = new Azul();
        v1.startprograma(); // função que execulta o codigo
    }
}

// class

import java.awt.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.JLabel;
public class Azul {


    private int numVoo;
    private String cliente;
    private int reserva;
    private boolean status;
    private int milhas;
    private int tipo;

    private boolean adm;

    private int getTipo() {
        return tipo;
    }

    private void setTipo(int tipo) {
        this.tipo = tipo;
    }

    private void setMilhas(int milhas) {
        this.milhas = milhas;
    }

    private int getMilhas() {
        return milhas;
    }

    public int getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(int numV) {
        this.numVoo = numV;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    private int getReserva() {
        return reserva;
    }

    private void setReserva(int reserva) {
        this.reserva = reserva;
    }

    private boolean getStatus() {
        return status;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }


    Azul() {
        this.reserva = 20;
        this.milhas = 0;
        this.tipo = 0;
        this.status = false;

    }

   private void perfil() {
        JLabel la = new JLabel("Perfil de Usuario ", JLabel.CENTER);
        la.setFont(new Font("Calibri", Font.BOLD, 40));
        la.setForeground(Color.darkGray);
        JFrame frame = new JFrame("PERFIL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.getContentPane().setBackground(new Color(77, 125, 42));
        frame.setSize(700, 700);
        frame.add(la);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(null, "Nome do Cliente: "+this.getCliente()+"\nNumero do voo: "+this.getNumVoo()+
                "\nNumero de reservas disponiveis: "+this.reserva+"\nSuas milhas: "+this.milhas,"Perfil",JOptionPane.INFORMATION_MESSAGE);
    }

    private void startReserva() {
        if (this.getStatus()) {
            try {
                Scanner input = new Scanner(System.in);
                String s = JOptionPane.showInputDialog("Digite pra 1-China 2-Cuba 3-Dubai:");
                int i = Integer.parseInt(s);
                switch (i) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Voce escolheu a China");
                        this.tipo = this.tipo + 1;
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Voce escolheu a Cuba");
                        this.tipo = this.tipo + 2;
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Voce escolheu a Dubai");
                        this.tipo = this.tipo + 3;
                        break;

                }
                if (i > 3 || i < 1) {
                    startReserva();
                }
                if (this.tipo == 1) {
                    this.reserva = 20;
                } else if (this.tipo == 2) {
                    this.reserva = 25;
                } else {
                    this.reserva = 30;
                }

                fazerReserva();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor digite um numero de 1 a 3");
                startReserva();
            } finally {


            }

        }
    }

    public void fazerReserva() {
        if (this.getStatus()) {
            try {
                String s2 = JOptionPane.showInputDialog("digite as passagem:");
                int r = Integer.parseInt(s2);
                if (r > 0) {
                    if (this.getReserva() >= r) {
                        this.setReserva((int) (this.getReserva() - r));
                        this.milhas = this.milhas + r;
                        JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!!!");
                        perfil();
                        milhas();

                    } else {
                        JOptionPane.showMessageDialog(null, "Seu pedido de reserva foi maior do que o numero de disponiveis");
                        fazerReserva();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "bote numero positivo por favor!!");
                    fazerReserva();
                }


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor digite um numero de reservas");
                fazerReserva();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossivel fazer reservas sem começar o programa");
        }
    }

    public void milhas() {
        if (this.getStatus()) {
            if (this.milhas >= 3 && this.milhas <= 5) {
                JOptionPane.showMessageDialog(null, "Voce conseguiu 5% de desconto na proxima viagem!!!");
            } else if (this.milhas >= 6 && this.milhas <= 10) {
                JOptionPane.showMessageDialog(null, "Voce conseguiu 25% de desconto na proxima viagem!!!");
            } else if (this.milhas >= 11 && this.milhas <= 20) {
                JOptionPane.showMessageDialog(null, "Voce conseguiu 50% de desconto na proxima viagem!!!");
            }
        }

    }

    public void cancelarReserva() {
        this.setStatus(false);
    }


    public void startprograma() {
        try {
            int i1 = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 pra adm 2 pra usuario "));
            switch (i1) {
                case 1:
                    setStatus(true);
                    break;
                case 2:
                    setStatus(false);
                    perfil();
                    break;
            }
            if (i1 <= 0) {
                JOptionPane.showMessageDialog(null, "por favor digite um numero de 1 ou 2");
                startprograma();

            }
            if (i1 > 2) {
                JOptionPane.showMessageDialog(null, "por favor digite um numero de 1 ou 2");
                startprograma();
            }if(i1 == 1){

                String po = JOptionPane.showInputDialog("Deseja criar usuario \n" +
                        "1-Sim 2-Nao");

                int p = Integer.parseInt(po);

                while (p == 1) {
                    String c;
                    do {
                        c = JOptionPane.showInputDialog("Digite o nome do usuario");
                    }while (!c.matches("^[A-Za-zÀ-ÿ\\s]+$"));
                    setCliente(c);
                    String n;
                    do {
                        n = JOptionPane.showInputDialog("Digite o numero do voo");
                    }while(!n.matches("^[0-9]+$"));
                    int n1 = Integer.parseInt(n);
                    setNumVoo(n1);


                    JOptionPane.showMessageDialog(null, "voce criou o usuario: " + this.getCliente() + "\n Com um numero de voo: " + this.getNumVoo());
                    startReserva();
                    break;

                }
                if(p == 2) {
                    JOptionPane.showMessageDialog(null, "então voce foi direcionado pras reservas");
                    startReserva();
                }
                if (p<0 && p>2 ){
                    JOptionPane.showMessageDialog(null, "escreva 1 ou 2");
                    startprograma();
                }
            }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Digite corretamente por favor");
                startprograma();
            }

        }
}


        
         

 
