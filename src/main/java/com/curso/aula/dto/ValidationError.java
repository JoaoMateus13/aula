package com.curso.aula.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String field, String message) {

        erros.removeIf(x-> x.getField().equals(field) && x.getMessage().equals(message));

        erros.add(new FieldMessage(field, message));
    }

}
