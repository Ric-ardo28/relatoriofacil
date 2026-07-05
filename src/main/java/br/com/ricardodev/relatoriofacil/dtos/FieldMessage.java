package br.com.ricardodev.relatoriofacil.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FieldMessage {

    private String fieldName;
    private String message;

}
