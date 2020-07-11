package com.tech.mkblogs.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.tech.mkblogs.model.Author;
import com.tech.mkblogs.model.Book;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class TestJPARepositoryNamedEntityGraph {

	@Autowired
	AuthorRepository authorRepository; 
	
	@Before
	public void beforeMethod() {
		log.info("=============================================================");		
	}

	@After
	public void afterMethod() {		
		log.info("=============================================================");
	}

	@Test
	public void selectAuthor() {
		log.info("... selectAuthor ...");		
		Author author = authorRepository.findAuthor(1);
		displayAuthor(author);
	}
	
	@Test
	public void selectWithAuthorOnly() {
		log.info("... selectWithBooksOnly ...");		
		Author author = authorRepository.findBooks(new Integer(1), EntityGraphs.empty());
		displayAuthor(author);
	}
	
	@Test
	public void selectWithBooksUsingNamedEntityGraph() {
		log.info("... selectWithBooksUsingNamedEntityGraph ...");		
		Author author = authorRepository.findBooks(new Integer(1), EntityGraphUtils.fromName("3rdpartygraph.author.books",true));
		displayAuthor(author);
	}
	
	@Test
	public void selectWithBooksPublisherUsingNamedEntityGraph() {
		log.info("... selectWithBooksPublisherUsingNamedEntityGraph...");		
		Author author = authorRepository.findBooks(new Integer(1), EntityGraphUtils.fromName("3rdpartygraph.author.books.publisher",true));
		displayAuthor(author);
	}
	
	protected void displayAuthor(Author author) {
		log.info(author.getFirstName()+" "+author.getLastName()+" wrote "+author.getBooks().size()+" books.");
		Set<Book> books = author.getBooks(); 
		 for(Book book: books) {
			log.info(book.getPublisher()); 
		 }
		
	}
	
}
