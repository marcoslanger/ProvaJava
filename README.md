# Prova Java
<b>Codigo Fonte da Prova Java</b>

Projeto GerenciarCampanhas com o codigo da resolução das questões 1 e 2. <br>
Projeto LocalizarVogal com o codigo fonte da resolução da questão 3.

<br>
<b>Resposta da Questão 4:</b>


DEADLOCK

1 - O QUE É?

Quando um programa ou aplição java que possui em sua concepção a utilização de "multithreading" (pequenos processos concorrentes na utilização da cpu) muitas vezes por falhas na codificação, essas threads podem entrar em estado de solicitação de uso da cpu (lock) ao mesmo tempo, causando um "impedimento" ou deadlock, de forma que nenhuma thread será processada e a aplicação ficará "travada" ou ocorrerá um "crash" ou falha da aplicação toda.
Outra estado de deadlock, é quando uma thread fica aguardando o fim do processamento de outra ou o retorno de um evento lançado por outra thread, tendo o mesmo efeito de impedimento.

2 - CAUSAS

falhas na codificação definindo prioridades para execução nas threads e seu devido controle de lock, podem causar que duas ou mais threads conflitem na solicitação do processamento pela cpu, causando assim o deadlock.

3 - TRATAMENTOS

As formas usuais de se evitar a ocorrência de deadlock é usar na codificação as seguintes técnicas conforme possível:

Evitar sobreposição de locks através do devido ordenamento de lock durante a codificação das threads;
Codificar um timeout para threads concorrentes a fim de que uma não espere eternamente pelo fim ou retorno da outra;
Quando as tecnicas anteriores não forem possíveis ou a arquitetura da aplicação não permitir utilizar SingleThread para execução da aplicação.


<b>Resposta da Questão 5:</b>


PARALLEL STREAMS

1 - O QUE É?

A utulização da operação parallelStream no processamento de coleções, pode eventualmente ajudar na performance do processamento da coleção em questão. A operação parallelStream tenta otimizar o processamento utilizando-se melhor dos núcleos disponíveis na CPU de forma a tornar o processamento paralelo.<br>
Mas a sua utilização nem sempre pode resultar em um aumento de performance, visto que alguns fatores podem influenciar, podendo até ter impacto negativo na performance.

2 - QUANDO UTILIZAR?

Antes de tudo, somente se existir um problema real de performance;

Quando a coleção possuir uma quantidade massiva de itens a serem tratados e/o processamento de cada item consumir tempo, havará ganho se o processamento for paralelizado;

Quando o processamento não não estiver sendo executado dentro de um ambiente multi-thread como um container web. Se várias requisições forem feitas para serem processadas em paralelo, a adição de mais uma camada de paralelismo irá ter um impacto negativo na performance.


