package com.kgbz.taskday.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}