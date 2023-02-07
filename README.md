# SuperMercadoProva
Prova Leonardo Cruz
Fiz oque o enunciado pedia e acrescenteu novas funcionalidades ao programa,abaixo explico com detalhes cada etapa para a conclusao do projeto.

**Funcionalidades novas:
-Retirar item do carrinho
-Finalizar pedido
-secreta Mostrar historico de compras(No menu escolha a opcao 99)

Resolucao dos problemas:
*******1= bug era que o item mesmo nao conseguindo dar baixa ele aparece no pedido final e nao pode! 
Para solucionar no metodo Pedido.adicionaItemNaLista() botei um if que pergunta se possuiu a quantidade do produto no estoque.
Antes ele nao descontava do estoque pq nao tinha a quantidade minima, mas add no "carrinho de compras" dai o if serve para ele dar
baixa e add no "carrinho de compras" somente se a quantidade que ele quer tenha no estoque. Para isso modifiquei bastante o metodo
Pedido.adicionaItem() pq tinha umas coisas me incomodando e tirei algumas redundanceas pq algumas coisas eu perguntava no Pedido.adicionaItem()
e no Estoque.darBaixaEmEstoque(). Uma coisa que ficou me incomodando depois de corrigido o bug foi o fato de o Pedido.adicionaItem() ter ficado muito
grande, dai nÃ£o soube dizer se deveria separar os filtros que botei em novos metodos ou deixar como estah. Eu decidi em deixar como estah, pois alguns filtros
encerram o add do item caso alguma informacao passada fosse vista como um erro.

*******2 e 3 =Irei implementar o 2 e 3 juntos num metodo chamado "finalizar compra" 
Finalizar compra: este metodo esta dentro de Pedido e tem a funcionalidade de finalizar uma compra.
De inicio mostra duas opcoes ao usuario:
1= informar cpf;
2= nao informar;
Apos mostra duas opcoes de PAGAMENTO(ITEM 2 E 3 DO ENUNCIADO)
1=pagar com credito (NOVO)
2=pagar com DINHEIRO (ITEM 2 E 3 DO ENUNCIADO)

ao escolher alguma opcao ele trata elas em um metodo;
Depois de finalizado o pagamento , se salva as informações num Array de Clientes que esta dentro
da Classe Pedido, isso para o menu secreto.

Agora explicação de todas as modificações nas classes:
**Cliente : Agora a classe Cliente salva as informações de um pedido. Anteriormente ela noa era usada
em nada e agora tem a funcionalidade de salvar informações das compras deste cliente. Tinha pensando
em criar uma nova classe chamada "nota fiscal" para isso, mas resolvi implementar assim.

**Estoque : não fiz nenhuma grande alteração, mas tirei algumas redundancias. Essa que estavam nos metodos
 darBaixaEmEstoque() nas duas versoes. Anteriormente essa redundancias nao existiam, mas apos corrigir o bug
 elas apareceram pois estava repetindo as mesmas perguntas que ja tinha perguntando em Pedido.adicionaItemNaLista e
 Pedido.adicionaItem. 

**Item : nao mexi

**Main : nao mexi

*Menu : alem de add as novas implementacoes, botei um tratamento de excessoes. E





****Coisas que fiz bastante: 
-Tratei excecoes.




*"retira item do carrinho": este novo metodo visa retirar algum item que esta no carrinho. Este metodo Ã© acessivel do menu principal 
 
Add novo metodo que imprime o carrinho de compras, ja existe o imprime pedido, mas acho ele mais valido usar ele ao confirmar o pagamento
Add um metodo que pesquisa se o item que a pessoa escolheu tem na lista de compras(eh igual ao do estoque sÃ³ que usado na lista de compras) e retorna o item
criei um metodo no Estoque para repor o esoque de um produto que foi devolvido, ele precisa de um Item como parametro

*finalizarCompra() = como funciona:
    mostar o carrinho e perguntar se quer finalizar a compra
 deixe ele se identificar caso queira(Gerar nota fiscal-opcao secreta numero 99)
    duas opcoes voltar e finalizar compra
    metodo de pagamento 
    cartao de credito ou dinheiro
    cartao de credito eh permitido parcelar mas dependendo da quantidade possuiu juros
    tabela de juros
    ate 200 3x sem juros; max limite de parcelas
    ate 400 6x sem juros; 8x com juros 10% do valor 
    ate 600 8 sem juros;10x com juros 10% do valor
    acima de 600 10x sem juros;12 com juros 10% valor

    apos finalizar a compra aparece a nota fiscal (dai sim usa o imprimePedido)
    apos finalizar a compra salva a nota fiscal e limpa a lista de compras
    talvez criar o metodo de salvar um arquivo como nota fiscal mesmo, acho que seria legal
    mas pode ser sÃ³ o print na tela mesmo que da certo tb 

    deixar uma opcao secreta que aparece as vendas de todos os clientes do dia

    na opcao de pagar com dinheiro
    se a pessoa dar um valor maior que o preco final devolver o troco certinho
    se a pessoa dar um valor inferior,oferecer tres opcoes de retirar um item do
    carrinho, voltar para formas de pagamento e cancelar compra(limpa o carrinho)

cliente agora tem duas coisas novas, duas variaveis uma Item e outra String,ambas para salvar
os dados da compra daquele cliente lista de clientes esta em pedidos
crei um classe para salvar as notas fiscais,acho melhor que fazer tudo em cliente



Modificacoes alem do pedido no enunciado:

*botar a opcao de retirar item do carrinho

*botar try e catch para excecoees ao informar 
quantidade dos produtos, no menu tb da esse erro

*botei um comentario em todos os metodos para saber oq eles fazem 

*opcao secreta que mostra todos os pedidos feitos,para isso no menu escreva o 
numero 99 que ele mostra esta tela especial




