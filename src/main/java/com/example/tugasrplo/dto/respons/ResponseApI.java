package com.example.tugasrplo.dto.respons;

import lombok.Builder;

import java.util.List;

@Builder
public record ResponseApI<T> (int code, String message, List<String> error, T data) {
}
