package ru.totalexx.workservice.web.api.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.totalexx.workservice.model.Resume;
import ru.totalexx.workservice.service.util.AuthUtils;
import ru.totalexx.workservice.web.api.model.request.resume.CreateResumeRequest;
import ru.totalexx.workservice.web.api.model.request.resume.UpdateResumeRequest;

@Component
public abstract class ResumeMapperDecorator implements ResumeMapper {

    @Autowired
    private AuthUtils authUtils;

    @Override
    public Resume toEntity(CreateResumeRequest request) {
        Resume resume = new Resume();
        resume.setName(request.getName());
        resume.setText(request.getText());
        resume.setUser(authUtils.getCurrentUser());

        return resume;
    }

    @Override
    public Resume toEntity(UpdateResumeRequest request) {
        Resume resume = new Resume();
        resume.setId(request.getId());
        resume.setName(request.getName());
        resume.setText(request.getText());
        resume.setUser(authUtils.getCurrentUser());

        return resume;
    }
}
