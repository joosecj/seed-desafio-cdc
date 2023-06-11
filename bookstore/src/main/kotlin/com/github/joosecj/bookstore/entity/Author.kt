package com.github.joosecj.bookstore.entity

import com.github.joosecj.bookstore.dto.AuthorDTO
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table
class Author(authorDTO: AuthorDTO) {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null
  var name: String? = null
  var email: String? = null
  var description: String? = null
  var registrationDate: LocalDateTime? = null

  init {
    this.name = authorDTO.name
    this.email = authorDTO.email
    this.description = authorDTO.description
    this.registrationDate = LocalDateTime.now()
  }
}