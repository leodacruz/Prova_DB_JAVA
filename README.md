# SuperMercadoProva
Prova Leonardo Cruz

1= bug eh que o item mesmo nao conseguindo dar baixa ele aparece no pedido final e nao pode! 
Para solucionar no metodo Pedido.adicionaItemNaLista() botei um if que pergunta se possuiu a quantidade do produto no estoque.
Antes ele nao descontava do estoque pq não tinha a quantidade minima, mas add no "carrinho de compras" dai o if serve para ele dar
baixa e add no "carrinho de compras" somente se a quantidade que ele quer tenha no estoque. Para isso modifiquei bastante o metodo
Pedido.adicionaItem() pq tinha umas coisas me incomodando e tirei algumas redundanceas pq algumas coisas eu perguntava no Pedido.adicionaItem()
e no Estoque.darBaixaEmEstoque(). Uma coisa que ficou me incomodando depois de corrigido o bug foi o fato de o Pedido.adicionaItem() ter ficado muito
grande, dai não soube dizer se deveria separar os filtros que botei em novos metodos ou deixar como está. Eu decidi em deixar como está pois alguns filtros
encerram o add do item caso alguma informação passada fosse vista como um erro.


2 e 3 =Irei implementar o 2 e 3 juntos num metodo chamado finalizar compra e criarei um novo chamado "retirar item do carrinho"
"retira item do carrinho" este novo metodo visa retirar algum item que esta no carrinho. Este metodo é acessivel do menu principal e tb na hora de 
finalizar o pagamento caso a pessoa nao informou uma quantidade o suficiente para pagar,dai tera a opcao dela retirar item ou inserir nova forma de 
pagamento





Modificaccoees alem do pedido no enunciado:

*botar a opcao de retirar item do carrinho

*botar try e catch para excecoees ao informar 
quantidade dos produtos, no menu tb da esse erro

*botei um comentario em todos os metodos para saber oq eles fazem




