package ru.totalexx.workservice.web.api.model.response.resume;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeResponse {
    private Long id;
    private String name;
    private String text;
}
