// Define o pacote onde está localizado este repositório.
// Em projetos organizados por camadas, o pacote "repository" é onde ficam as interfaces
// responsáveis por acessar e manipular os dados no banco (persistência).
package com.project.Projeto_Tarefas_Spring.repository

// Importa a classe Tarefa, que é a entidade a ser manipulada pelo repositório.
import com.project.Projeto_Tarefas_Spring.model.Tarefa

// Importa a interface JpaRepository do Spring Data JPA, que já fornece uma série de métodos
// prontos para trabalhar com o banco de dados (como save, findAll, findById, delete etc.).
import org.springframework.data.jpa.repository.JpaRepository

// Define a interface TarefaRepository, que estende JpaRepository.
// Isso transforma essa interface automaticamente em um componente Spring capaz de acessar o banco.
// <Tarefa, Long> significa:
// - Tarefa: o tipo da entidade que será gerenciada.
// - Long: o tipo do campo ID da entidade (neste caso, o "id" da classe Tarefa é do tipo Long).
interface TarefaRepository : JpaRepository<Tarefa, Long>
