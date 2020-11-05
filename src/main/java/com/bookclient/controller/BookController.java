package com.bookclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookclient.model.Book;
import com.bookclient.service.BookServiceImpl;

@Controller
public class BookController {

	@Autowired
    private BookServiceImpl bookService;
	
    @GetMapping("/books")
    public String books(Model model) {
    	List<Book> books = bookService.getAll();
        model.addAttribute("books", books);

        return "books"; //view
    }
	
}
