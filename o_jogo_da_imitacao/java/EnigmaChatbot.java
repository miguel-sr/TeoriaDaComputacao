import java.util.Scanner;

public class EnigmaChatbot {
      public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String input;
                System.out.println("--- Assistente Bletchley Park ---");
                System.out.println("Ola! Sou o TuringBot. Sobre o que deseja conversar? (historia, java, huts, sair)");
                while (true) {
                              System.out.print("> ");
                              input = scanner.nextLine().toLowerCase().trim();
                              if (input.equals("sair")) {
                                                System.out.println("Encerrando transmissao... ate a proxima!");
                                                break;
                              }
                              String resposta;
                              switch (input) {
                                case "historia":
                                                      resposta = "A Enigma foi desenvolvida por Arthur Scherbius em 1918 para uso comercial.";
                                                      break;
                                case "java":
                                                      resposta = "A logica dos rotores pode ser implementada com aritmetica modular: (i + rot) % 26.";
                                                      break;
                                case "huts":
                                                      resposta = "As Huts eram cabanas de madeira. A Hut 8 era o local de trabalho de Alan Turing.";
                                                      break;
                                case "ajuda":
                                                      resposta = "Experimente: 'historia', 'java' ou 'huts'.";
                                                      break;
                                default:
                                                      resposta = "Desculpe, essa mensagem esta cifrada para mim. Poderia repetir?";
                              }
                              System.out.println(resposta);
                }
                scanner.close();
      }
}
