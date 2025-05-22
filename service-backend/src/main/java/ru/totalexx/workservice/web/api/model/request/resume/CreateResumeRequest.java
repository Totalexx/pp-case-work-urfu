package ru.totalexx.workservice.web.api.model.request.resume;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateResumeRequest {
    private String name;
    private String text;
}
