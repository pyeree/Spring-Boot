package com.group.libraryapp.controller.book;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCotroller {

    private final BookService bookService;

    public BookCotroller(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);
    }

}
