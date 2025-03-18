package ru.totalexx.workservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class AbstractModel {
    @Id
    @GeneratedValue
    private UUID id;
}