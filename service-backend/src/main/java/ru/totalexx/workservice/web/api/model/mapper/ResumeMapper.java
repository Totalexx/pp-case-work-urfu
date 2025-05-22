package ru.totalexx.workservice.web.api.model.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.workservice.model.Resume;
import ru.totalexx.workservice.web.api.model.request.resume.CreateResumeRequest;
import ru.totalexx.workservice.web.api.model.request.resume.UpdateResumeRequest;
import ru.totalexx.workservice.web.api.model.response.resume.ResumeListResponse;
import ru.totalexx.workservice.web.api.model.response.resume.ResumeResponse;

import java.util.List;

@DecoratedWith(ResumeMapperDecorator.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResumeMapper {
    default ResumeListResponse toResponseList(List<Resume> resumes) {
        return new ResumeListResponse(resumes.stream()
                .map(this::toResponse)
                .toList());
    }

    ResumeResponse toResponse(Resume resume);

    Resume toEntity(CreateResumeRequest resume);

    Resume toEntity(UpdateResumeRequest request);
}
