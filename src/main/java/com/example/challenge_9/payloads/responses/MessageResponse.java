package com.example.challenge_9.payloads.responses;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    @NonNull
    private String message;
}
