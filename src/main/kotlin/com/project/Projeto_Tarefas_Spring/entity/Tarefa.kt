package com.project.Projeto_Tarefas_Spring.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

// Indica que esta classe é uma entidade JPA, ou seja, ela será mapeada para uma tabela no banco de dados.
@Entity
data class Tarefa (

    // Indica que este campo é a chave primária da tabela.
    @Id

    // Especifica que o valor do ID será gerado automaticamente pelo banco de dados.
    // A estratégia IDENTITY faz com que o banco gere um ID incremental.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    // Campo nomeTarefa: representa o nome da tarefa. Será uma coluna no banco de dados.
    val nomeTarefa: String,

    // Campo descricaoTarefa: representa a descrição da tarefa. Também vira uma coluna.
    val descricaoTarefa: String,

    // Campo prioridadeTarefa: representa a prioridade da tarefa (ex: alta, média, baixa).
    val prioridadeTarefa: String,

    // Campo dataEntrega: representa a data de entrega da tarefa. Usando o tipo LocalDate.
    val dataEntrega: LocalDate,
)

