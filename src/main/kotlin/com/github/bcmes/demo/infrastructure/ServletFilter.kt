package com.github.bcmes.demo.infrastructure

import org.springframework.context.annotation.Configuration
import org.springframework.util.AntPathMatcher
import org.springframework.web.util.ContentCachingRequestWrapper
import java.util.stream.Collectors
import javax.servlet.*
import javax.servlet.http.HttpServletRequest

@Configuration
class ServletFilter(
    private val routes: List<String> = listOf("/v1/people", "/v1/people/{id}"),
    private val matcher: AntPathMatcher = AntPathMatcher()
) : Filter {

    override fun init(filterConfig: FilterConfig?) {
        super.init(filterConfig)
        println("====> init(FilterConfig?) <====")
        println("Chamado uma vez ao registrar o filtro.")
        println("====> init(FilterConfig?) <====")

    }

    override fun doFilter(req: ServletRequest?, res: ServletResponse?, chain: FilterChain?) {
        println("====> doFilter(ServletRequest?, ServletResponse?, FilterChain?) <====")
        println("E chamado pelo container cada vez que uma request/response e passada pela cadeia, " +
                "devido uma solicitacao do cliente, para um recurso no final da cadeia.\n" +
                "O FilterChain passado para esse metodo permite que o Filter passe a solicitacao" +
                " e a resposta para a proxima entidade na cadeia, atraves do chain?.doFilter(req, res).")
        println("====> doFilter(ServletRequest?, ServletResponse?, FilterChain?) <====")

        //Analise 1:
        //Verifica se a rota chamada e uma das listadas acima
        //val request = req as HttpServletRequest
        //val bool = routes.any { route -> matcher.match(route, request.requestURI) }
        //println("===>$bool<===")
        //Passa a request/response para a proxima entidade na cadeia
        //chain?.doFilter(req, res)

        //Analise 2:
        //O getReader() so pode ser executado uma unica vez por request para ler o conteudo,
        //se precisar ler o conteudo da request mais de uma vez, rode a rotina de cache para request da sessao.
        //O erro disparado e java.lang.IllegalStateException
        //No exemplo abaixo eu leio o conteudo e passo a requisicao para frente, quando ela for ser lida para inflar o
        //objeto do controller, ela dara erro, pois ja foi lida.
        val x = req?.reader?.lines()?.collect(Collectors.joining(System.lineSeparator()))
        println(x)
        chain?.doFilter(req, res)
    }

    override fun destroy() {
        super.destroy()
        println("====> destroy() <====")
        println("Chamado uma vez ao deletar o filtro.")
        println("====> destroy() <====")
    }

}