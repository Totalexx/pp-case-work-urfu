package ru.totalexx.workservice.web.api.model.request.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequest {
    private Long ownerId;
    private String name;
}
