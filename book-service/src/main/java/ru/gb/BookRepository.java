package ru.gb;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;
import ru.gb.timer.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Timer
public class BookRepository {

    private final Faker faker;
    private final List<Book> books;

    public BookRepository() {
        this.faker = new Faker();
        this.books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setName(faker.book().title());
            Author author = new Author();
            author.setId(UUID.randomUUID());
            author.setFirstName(faker.name().firstName());
            author.setLastName(faker.name().lastName());
            book.setAuthor(author);
            books.add(book);
        }
    }
    public List<Book> getAllBooks() {
        return List.copyOf(this.books);
    }
    public Book getRandomBook() {
        final int randomIndex = faker.number().numberBetween(0, this.books.size());
        return this.books.get(randomIndex);
    }

}
