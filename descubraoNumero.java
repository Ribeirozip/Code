import java.util.Scanner;
public class termo {
    public static void main(String[] args) {



                Scanner entrada = new Scanner(System.in);
                Random random = new Random();

                int numParaAdivinhar = random.nextInt(100) + 1;
                int palpite;
                int tentativas = 0;

                System.out.println("Bem-vindo ao Jogo da Adivinhação!");
                System.out.println("Tente adivinhar o número entre 1 e 100.");

                while (true) {
                    palpite = entrada.nextInt();
                    tentativas++;

                    if (palpite == numParaAdivinhar) {
                        System.out.println("Parabéns!! você acertou o número em " + tentativas + " tentativa(s)!");
                        break;
                    } else if (palpite < numParaAdivinhar) {
                        System.out.println("Desta vez um número maior.");
                    } else {
                        System.out.println("Desta vez um número menor.");
                    }
                }

            }
        }
