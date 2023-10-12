# algoritimos-e-estrutura-de-dados

-- Busca binária:
  - PRÉ REQUISITO: A lista estar ordenada;
  - Seu pior tempo de execução, é O(log2n)
    - Onde O(log2n) significa que é TEMPO LOGARITMO.
    - Onde n é o tamanho da lista.
  - Seu melhor tempo é O(1).
  - RESUMO da API
    - A cada request, é criada uma lista com 2 milhões de itens
    - No melhor tempo da busca constante(busca constante é quando percorre a lista do começo ao fim), a busca binária leva 2ms para o tempo de pesquisa. Quando acontece ao contrário, ou seja, no pior cenário para a busca constante, a busca constante chega a levar 35ms, enquanto a busca binária é no máximo 1ms.
  - OBS: A lista é criada a toda request, para não ficar na memória da app.