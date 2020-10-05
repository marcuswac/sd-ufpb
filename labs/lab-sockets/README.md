# Prática: Sockets TCP e UDP

## Pré-requisitos

- `git`
- Java 8+ (JDK)

## Início

Investigue os códigos dos clientes e servidores TCP e UDP. Em seguida, execute os códigos e entenda o que está acontecendo.

O código está localizado no diretório `src` e os executáveis no diretório `bin`. Se precisar recompilar o código na interface de linha de comando, entre no diretório raíz do projeto e execute o comando abaixo:

```
javac src/* -d bin
```

OBS: se não funcionar no Windows, tente substituir a barra (`/`) por contra-barra (`\`).

As implementações do sistema TCP e UDP não se comunicam e são dois sistemas diferentes. Quando for realizar os testes, rode o sistema de um protocolo de cada vez. O cliente TCP só fala com o servidor TCP e o cliente UDP só fala com o servidor UDP. Além disso, sempre rode o servidor antes de rodar seus clientes.


## Exemplo Socket TCP

O exemplo de socket TCP possui dois arquivos: `SimpleTCPServer.java` e `SimpleTCPClient.java`. Analise o código das duas classes e em seguida execute o exemplo, rodando primeiro o servidor e depois o cliente.

Para executar o servidor TCP na linha de comando, rode:

```
java -cp bin SimpleTCPServer
```

Para executar o cliente TCP na linha de comando, rode:

```
java -cp bin SimpleTCPClient
```

Em seguida, digite na linha de comando do cliente a mensagem que desejar enviar para o servidor e veja o que acontece. Analise novamente o código para identificar cada passo do que acontece.

## Exemplo Socket UDP

O exemplo de socket UDP possui dois arquivos: `SimpleUDPServer.java` e `SimpleUDPClient.java`. Analise o código das duas classes e em seguida execute o exemplo, rodando primeiro o servidor e depois o cliente.

Para executar o servidor UDP na linha de comando, rode:

```
java -cp bin SimpleUDPServer
```

Para executar o cliente UDP na linha de comando, rode:

```
java -cp bin SimpleUDPClient
```

Em seguida, digite na linha de comando do cliente a mensagem que desejar enviar para o servidor e veja o que acontece. Analise novamente o código para identificar cada passo do que acontece.

Explore diferentes situações, por exemplo, você pode rodar mais de um cliente ao mesmo tempo para ver se o servidor consegue receber conexões e mensagens simultâneas de clientes.


## Questões (Moodle)

----------------

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


Q3) [EXTRA] Modifique o código do cliente e servidor TCP para permitir um bate-papo em linha de comando, onde tanto o servidor quanto o cliente podem digitar mensagens de uma para o outro. Vocês devem continuar usar Sockets para a comunicação baseada em troca de mensagens. Envie aqui na atividade o link para o repositório do github que contém a sua solução (o repositório deve estar público).