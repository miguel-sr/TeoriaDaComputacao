# O Jogo da Imitação — Resumo

O filme *O Jogo da Imitação* (2014) retrata o uso da máquina Enigma pelos alemães durante a Segunda Guerra Mundial. O modelo apresentado é baseado na Enigma M3, que era amplamente utilizada tanto pela marinha (Kriegsmarine) quanto pelo exército (Heer). Apesar de existirem outras versões, essa era a configuração padrão enfrentada pelos Aliados.

A Enigma M3 funcionava com três rotores móveis escolhidos dentre um conjunto disponível, o que já gerava uma quantidade extremamente grande de combinações possíveis. Além disso, havia o painel de conexões (Steckerbrett), localizado na parte frontal da máquina, considerado a verdadeira “arma secreta” do sistema. Ele permitia trocar pares de letras antes mesmo do sinal passar pelos rotores, aumentando exponencialmente a complexidade da criptografia.

Fisicamente, a máquina possuía um design em caixa de madeira (geralmente carvalho), com teclado de 26 letras e um painel de lâmpadas que indicava o resultado criptografado.

É importante destacar que a Enigma era usada para **codificar mensagens**, enquanto a máquina desenvolvida por Alan Turing no filme tinha o objetivo oposto: **decifrá-las**. No longa, essa máquina é chamada de “Christopher”, mas historicamente ela ficou conhecida como **Bombe**, baseada em um projeto inicial de criptógrafos poloneses e posteriormente aprimorada por Alan Turing e Gordon Welchman.

Originalmente, versões da Enigma eram utilizadas para fins comerciais, mas durante a guerra se transformaram em uma poderosa ferramenta militar baseada em princípios matemáticos.

---

## A complexidade da Enigma

Na prática, o funcionamento da máquina era relativamente simples. O operador conectava pares de letras no painel frontal. Por exemplo, ao conectar “A” com “Z”, sempre que “A” fosse pressionada, o sinal entraria na máquina como “Z” (e vice-versa).

Sem o painel de conexões, a Enigma já possuía cerca de 12 trilhões de combinações possíveis — um número grande, mas teoricamente testável com tempo suficiente. Com o uso do plugboard (geralmente com 10 cabos), esse número saltava para aproximadamente 158 quintilhões de possibilidades, tornando a quebra por tentativa praticamente impossível.

O grande problema para os analistas era que, mesmo que descobrissem a configuração correta dos rotores, qualquer alteração no painel de conexões invalidava completamente o resultado. Isso criava uma camada extra de substituição que alterava tanto a entrada quanto a saída das letras, impedindo qualquer análise direta.

---

## O insight de Alan Turing

A grande sacada de Alan Turing foi perceber uma limitação lógica da Enigma: **uma letra nunca poderia ser criptografada como ela mesma**.

A partir disso, ele utilizou os chamados *cribs* — palavras ou trechos que provavelmente estavam presentes nas mensagens, como previsões do tempo ou expressões comuns. Com base nesses palpites, era possível buscar contradições lógicas e eliminar rapidamente milhares (ou milhões) de combinações inválidas.

---

## Estrutura da máquina Enigma

A máquina era composta por cinco partes principais:

1. Teclado (26 letras)  
2. Plugboard (Steckerbrett) — troca de letras em pares  
3. Rotores — responsáveis pela substituição dinâmica  
4. Refletor — devolve o sinal por um caminho alternativo  
5. Painel de lâmpadas — exibe o resultado criptografado  

---

## Como funciona a criptografia

Exemplo: criptografar a letra “A”

1. **Plugboard**  
Se houver conexão A ↔ M, então “A” se torna “M” antes de entrar nos rotores.

2. **Rotores (ida)**  
O sinal passa pelos rotores, por exemplo: M → Q → T → L  
A cada tecla pressionada, os rotores giram, alterando completamente o resultado seguinte.

3. **Refletor**  
O sinal chega ao refletor: L → G

4. **Rotores (volta)**  
O sinal retorna por outro caminho: G → X → P → C

5. **Plugboard novamente**  
Se houver conexão C ↔ Z, então C → Z

**Resultado final:** A → Z  
Se você digitar “Z” na mesma configuração, a máquina retorna “A”.

---

## O conceito de CRIB

Os criptógrafos perceberam que os alemães utilizavam padrões repetitivos em suas mensagens. Esses padrões eram chamados de *cribs* (palpites estruturados).

Exemplos:
- Relatórios meteorológicos começando com “Wetter”
- Mensagens navais iniciando com “ANX”
- Saudações e estruturas padronizadas

Mesmo sem conhecer a chave, era possível testar esses padrões contra mensagens interceptadas.

---

## Fraqueza da Enigma

Uma das principais vulnerabilidades era justamente a regra de que nenhuma letra poderia se transformar nela mesma.

Se um trecho suspeito fosse alinhado com a mensagem criptografada e apresentasse, por exemplo, W → W ou E → E, aquela configuração era imediatamente descartada.

---

## Cadeias lógicas e a Bombe

Turing explorou relações encadeadas entre letras, formando ciclos lógicos como:

W → X  
X → P  
P → R  
R → W  

A máquina Bombe utilizava circuitos elétricos para testar essas cadeias. Caso surgisse alguma contradição, a configuração era automaticamente eliminada.

Na prática, a Bombe:
- Simulava várias máquinas Enigma simultaneamente  
- Testava rapidamente diferentes posições dos rotores  
- Identificava configurações possíveis (sem contradições)  

Essas configurações ainda precisavam ser verificadas manualmente, mas já reduziam drasticamente o espaço de busca.

---

## Por que foi revolucionário?

Ao invés de testar trilhões de combinações diariamente, a abordagem de Turing reduzia o problema utilizando:

- Padrões humanos repetitivos  
- Erros operacionais  
- Estrutura previsível das mensagens  
- A regra de que nenhuma letra vira ela mesma  

---

## Erros dos alemães

Alguns fatores contribuíram para a quebra da Enigma:

- Protocolos rígidos e previsíveis  
- Estrutura padronizada nas mensagens  
- Repetição de trechos  

---

## Impacto histórico

Estima-se que a quebra da Enigma tenha encurtado a Segunda Guerra Mundial em cerca de dois anos e salvado aproximadamente 14 milhões de vidas.

---

# Gabarito do Questionário

1. C  
2. B  
3. B  
4. B  
5. D  
6. B  
7. C  
8. B  
9. A  
10. B  
11. D  
12. B  
13. B  
14. C  
15. B  
16. C  
17. B  
18. A  
19. B  
20. C  
