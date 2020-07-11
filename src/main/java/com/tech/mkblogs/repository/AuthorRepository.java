package com.tech.mkblogs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.tech.mkblogs.model.Author;

@Repository
public interface AuthorRepository extends EntityGraphJpaRepository<Author, Integer> {

	
	@Query("SELECT author FROM Author author WHERE author.id = :id ")
	Author findAuthor(@Param("id")  Integer id);
	
	@Query("SELECT author FROM Author author WHERE author.id = :id ")
	Author findBooks(@Param("id")  Integer id,EntityGraph entityGraph);
	
	
	 
}
