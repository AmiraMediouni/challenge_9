package com.example.challenge_9.payloads.responses;

import lombok.*;

@Data
@Builder @NoArgsConstructor @AllArgsConstructor
public class LoginResponse {
    @NonNull
    private String token;
    @NonNull
    private String type;
    @NonNull
    private String message;
}
