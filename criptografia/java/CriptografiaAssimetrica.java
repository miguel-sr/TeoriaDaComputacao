import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 * Programa Didatico de Criptografia Assimetrica
   * Ilustra o RSA: geracao de par de chaves, cifracao e assinatura digital
   * Teoria da Computacao - Blockchain e Criptomoedas
   */
public class CriptografiaAssimetrica {

    private static final String RSA_ALGORITHM = "RSA";
      private static final int RSA_KEY_SIZE = 2048;
      private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    public static void main(String[] args) throws Exception {
              System.out.println("=".repeat(60));
              System.out.println(" PROGRAMA DIDATICO DE CRIPTOGRAFIA ASSIMETRICA");
              System.out.println(" Teoria da Computacao - Blockchain e Criptomoedas");
              System.out.println("=".repeat(60));

          // 1. Gerar par de chaves RSA
          System.out.println("\n1. Gerando par de chaves RSA (" + RSA_KEY_SIZE + " bits)...");
              KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA_ALGORITHM);
              keyGen.initialize(RSA_KEY_SIZE);
              KeyPair keyPair = keyGen.generateKeyPair();
              PublicKey publicKey = keyPair.getPublic();
              PrivateKey privateKey = keyPair.getPrivate();

          String pubEncoded = Base64.getEncoder().encodeToString(publicKey.getEncoded());
              String privEncoded = Base64.getEncoder().encodeToString(privateKey.getEncoded());
              System.out.println("   Chave publica: " + pubEncoded.substring(0, 50) + "...");
              System.out.println("   Chave privada: " + privEncoded.substring(0, 50) + "...");

          // 2. Cifrar com a chave publica
          String mensagemOriginal = "Teoria da Computacao - RSA Assimetrico";
              System.out.println("\n2. Cifrando com a chave PUBLICA...");
              Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
              cipher.init(Cipher.ENCRYPT_MODE, publicKey);
              byte[] mensagemCifrada = cipher.doFinal(mensagemOriginal.getBytes());
              String cifradaB64 = Base64.getEncoder().encodeToString(mensagemCifrada);
              System.out.println("   Original: " + mensagemOriginal);
              System.out.println("   Cifrado (Base64): " + cifradaB64.substring(0, 50) + "...");

          // 3. Decifrar com a chave privada
          System.out.println("\n3. Decifrando com a chave PRIVADA...");
              cipher.init(Cipher.DECRYPT_MODE, privateKey);
              byte[] mensagemDecifrada = cipher.doFinal(mensagemCifrada);
              String mensagemRecuperada = new String(mensagemDecifrada);
              System.out.println("   Recuperada: " + mensagemRecuperada);
              System.out.println("   Correto: " + mensagemOriginal.equals(mensagemRecuperada));

          // 4. Assinatura digital
          System.out.println("\n4. Gerando Assinatura Digital...");
              Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
              signature.initSign(privateKey);
              signature.update(mensagemOriginal.getBytes());
              byte[] assinatura = signature.sign();
              System.out.println("   Assinatura (Base64): " + Base64.getEncoder().encodeToString(assinatura).substring(0, 50) + "...");

          signature.initVerify(publicKey);
              signature.update(mensagemOriginal.getBytes());
              boolean valida = signature.verify(assinatura);
              System.out.println("   Assinatura valida: " + valida);

          System.out.println("\n" + "=".repeat(60));
              System.out.println("Conceito: RSA fundamentado na dificuldade de fatorar numeros grandes");
              System.out.println("Algoritmo de Shor (quantico) compromete o RSA - adote PQC no futuro!");
              System.out.println("Bitcoin/Ethereum utilizam ECDSA (curvas elipticas) para assinaturas");
    }
}
