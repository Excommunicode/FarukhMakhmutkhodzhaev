package com.example.farukhmakhmutkhodzhaev.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.farukhmakhmutkhodzhaev.constant.Constant.DATA_TIME_FORMATTER;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private List<String> errors;
    private String message;
    private String reason;
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATA_TIME_FORMATTER)
    private LocalDateTime localDateTime = LocalDateTime.now();
}