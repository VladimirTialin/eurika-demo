package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.timer.Timer;

import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/issue")
@Timer
public class IssueController {

    private final IssueRepository issueRepository;

    @GetMapping
    public List<Issue> getAll() {
        return issueRepository.getAllIssues();
    }
}
