package ru.gb;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ReaderRepository {

    private final Faker faker;
    private final List<Reader> readers;

    public ReaderRepository() {
        this.faker = new Faker();
        this.readers = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Reader reader = new Reader();
            reader.setId(UUID.randomUUID());
            reader.setFirstName(faker.name().firstName());
            reader.setLastName(faker.name().lastName());

            this.readers.add(reader);
        }
    }

    public List<Reader> getAllReaders() {
        return List.copyOf(this.readers);
    }

    public Reader getRandomReader() {
        final int randomIndex = faker.number().numberBetween(0, this.readers.size());
        return this.readers.get(randomIndex);
    }

}
