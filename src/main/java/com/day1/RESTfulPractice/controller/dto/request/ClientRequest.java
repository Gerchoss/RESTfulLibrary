package com.day1.RESTfulPractice.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    private Long id;

    @NotBlank(message = "Client Name won't be empty")
    @Size(min = 5, max= 35, message = "Client Name invalid, 5 to 35 characters")
    @JsonProperty("client_name")
    private String clientName;


    @NotBlank(message = "Password won't be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$", message = "Password invalid, they need 1 lower case, 1 upper case and 1 number")
    @Size(min = 5, max= 35, message = "Password invalid, 8 to 100 characters")
    private String password;

    @NotBlank(message = "Email won't be empty")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email invalid")
    @Size(min = 5, max= 35, message = "Email invalid, 5 to 35 characters")
    private String email;
}
