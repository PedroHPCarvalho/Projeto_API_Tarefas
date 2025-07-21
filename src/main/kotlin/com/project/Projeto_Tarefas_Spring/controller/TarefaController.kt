// Define o pacote onde esta classe está localizada.
// Isso ajuda a organizar melhor o projeto em camadas (ex: controller, service, model etc.)
package com.project.Projeto_Tarefas_Spring.controller

// Importa o modelo Tarefa, que representa a entidade de dados.
import com.project.Projeto_Tarefas_Spring.entity.Tarefa

// Importa o serviço que contém a lógica de negócios relacionada às tarefas.
import com.project.Projeto_Tarefas_Spring.service.TarefaService

// Importa as anotações do Spring Boot que permitem mapear rotas HTTP e vincular dados de requisição.
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// Indica que esta classe é um controlador REST, ou seja, ela lida com requisições HTTP e retorna JSON.
@RestController

// Define o prefixo "/tarefas" para todas as rotas deste controller.
@RequestMapping("/tarefas")
class TarefaController(

    // Injeta automaticamente uma instância de TarefaService via construtor.
    private val service: TarefaService
) {

    // Mapeia requisições GET para /tarefas.
    // Retorna uma lista de todas as tarefas chamando o método listarTarefas() do service.
    @GetMapping
    fun listar(): List<Tarefa> = service.listarTarefas()

    // Mapeia requisições GET para /tarefas/{id}.
    // Usa @PathVariable para extrair o ID da URL.
    // Retorna a tarefa correspondente ao ID, ou null se não encontrada.
    @GetMapping("/{id}")
    fun buscar(@PathVariable id: Long): Tarefa? = service.buscarTarefaPorId(id)

    // Mapeia requisições POST para /tarefas.
    // Usa @RequestBody para extrair os dados da tarefa enviados no corpo da requisição.
    // Cria uma nova tarefa chamando o método criarTarefa() do service.
    @PostMapping
    fun criar(@RequestBody tarefa: Tarefa): Tarefa = service.criarTarefa(tarefa)

    // Mapeia requisições PUT para /tarefas/{id}.
    // Atualiza uma tarefa existente com base no ID informado e nos dados do corpo da requisição.
    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody tarefa: Tarefa): Tarefa {
        // Garante que o ID da tarefa a ser atualizada seja o mesmo da URL.
        tarefa.id = id
        return service.atualizarTarefa(tarefa)
    }

    // Mapeia requisições DELETE para /tarefas/{id}.
    // Deleta a tarefa com o ID fornecido chamando o método deletarTarefa() do service.
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) = service.deletarTarefa(id)
}
