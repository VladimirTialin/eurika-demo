package ru.gb;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;
import ru.gb.timer.Timer;
import ru.gb.service.BookProvider;
import ru.gb.service.ReaderProvider;

import java.time.ZoneId;
import java.util.*;

@Repository
@Timer
public class IssueRepository {
    private final List<Issue> issues;
    public IssueRepository(BookProvider bookProvider, ReaderProvider readerProvider) {
        this.issues = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());
            Date between = faker.date().between(startOfYear(), endOfYear());
            issue.setIssuedAt(between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            issue.setBook(bookProvider.getRandomBook());
            issue.setReader(readerProvider.getRandomReader());
            issues.add(issue);
        }
    }

    private Date startOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.JANUARY);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        return instance.getTime();
    }

    private Date endOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.DECEMBER);
        instance.set(Calendar.DAY_OF_MONTH, 31);
        return instance.getTime();
    }

    public List<Issue> getAllIssues() {
        return List.copyOf(this.issues);
    }

}