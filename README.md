# ServletFilter
Servlet Filter Study

1. Criando e entendeo Filter

2. Verificando se a url da requisicao e umas das verificadas, com AntPathMatcher

3. Lendo a ServletRequest antes de chegar ao controller, para comprovar que so pode ser lido 1x quando nao se tem cache

4. Realizando cache da ServletRequest com ContentCachingRequestWrapper, afim de ler mais uma vez, em diferentes pontos do fluxo

5. Recebendo HttpServletRequest em pontos diferentes da aplicacao, para ler a request mais de uma vez.

Obs.: Eu posso receber a instancia do HttpServletRequest da solicitacao em diferentes pontos do fluxo, portanto, posso carregar valores nele em um ponto, para recuperar esses valores em outros pontos, exemplo:

//Recebo o HttpServletRequest da solicitacao no bean e uso:

httpServletRequest.setAttribute("key", Value)
.... 
httpServletRequest.getAttribute("key")

Outras exemplos poderiam ser:

Ex01.: Obtendo o valor de uma QueryString

../produtos?nome=bruno

httpServletRequest.getParameter("nome");
