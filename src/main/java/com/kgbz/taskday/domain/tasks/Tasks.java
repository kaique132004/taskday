package com.kgbz.taskday.domain.tasks;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Table(name = "tasks")
@Entity(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_task")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_task;

    private String name_task;

    private String status;

    private Timestamp data_cad_task;

    private Timestamp data_prv_task;

    private boolean active;

    public Tasks(RequestTask requestTask){
        this.name_task = requestTask.name_task();
        this.status = requestTask.status();
        this.data_cad_task = requestTask.data_cad_task();
        this.data_prv_task = requestTask.data_prv_task();
        this.active = true;
    }
}
