import hashlib
import time

class Bloco:
      def __init__(self, indice, transacoes, hash_anterior, dificuldade):
                self.indice = indice
                self.transacoes = transacoes
                self.hash_anterior = hash_anterior
                self.timestamp = time.time()
                self.nonce = 0
                self.dificuldade = dificuldade
                self.hash = self.minerar_bloco()

      def calcular_hash(self):
                conteudo = (str(self.indice) + str(self.transacoes) +
                                                str(self.hash_anterior) + str(self.timestamp) + str(self.nonce))
                return hashlib.sha256(conteudo.encode()).hexdigest()

      def minerar_bloco(self):
                alvo = "0" * self.dificuldade
                tentativa_hash = self.calcular_hash()
                while not tentativa_hash.startswith(alvo):
                              self.nonce += 1
                              tentativa_hash = self.calcular_hash()
                          print(f"Bloco {self.indice} minerado com sucesso!")
                return tentativa_hash

  class Blockchain:
        def __init__(self):
                  self.cadeia = []
                  self.dificuldade = 4
                  self.criar_bloco_genesis()

        def criar_bloco_genesis(self):
                  bloco_genesis = Bloco(0, "Bloco Genesis", "0", self.dificuldade)
                  self.cadeia.append(bloco_genesis)

        def adicionar_bloco(self, transacoes):
                  hash_anterior = self.cadeia[-1].hash
                  novo_bloco = Bloco(len(self.cadeia), transacoes, hash_anterior, self.dificuldade)
                  self.cadeia.append(novo_bloco)

        def validar_blockchain(self):
                  for i in range(1, len(self.cadeia)):
                                atual = self.cadeia[i]
                                anterior = self.cadeia[i-1]
                                if atual.hash != atual.calcular_hash():
                                                  print(f"Erro: os dados do bloco {i} foram comprometidos!")
                                                  return False
                                              if atual.hash_anterior != anterior.hash:
                                                                print(f"Erro: o elo entre o bloco {i-1} e {i} foi rompido!")
                                                                return False
                                                        return True

minha_moeda = Blockchain()
print("\nIniciando processo de mineracao...")
minha_moeda.adicionar_bloco("Pagamento: Joao -> Maria (10 coins)")
minha_moeda.adicionar_bloco("Pagamento: Maria -> Jose (2 coins)")
print(f"\nA rede esta segura e valida? {minha_moeda.validar_blockchain()}")
print("\n--- TESTE DE SEGURANCA (FRAUDE) ---")
minha_moeda.cadeia[1].transacoes = "Pagamento: Joao -> Maria (1000 coins)"
print(f"Apos a adulteracao, a rede permanece valida? {minha_moeda.validar_blockchain()}")
