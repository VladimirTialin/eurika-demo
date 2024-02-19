package ru.gb;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/issue")
public class IssueController {

    private final IssueRepository issueRepository;

    @GetMapping
    public List<Issue> getAll() {
        return issueRepository.getAllIssues();
    }

}
