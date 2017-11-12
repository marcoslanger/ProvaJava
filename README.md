# ProvaJava
Codigo Fonte da Prova Java

Projeto GerenciarCampanhas com o codigo da resolução das questões 1 e 2.
Projeto LocalizarVogal com o codigo fonte da resolução da questão 3.


DEADLOCK

1 - O QUE É?

Quando um programa ou aplição java que possui em sua concepção a utilização de "multithreading" (pequenos processos concorrentes na utilização da cpu) muitas vezes por falhas na codificação, essas threads podem entrar em estado de solicitação de uso da cpu (lock) ao mesmo tempo, causando um "impedimento" ou deadlock, de forma que nenhuma thread será processada e a aplicação ficará "travada" ou ocorrerá um "crash" ou falha da aplicação toda.
Outra estado de deadlock, é quando uma thread fica aguardando o fim do processamento de outra ou o retorno de um evento lançado por outra thread, tendo o mesmo efeito de impedimento.

2 - CAUSAS

falhas na codificação definindo prioridades para execução nas threads e seu devido controle de estados, podem causar que duas ou mais threads conflitem na solicitação do processamento pela cpu, causando assim o deadlock.

3 - TRATAMENTOS

As formas usuais de se evitar a ocorrência de deadlock é usar na codificação as seguintes técnicas conforme possíve:

Evitar sobreposição de locks através do devido ordenamento de lock durante a codificação das threads;
Codificar um timeout para threads concorrentes a fim de que uma não espere eternamente pelo fim ou retorno da outra;
Quando as tecnicas anteriores não for possível ou a arquitetura da aplicação não permitir utilizar SingleThread para execução da aplicação.

Resposta da Questão 5:

PARALLEL STREAMS

1 - O QUE É?

A utulização da operação parallelStream no processamento de coleções, pode eventualmente ajudar na performance do processamento da coleção em questão. A operação parallelStream tenta otimizar o processamento utilizando-se melhor dos núcleos disponíveis na CPU de forma paralela.

I have a massive amount of items to process (or the processing of each item takes time and is parallelizable)
I have a performance problem in the first place
I don't already run the process in a multi-thread environment (for example: in a web container, if I already have many requests to process in parallel, adding an additional layer of parallelism inside each request could have more negative than positive effects)

Mas a sua utilização nem sempre pode resultar em um aumento de performance, visto que alguns fatores podem influenciar, podendo até tendo impacto negativo na performance.

2 - QUANDO UTILIZAR?

Quando existir um problema real de performance em primeira lugar;

Quando a coleção possuir uma quantidade massiva de itens a serem tratados e/o processamento de cada item consumir tempo, havará ganho se o processamento for paralelizado;

Quando o processamento não não estiver sendo executado dentro de um ambiente multi-thread como um container web. Se várias requisições forem feitas para serem processadas em paralelo, a adição de mais uma camada de paralelismo irá ter um impacto negativo na performance.


