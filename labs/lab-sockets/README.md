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
