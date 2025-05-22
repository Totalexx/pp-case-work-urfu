package ru.totalexx.workservice.web.api.model.response.resume;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResumeListResponse {
    List<ResumeResponse> resumes;
}


