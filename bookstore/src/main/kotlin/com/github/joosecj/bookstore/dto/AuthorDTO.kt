package com.github.joosecj.bookstore.dto

import com.github.joosecj.bookstore.entity.Author
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime


data class AuthorDTO(
  var id: Long? = null,
  @NotBlank
  var name: String? = null,
  @Email
  var email: String? = null,
  @Length(max = 400)
  @NotBlank(message = "Description is required")
  var description: String? = null,
  var registrationDate: LocalDateTime? = null
) {
  constructor(entity: Author) : this(
    id = entity.id,
    name = entity.name,
    email = entity.email,
    description = entity.description,
    registrationDate = entity.registrationDate
  )
}