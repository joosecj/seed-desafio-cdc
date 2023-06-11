package com.github.joosecj.bookstore.controller

import com.github.joosecj.bookstore.dto.AuthorDTO
import com.github.joosecj.bookstore.entity.Author
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/authors")
class AuthorController {

  @Autowired
  lateinit var entityManager: EntityManager

  @PostMapping
  @Transactional
  fun create(@RequestBody dto: AuthorDTO): ResponseEntity<AuthorDTO> {
    val entity = Author(dto)
    entityManager.persist(entity)
    val dto = AuthorDTO(entity)
    return ResponseEntity.ok(dto)
  }

}