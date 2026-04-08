import java.util.Scanner;

public class QuebradorCesar {
      public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("--- Sistema de Interceptacao (Forca Bruta) ---");
                System.out.print("Informe a mensagem cifrada a ser quebrada: ");
                String mensagemCifrada = scanner.nextLine().toLowerCase();
                System.out.println("\nIniciando processo de quebra...\n");
                for (int shift = 1; shift <= 25; shift++) {
                              String tentativa = decifrar(mensagemCifrada, shift);
                              System.out.printf("Tentativa (Shift %02d): %s\n", shift, tentativa);
                }
                System.out.println("\nAnalise as opcoes acima. A correta sera evidente!");
                scanner.close();
      }

    public static String decifrar(String texto, int deslocamento) {
              StringBuilder sb = new StringBuilder();
              for (char c : texto.toCharArray()) {
                            if (Character.isLetter(c)) {
                                              int posicaoAlfabeto = c - 'a';
                                              int novaPosicao = (posicaoAlfabeto - deslocamento + 26) % 26;
                                              sb.append((char) ('a' + novaPosicao));
                            } else {
                                              sb.append(c);
                            }
              }
              return sb.toString();
    }
}
