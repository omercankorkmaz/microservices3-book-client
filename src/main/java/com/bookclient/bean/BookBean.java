package com.bookclient.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bookclient.model.Book;
import com.bookclient.service.BookServiceImpl;

@Controller("bookBean")
public class BookBean implements Serializable {

	private static final long serialVersionUID = 1880084445402500735L;
	
	@Autowired
    private BookServiceImpl bookService;
	
	private String message = "Hello, is there anyone ?";
	private List<Book> books;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Book> getBooks() {
		books = bookService.getAll();
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
