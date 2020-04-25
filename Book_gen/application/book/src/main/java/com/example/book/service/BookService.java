package com.example.book.service;

import com.example.book.domain.Book;
import com.example.book.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @SuppressWarnings("unchecked")
	public List getAllBooks() {
        List books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book getBook(String id) {
        return (Book) bookRepository.findById(id).orElseGet(Book::new);
    }

    @SuppressWarnings("unchecked")
	public void addBook(Book book) {
        bookRepository.save(book);
    }

    @SuppressWarnings("unchecked")
	public void updateBook(String id, Book book) {
        bookRepository.save(book);
    }

    @SuppressWarnings("unchecked")
	public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

}
