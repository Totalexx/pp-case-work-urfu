package ru.totalexx.workservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.workservice.exception.ServiceException;
import ru.totalexx.workservice.model.Resume;
import ru.totalexx.workservice.repository.ResumeRepository;
import ru.totalexx.workservice.service.ResumeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    @Override
    public List<Resume> getAll() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume getById(Long id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Резюме не найдено"));
    }

    @Override
    public void create(Resume resume) {
        resumeRepository.save(resume);
    }

    @Override
    public void update(Resume resume) {
        resumeRepository.save(resume);
    }

    @Override
    public void delete(Long id) {
        if (!resumeRepository.existsById(id)) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "Резюме не найдено");
        }

        resumeRepository.deleteById(id);
    }
}
