package com.project.Projeto_Tarefas_Spring.dto

import java.time.LocalDate

data class TarefaResponseDTO(
    val id: Long?,
    val nomeTarefa: String,
    val descricaoTarefa: String,
    val prioridadeTarefa: String,
    val dataEntrega: LocalDate
)