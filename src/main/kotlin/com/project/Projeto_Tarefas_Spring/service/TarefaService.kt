// Define o pacote onde está localizada a classe de serviço.
// O pacote "service" é responsável por conter as regras de negócio da aplicação,
// ou seja, o que acontece entre o controller e o repositório.
package com.project.Projeto_Tarefas_Spring.service

// Importa a classe Tarefa, que é a entidade manipulada.
import com.project.Projeto_Tarefas_Spring.model.Tarefa

// Importa o repositório que faz o acesso ao banco de dados.
import com.project.Projeto_Tarefas_Spring.repository.TarefaRepository

// Importa a anotação @Service, que registra essa classe como um "service" no Spring.
// Isso permite que ela seja injetada em outras classes (como o controller).
import org.springframework.stereotype.Service

// Marca a classe como um service do Spring.
@Service
class TarefaService(

    // Injeta automaticamente uma instância de TarefaRepository via construtor.
    private val repository: TarefaRepository
) {

    // Lista todas as tarefas do banco chamando o método findAll() do repositório.
    fun listarTarefas(): List<Tarefa> = repository.findAll()

    // Busca uma tarefa pelo ID.
    // Se não encontrar, retorna null (utiliza orElse(null) para isso).
    fun buscarTarefaPorId(id: Long): Tarefa? = repository.findById(id).orElse(null)

    // Cria uma nova tarefa no banco (ou atualiza, se já existir).
    fun criarTarefa(tarefa: Tarefa): Tarefa = repository.save(tarefa)

    // Atualiza uma tarefa existente. O método save() também serve para atualizar se o ID estiver presente.
    fun atualizarTarefa(tarefa: Tarefa): Tarefa = repository.save(tarefa)

    // Deleta uma tarefa pelo ID.
    fun deletarTarefa(id: Long) = repository.deleteById(id)
}
