// Define o pacote onde está localizada a classe de serviço.
// O pacote "service" é responsável por conter as regras de negócio da aplicação,
// ou seja, o que acontece entre o controller e o repositório.
package com.project.Projeto_Tarefas_Spring.service

// Importa a classe Tarefa, que é a entidade manipulada.
import com.project.Projeto_Tarefas_Spring.dto.TarefaRequestDTO
import com.project.Projeto_Tarefas_Spring.dto.TarefaResponseDTO
import com.project.Projeto_Tarefas_Spring.entity.Tarefa
import com.project.Projeto_Tarefas_Spring.mapper.TarefaMapper

// Importa o repositório que faz o acesso ao banco de dados.
import com.project.Projeto_Tarefas_Spring.repository.TarefaRepository

// Importa a anotação @Service, que registra essa classe como um "service" no Spring.
// Isso permite que ela seja injetada em outras classes (como o controller).
import org.springframework.stereotype.Service

// Marca a classe como um service do Spring.
@Service
class TarefaService(
    // Injeta automaticamente uma instância de TarefaRepository via construtor.
    private val repository: TarefaRepository,
    private val tarefaMapper: TarefaMapper
) {

    // Lista todas as tarefas do banco chamando o método findAll() do repositório.
    fun listarTarefas(): List<TarefaResponseDTO> {
        return repository.findAll().map { tarefaMapper.toDTO(it) }
    }

    // Busca uma tarefa pelo ID.
    // Se não encontrar, retorna null (utiliza orElse(null) para isso).
    fun buscarTarefaPorId(id: Long): TarefaResponseDTO?{
        return repository.findById(id).map { tarefaMapper.toDTO(it) }.orElse(null)
    }

    // Cria uma nova tarefa no banco (ou atualiza, se já existir)
    fun criarTarefa(tarefaRequestDTO: TarefaRequestDTO): TarefaResponseDTO{
        val tarefa = tarefaMapper.toEntity(tarefaRequestDTO)
        val saveTarefa = repository.save(tarefa)
        return tarefaMapper.toDTO(saveTarefa)
    }

    // Atualiza uma tarefa existente. O método save() também serve para atualizar se o ID estiver presente.
    fun atualizarTarefa(id: Long, dto: TarefaRequestDTO): TarefaResponseDTO {
        val tarefaExistente = repository.findById(id).orElseThrow{
            RuntimeException("Tarefa Não Encontrada")
        }

        val tarefaAtualizada = tarefaExistente.copy(
            nomeTarefa = dto.nomeTarefa,
            descricaoTarefa = dto.descricaoTarefa,
            prioridadeTarefa = dto.prioridadeTarefa,
            dataEntrega = dto.dataEntrega
        )

        return tarefaMapper.toDTO(repository.save(tarefaAtualizada))
    }

    // Deleta uma tarefa pelo ID.
    fun deletarTarefa(id: Long){
        if (!repository.existsById(id)){
            throw RuntimeException("Tarefa Não encontrada")
        }
        return repository.deleteById(id)
    }
}
