package com.seubone.sistemavendas.dto;

import com.seubone.sistemavendas.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}