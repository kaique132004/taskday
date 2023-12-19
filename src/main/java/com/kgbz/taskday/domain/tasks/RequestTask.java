package com.kgbz.taskday.domain.tasks;


import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public record RequestTask(
        String id_task,
        @NotBlank
        String name_task,
        @NotBlank
        String status,
        Timestamp data_cad_task,
        Timestamp data_prv_task,
        Boolean active
) {
}
