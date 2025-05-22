package ru.totalexx.workservice.web.api.model.request.vacancy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddVacancyResponseRequest {
    private Long vacancyId;
    private Long resumeId;
}
