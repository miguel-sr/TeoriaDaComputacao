import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAExample {

      private PrivateKey privateKey;
      private PublicKey publicKey;

      public RSAExample() throws Exception {
                KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
                generator.initialize(2048);
                KeyPair pair = generator.generateKeyPair();
                this.privateKey = pair.getPrivate();
                this.publicKey = pair.getPublic();
            }

      public RSAExample(String publicKeyBase64, String privateKeyBase64) throws Exception {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);
                X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
                this.publicKey = keyFactory.generatePublic(publicKeySpec);
                byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
                PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
                this.privateKey = keyFactory.generatePrivate(privateKeySpec);
            }

      public String getPublicKeyAsBase64() {
                return Base64.getEncoder().encodeToString(publicKey.getEncoded());
            }

      public String getPrivateKeyAsBase64() {
                return Base64.getEncoder().encodeToString(privateKey.getEncoded());
            }

      public String encrypt(String plainText) throws Exception {
                byte[] data = plainText.getBytes("UTF-8");
                if (data.length > 200) {
                              throw new IllegalArgumentException("Mensagem muito extensa para o RSA");
                          }
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.ENCRYPT_MODE, this.publicKey);
                byte[] encryptedBytes = cipher.doFinal(data);
                return Base64.getEncoder().encodeToString(encryptedBytes);
            }

      public String decrypt(String cipherText) throws Exception {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.DECRYPT_MODE, this.privateKey);
                byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
                byte[] decryptedBytes = cipher.doFinal(decodedBytes);
                return new String(decryptedBytes, "UTF-8");
            }

      public static void main(String[] args) {
                try {
                              System.out.println("=== GERANDO CHAVES RSA ===\n");
                              RSAExample rsa = new RSAExample();
                              String publicKeyBase64 = rsa.getPublicKeyAsBase64();
                              String privateKeyBase64 = rsa.getPrivateKeyAsBase64();
                              System.out.println("Chave Publica:\n" + publicKeyBase64.substring(0, 60) + "...");
                              System.out.println("\nChave Privada:\n" + privateKeyBase64.substring(0, 60) + "...");

                              String message = "Esta e uma mensagem confidencial!";
                              System.out.println("\nMensagem original: " + message);

                              String encryptedMessage = rsa.encrypt(message);
                              System.out.println("\nMensagem criptografada:\n" + encryptedMessage.substring(0, 60) + "...");

                              String decryptedMessage = rsa.decrypt(encryptedMessage);
                              System.out.println("\nMensagem descriptografada: " + decryptedMessage);

                              if (message.equals(decryptedMessage)) {
                                                System.out.println("\nSUCESSO! O RSA funcionou corretamente.");
                                            } else {
                                                System.out.println("\nERRO!");
                                            }
                          } catch (Exception e) {
                              e.printStackTrace();
                          }
            }
  }
