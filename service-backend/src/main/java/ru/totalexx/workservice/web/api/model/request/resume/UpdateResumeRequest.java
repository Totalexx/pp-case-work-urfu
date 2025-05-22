package ru.totalexx.workservice.web.api.model.request.resume;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResumeRequest {
    @NotNull
    private Long id;

    @NotBlank(message = "Название резюме не должно быть пустым")
    private String name;

    @NotBlank(message = "Текст резюме не должен быть пустым")
    private String text;
}
