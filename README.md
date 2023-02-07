# SuperMercadoProva
Prova Leonardo Cruz

1= bug eh que o item mesmo nao conseguindo dar baixa ele aparece no pedido final e nao pode
para resolver pergunto antes de dar baixa se a quantidade requisitada e menor do que tem no estoque
mudei o Esoque.darBaixa para retornar tipo boolean assim ele afirma 
pergunto se o produto tem no estoque antes mesmo de informar uma quantidade no adicionaItem()
arrumei todo o adicionaItem() para algo mais correto
caso o usuario digite um valor invalido para o scanner ele volta pro menu principal
tirei o produto.getNome().equalsIgnoreCase(nome) pq ja tinha no estoque dai o nome que chega ja esta formatado corretamente
Como estava fazendo a pergunta dentro do pedido era redundancia fazela novamente dentro do estoque,assim os metodos do estoque
de dar baixa foram simplificados
bug resolvido,agora comecar o restante





Modificaccoees alem do pedido no enunciado:

*botar a opcao de retirar item do carrinho

*botar try e catch para excecoees ao informar 
quantidade dos produtos no menu tb da esse erro

*botei um comentario em todos os metodos para saber oq eles fazem



