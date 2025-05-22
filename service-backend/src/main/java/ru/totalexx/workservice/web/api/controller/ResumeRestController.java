package ru.totalexx.workservice.web.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.totalexx.workservice.model.Resume;
import ru.totalexx.workservice.service.ResumeService;
import ru.totalexx.workservice.web.api.model.mapper.ResumeMapper;
import ru.totalexx.workservice.web.api.model.request.resume.CreateResumeRequest;
import ru.totalexx.workservice.web.api.model.request.resume.UpdateResumeRequest;
import ru.totalexx.workservice.web.api.model.response.resume.ResumeListResponse;
import ru.totalexx.workservice.web.api.model.response.resume.ResumeResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resume")
@RequiredArgsConstructor
public class ResumeRestController {

    private final ResumeService resumeService;
    private final ResumeMapper resumeMapper;

    @GetMapping("get/all")
    public ResumeListResponse getAll() {
        List<Resume> resumes = resumeService.getAll();
        return resumeMapper.toResponseList(resumes);
    }

    @GetMapping("get/{id}")
    public ResumeResponse getById(@PathVariable Long id) {
        Resume resume = resumeService.getById(id);
        return resumeMapper.toResponse(resume);
    }

    @PostMapping("create")
    public ResponseEntity<Void> create(@Valid CreateResumeRequest request) {
        Resume resume = resumeMapper.toEntity(request);
        resumeService.create(resume);

        return ResponseEntity.ok().build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> update(@Valid UpdateResumeRequest request) {
        Resume resume = resumeMapper.toEntity(request);
        resumeService.update(resume);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        resumeService.delete(id);

        return ResponseEntity.ok().build();
    }
}
