# SuperMercadoProva
Prova Leonardo Cruz
Fiz oque o enunciado pedia e acrescenteu novas funcionalidades ao programa,abaixo explico com detalhes cada etapa para a conclusao do projeto.

1= bug eh que o item mesmo nao conseguindo dar baixa ele aparece no pedido final e nao pode! 
Para solucionar no metodo Pedido.adicionaItemNaLista() botei um if que pergunta se possuiu a quantidade do produto no estoque.
Antes ele nao descontava do estoque pq não tinha a quantidade minima, mas add no "carrinho de compras" dai o if serve para ele dar
baixa e add no "carrinho de compras" somente se a quantidade que ele quer tenha no estoque. Para isso modifiquei bastante o metodo
Pedido.adicionaItem() pq tinha umas coisas me incomodando e tirei algumas redundanceas pq algumas coisas eu perguntava no Pedido.adicionaItem()
e no Estoque.darBaixaEmEstoque(). Uma coisa que ficou me incomodando depois de corrigido o bug foi o fato de o Pedido.adicionaItem() ter ficado muito
grande, dai não soube dizer se deveria separar os filtros que botei em novos metodos ou deixar como está. Eu decidi em deixar como está pois alguns filtros
encerram o add do item caso alguma informação passada fosse vista como um erro.


2 e 3 =Irei implementar o 2 e 3 juntos num metodo chamado "finalizar compra" e criei um novo chamado "retirar item do carrinho"

*"retira item do carrinho": este novo metodo visa retirar algum item que esta no carrinho. Este metodo é acessivel do menu principal 
 
Add novo metodo que imprime o carrinho de compras, ja existe o imprime pedido, mas acho ele mais valido usar ele ao confirmar o pagamento
Add um metodo que pesquisa se o item que a pessoa escolheu tem na lista de compras(eh igual ao do estoque só que usado na lista de compras) e retorna o item
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
    mas pode ser só o print na tela mesmo que da certo tb 

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




