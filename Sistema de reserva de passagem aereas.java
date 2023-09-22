// main class

package proto;

public class Viagens {


        public static void main(String[] args) {


            Azul v1 = new Azul();
            //gets infos de usuario
            v1.setNumVoo();// ex: v1.setNumvoo(111);
            v1.setCliente();// ex: v1.setCliente("Jorge");
            //Açoes possiveis
            v1.startReserva(); // programa so inicia com isso
            v1.perfil();// Perfil com infos do usuario e infos de reservas e milhas
            v1.fazerReserva(4);// assim que faz reservas
            v1.milhas();//assim que consulta o seu desconto de acordo com o numero de reservas ex: mais reservas mais desconto
            v1.cancelarReserva();// faz o contrario do start


        }

}

// class

package proto;
import java.util.Scanner;
public class Azul {


        public int numVoo ;
        public String cliente;
        private int reserva;
        private boolean status;
        private int milhas;
        private int tipo;
        private int getTipo() {
        return tipo;
    }

        private void setTipo(int tipo) {
        this.tipo = tipo;
    }

        private void setMilhas(int milhas){
            this.milhas=milhas;
        }

        private int getMilhas(){
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

        private float getReserva() {
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


        Azul(){
            this.status =false;
            this.reserva = 20;
            this.milhas = 0;
            this.tipo=0;
        }

        public void perfil(){
            System.out.println("---------------------------------------");
            System.out.println("----------------PERFIL-----------------");
            System.out.println("Nome do Cliente:"+this.getCliente());
            System.out.println("Numero do voo:"+this.getNumVoo());
            System.out.println("Numero de reservas Disponiveis:"+this.reserva);
            System.out.println("Suas milhas:"+this.milhas);
            System.out.println("---------------------------------------");
        }
        public void startReserva(){
            this.setStatus(true);
            Scanner input= new Scanner(System.in);
            System.out.println("---------------------------------------");
            System.out.println("Bem vinda a Tatu Airlines");
            System.out.println("Escolha o seu proximo destino:");
            System.out.println("| 1  China | | 2  Cuba  | | 3  Dubai |");
            System.out.println("|20-Lugares| |25-Lugares| |30-Lugares|");
            System.out.println("---------------------------------------");
            int i=input.nextInt();
            switch (i){
                case  1:
                    System.out.println("---------------------------------------");
                    System.out.println("Voce escolheu o China");
                    this.tipo=this.tipo+1;
                    break;

                case  2:
                    System.out.println("---------------------------------------");
                   System.out.println("Voce escolheu o Cuba");
                    this.tipo=this.tipo+2;
                    break;
                case 3:
                    System.out.println("---------------------------------------");
                   System.out.println("Voce escolheu o Dubai");
                    this.tipo=this.tipo+3;
                    break;}
                    if (this.tipo==1){
                        this.reserva=20;
                    } else if (this.tipo==2) {
                        this.reserva=25;
                    }else {
                        this.reserva=30;
                    }


        }
        public void fazerReserva(int r){
        if (this.getStatus()) {
            if (r>0) {
                if (this.getReserva() >= r) {
                    this.setReserva((int) (this.getReserva() - r));
                    this.milhas = milhas + r;
                    System.out.println("---------------------------------------");
                    System.out.println("Reserva realizada com sucesso!! " + this.getCliente());

                } else {
                    System.out.println("---------------------------------------");
                    System.out.println("Seu pedido de reserva foi maior do que o numero de disponiveis");
                }
            }else{
                System.out.println("bote numero positivo por favor!!");}

        }else {
            System.out.println("---------------------------------------");
            System.out.println("Impossivel fazer reservas sem começar o programa\n DIGITE startReserva()");
            System.out.println("---------------------------------------");
        }
    }
        public void milhas(){
            if (this.getStatus()) {
                if (this.milhas<=5){
                    System.out.println("---------------DESCONTO------------------------");
                    System.out.println("Voce conseguiu 5% de desconto na proxima viagem!!");
                    System.out.println("-----------------------------------------------");
                } else if (this.milhas>=6 && this.milhas <=10) {
                    System.out.println("---------------DESCONTO------------------------");
                    System.out.println("Voce conseguiu 15% de desconto na proxima viagem!!");
                    System.out.println("-----------------------------------------------");
                } else if (this.milhas>=11 && this.milhas<=20) {
                    System.out.println("----------------DESCONTO-----------------------");
                    System.out.println("Voce conseguiu 25% de desconto na proxima viagem!!");
                    System.out.println("-----------------------------------------------");
                }
            }
        }

        public void cancelarReserva(){
            this.setStatus(false);
        }


    }
