// Define o pacote raiz da aplicação.
// Todas as outras classes devem estar dentro desse pacote ou em subpacotes,
// para que o Spring consiga escanear e configurar corretamente os componentes.
package com.project.Projeto_Tarefas_Spring

// Importa a anotação que marca esta classe como a principal aplicação Spring Boot.
// Ela habilita o componente scan, auto configuração e configura o contexto da aplicação.
import org.springframework.boot.autoconfigure.SpringBootApplication

// Importa a função que executa a aplicação Spring Boot.
import org.springframework.boot.runApplication

// Marca esta classe como a aplicação principal do Spring Boot.
// Essa anotação combina: @Configuration, @EnableAutoConfiguration e @ComponentScan.
// Ou seja, configura a aplicação e faz o Spring escanear todos os beans (componentes, services, controllers etc.).
@SpringBootApplication
class ProjetoTarefasSpringApplication

// Função principal (main) da aplicação, ponto de entrada.
// Aqui a aplicação Spring Boot é inicializada chamando runApplication, que sobe o servidor (por padrão, Tomcat).
fun main(args: Array<String>) {
	runApplication<ProjetoTarefasSpringApplication>(*args)
}
