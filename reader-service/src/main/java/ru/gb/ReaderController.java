package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.timer.Timer;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    private final ReaderRepository readerRepository;
@Timer
    @GetMapping
    public List<Reader> getAll() {
        return readerRepository.getAllReaders();
    }
@Timer
    @GetMapping("/random")
    public Reader getRandom() {
        return  readerRepository.getRandomReader();
    }

}
