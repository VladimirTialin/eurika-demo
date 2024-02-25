package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.Timer.Timer;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAll() {
        return bookRepository.getAllBooks();
    }

    @GetMapping("/random")
    public Book getRandom() {
        return  bookRepository.getRandomBook();
    }

}

