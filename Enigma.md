# Atividade Acadêmica - Máquina Enigma

Esta atividade propõe uma análise interdisciplinar envolvendo **História**, **Matemática** e **Ciência da Computação**, a partir do estudo da máquina Enigma e das técnicas utilizadas para decifrar suas mensagens durante a Segunda Guerra Mundial.

---

## 1. Desafio de Criptoanálise

### Dimensionamento do espaço de chaves da Enigma

Para estimar a complexidade da máquina Enigma, consideramos os seguintes elementos:

- 5 rotores disponíveis
- Escolha de 3 rotores por configuração
- 26 posições possíveis para cada rotor
- Plugboard com até 10 conexões simultâneas

#### 1.1 Permutação dos rotores

A ordem dos rotores influencia diretamente o resultado da criptografia. Como são escolhidos 3 entre 5, temos:

> P(5,3) = 5 × 4 × 3 = **60 configurações possíveis**

#### 1.2 Posições iniciais dos rotores

Cada rotor pode assumir 26 posições distintas. Logo:

> 26³ = **17.576 combinações**

#### 1.3 Configuração do plugboard

O plugboard (Steckerbrett) permite múltiplas conexões entre pares de letras, gerando aproximadamente:

> **150.738.274.937.250 possibilidades**

#### 1.4 Espaço total de chaves

Multiplicando todos os fatores:

> 60 × 17.576 × 150.738.274.937.250 ≈ **1,58 × 10²³**

Ou seja, cerca de **158 sextilhões de configurações possíveis**, evidenciando a enorme complexidade do sistema.

---

## 2. Implementação em Python - Cálculo do espaço de chaves

```python
import math

rotor_orders = math.perm(5, 3)
rotor_positions = 26 ** 3
plugboard = 150738274937250

total = rotor_orders * rotor_positions * plugboard

print("Ordens de rotores:", rotor_orders)
print("Posições iniciais:", rotor_positions)
print("Combinações do plugboard:", plugboard)
print("Total de combinações:", total)
```

---

## 3. Implementação em Java - Cálculo do espaço de chaves

```java
public class EnigmaCombinacoes {

    public static void main(String[] args) {

        int rotorOrders = 5 * 4 * 3;
        int rotorPositions = (int) Math.pow(26, 3);
        long plugboard = 150738274937250L;

        double total = rotorOrders * rotorPositions * plugboard;

        System.out.println("Ordens de rotores: " + rotorOrders);
        System.out.println("Posições iniciais: " + rotorPositions);
        System.out.println("Combinações do plugboard: " + plugboard);
        System.out.println("Total de combinações possíveis: " + total);
    }
}
```

---

## 4. Simulação simplificada da Enigma

O código abaixo representa uma versão simplificada da criptografia utilizando três rotores fixos:

```python
import string

alphabet = string.ascii_uppercase

rotor1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ"
rotor2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE"
rotor3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO"

def encrypt(letter, r1, r2, r3):
    index = alphabet.index(letter)
    step1 = r1[index]
    step2 = r2[alphabet.index(step1)]
    step3 = r3[alphabet.index(step2)]
    return step3

message = "HELLO"
result = ""

for char in message:
    result += encrypt(char, rotor1, rotor2, rotor3)

print(result)
```

---

## 5. Operação em Bletchley Park

### Parâmetros utilizados

| Campo           | Valor            |
|-----------------|------------------|
| Modelo          | Enigma I         |
| Rotores         | I – II – III     |
| Posição inicial | A – B – C        |
| Ring setting    | A – A – A        |
| Plugboard       | A-M, B-N, C-O    |

### Mensagem interceptada

```
PXQZ GBDN
```

### Resultado obtido após decifração

```
HELLO YOU
```

---

## 6. Propriedade de Reciprocidade

Uma característica fundamental da Enigma é sua propriedade de simetria:

> **E(E(x)) = x**

Isso significa que a **mesma configuração** utilizada para criptografar uma mensagem também pode ser utilizada para descriptografá-la.

Essa propriedade é possível graças ao **refletor**, que faz o sinal percorrer o caminho de ida e volta dentro da máquina.

---

## 7. Sensibilidade à Configuração

Ao alterar apenas um elemento da chave, como a posição inicial dos rotores:

| Estado | Posição |
|--------|---------|
| Antes  | A B C   |
| Depois | B B C   |

O resultado da descriptografia se torna completamente inválido.

Isso evidencia um princípio essencial da criptografia:

> **Pequenas variações na chave geram mudanças drásticas no resultado.**

---

## 8. Análise Conceitual

### P1 - Alteração da ordem dos rotores

Modificar a sequência dos rotores (por exemplo, de I–II–III para II–I–III) altera totalmente o percurso do sinal elétrico, impedindo a decodificação correta da mensagem.

### P2 - Papel do plugboard

O plugboard adiciona uma camada extra de substituição antes e depois dos rotores, aumentando significativamente o número de combinações possíveis. Mesmo com poucas conexões, ele já eleva a complexidade para níveis extremamente altos.

### P3 - Segurança baseada na chave

Mesmo com acesso físico à máquina, um invasor não conseguiria interpretar as mensagens sem conhecer as configurações diárias, que incluem:

- Ordem dos rotores
- Posições iniciais
- Ligações do plugboard

Esse conceito reforça um princípio central da criptografia moderna:

> **A segurança de um sistema deve depender da chave, e não do funcionamento do algoritmo.**
