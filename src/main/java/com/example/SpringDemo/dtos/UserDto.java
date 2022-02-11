package com.example.SpringDemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @NotEmpty(message = "Ad boş geçilemez")
    private String firstName;
    @NotEmpty(message = "Soyad boş geçilemez")
    private String lastName;
}
