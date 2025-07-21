package com.project.Projeto_Tarefas_Spring.mapper

import com.project.Projeto_Tarefas_Spring.dto.TarefaRequestDTO
import com.project.Projeto_Tarefas_Spring.dto.TarefaResponseDTO
import com.project.Projeto_Tarefas_Spring.entity.Tarefa
import org.springframework.stereotype.Component

@Component
class TarefaMapper {

    fun toEntity (dto: TarefaRequestDTO): Tarefa{
        return Tarefa(
            id = null,
            nomeTarefa = dto.nomeTarefa,
            descricaoTarefa = dto.descricaoTarefa,
            prioridadeTarefa = dto.prioridadeTarefa,
            dataEntrega = dto.dataEntrega
        )
    }

    fun toDTO (tarefa: Tarefa): TarefaResponseDTO{
        return TarefaResponseDTO(
            id = tarefa.id!!, // usa !! porque assumimos que se existe Car, o id já foi salvo
            nomeTarefa = tarefa.nomeTarefa,
            descricaoTarefa = tarefa.descricaoTarefa,
            prioridadeTarefa = tarefa.prioridadeTarefa,
            dataEntrega = tarefa.dataEntrega
        )
    }

}