package ru.totalexx.workservice.web.api.model.request.vacancy;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddVacancyResponseRequest {
    @NotBlank
    private Long vacancyId;
    @NotBlank
    private Long resumeId;
}
