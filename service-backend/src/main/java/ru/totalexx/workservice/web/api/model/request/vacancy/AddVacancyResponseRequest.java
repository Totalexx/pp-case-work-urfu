package ru.totalexx.workservice.web.api.model.request.vacancy;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddVacancyResponseRequest {
    @NotNull
    private Long vacancyId;
    @NotNull
    private Long resumeId;
}
