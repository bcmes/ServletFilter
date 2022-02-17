package com.github.bcmes.demo.infrastructure

import org.springframework.context.annotation.Configuration
import javax.servlet.*

@Configuration
class ServletFilter() : Filter {

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

        chain?.doFilter(req, res)
    }

    override fun destroy() {
        super.destroy()
        println("====> destroy() <====")
        println("Chamado uma vez ao deletar o filtro.")
        println("====> destroy() <====")
    }

}