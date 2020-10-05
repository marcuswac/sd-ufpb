## Questões

Q1) Os dois sistemas (TCP e UDP) são iguais em relação à funcionalidade. Mas, em termos de implementação e garantias existem diferenças. Sobre isso, responda as questões abaixo:

a. O que muda em termos de implementação das primitivas de comunicação usadas no código do cliente/servidor TCP em relação ao do cliente/servidor UDP?

b. O que muda em termos de confiabilidade e desempenho entre os dois sistemas?

c. Considere 3 primitivas de comunicação TCP usadas no exemplo: `accept`, `readUTF` e `writeUTF`. Quais delas são chamadas síncronas e quais são assíncronas? Justifique.

d. Considere 2 primitivas de comunicação UDP usadas no exemplo: `read` e `write`. Quais delas são chamadas síncronas e quais são assíncronas?

----------------

Q2) Tente reproduzir os seguintes passos, para cada um dos sistemas (TCP e UDP):
1. Inicie a execução de um servidor.
2. Inicie a execução de um cliente `C1`, mas não digite a mensagem.
3. Inicie a execução de outro cliente `C2`, digite uma mensagem e tente enviar.
4. Digite a mensagem do cliente `C1` e tente enviar.

Sobre esse teste, responda:

a. Executando apenas os passos de 1 a 3, a mensagem enviada por `C2` é recebida pelo servidor? Responda tanto para o sistema TCP quanto para o UDP, descrevendo uma possível razão disso ter acontecido.

b. Após executar o passo 4, as mensagens enviadas pelos clientes `C1` e `C2` são recebidas pelo servidor? E as respostas chegam aos clientes? Responda tanto para o sistema TCP quanto para o UDP, descrevendo uma possível razão disso ter acontecido.

----------------

Q3) [EXTRA] Modifique o código do cliente e servidor TCP para permitir um bate-papo em linha de comando, onde tanto o servidor quanto o cliente podem digitar mensagens de uma para o outro. Vocês devem continuar usar Sockets para a comunicação baseada em troca de mensagens. Envie aqui na atividade o link para o repositório do github que contém a sua solução (o repositório deve estar público).