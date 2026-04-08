import base64
import time
import secrets
import os

# Demonstracao de criptografia simetrica sem dependencias externas
# Utilizando apenas a biblioteca padrao do Python

def xor_encrypt(text, key):
      """Cifra XOR simples para fins educacionais"""
      key_bytes = key.encode() if isinstance(key, str) else key
      text_bytes = text.encode() if isinstance(text, str) else text
      return bytes([b ^ key_bytes[i % len(key_bytes)] for i, b in enumerate(text_bytes)])

def gerar_chave(tamanho_bits):
      return os.urandom(tamanho_bits // 8)

print("=== DEMONSTRACAO DE CRIPTOGRAFIA SIMETRICA ===")
print("Conceito: a mesma chave e utilizada tanto para cifrar quanto para decifrar")
print()

mensagem = "Teoria da Computacao - Criptografia Simetrica"
print(f"Mensagem original: {mensagem}")
print()

# Simulacao AES-like com XOR para demonstracao educacional
for nome, tamanho in [("AES-128", 128), ("AES-192", 192), ("AES-256", 256)]:
      chave = gerar_chave(tamanho)

    inicio = time.time()
    cifrado = xor_encrypt(mensagem, chave)
    tempo_cifrar = time.time() - inicio

    inicio = time.time()
    decifrado = xor_encrypt(cifrado, chave).decode()
    tempo_decifrar = time.time() - inicio

    cifrado_b64 = base64.b64encode(cifrado).decode()

    print(f"--- {nome} ---")
    print(f"Chave ({tamanho} bits): {base64.b64encode(chave).decode()[:20]}...")
    print(f"Cifrado (Base64): {cifrado_b64[:30]}...")
    print(f"Decifrado: {decifrado}")
    print(f"Tempo cifrar: {tempo_cifrar:.6f}s | Tempo decifrar: {tempo_decifrar:.6f}s")
    print(f"Correto: {decifrado == mensagem}")
    print()

print("Conceito: A seguranca reside na CHAVE, nao no algoritmo (Principio de Kerckhoffs)")
print("AES-256 com chave de 256 bits possui 2^256 combinacoes possiveis")
print("Computacao quantica (Grover): reduz para 2^128 - ainda extremamente seguro!")
