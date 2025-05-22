package ru.totalexx.workservice.service;

import ru.totalexx.workservice.model.Resume;

import java.util.List;

public interface ResumeService {
    List<Resume> getAll();
    Resume getById(Long id);
    void create(Resume resume);
    void update(Resume resume);
    void delete(Long id);
}
