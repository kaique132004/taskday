package com.kgbz.taskday.controllers;

import com.kgbz.taskday.domain.tasks.RequestTask;
import com.kgbz.taskday.domain.tasks.TaskRepository;
import com.kgbz.taskday.domain.tasks.Tasks;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @GetMapping
    public ResponseEntity getAllTasks(){
        var allTasks = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allTasks);
    }

    @PostMapping
    public ResponseEntity creationTask(@Valid @RequestBody RequestTask tasks){
        Tasks task = new Tasks(tasks);
        System.out.println(tasks);
        repository.save(task);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTask(@RequestBody @Valid RequestTask tasks){
        Optional<Tasks> optionalTasks = repository.findById(tasks.id_task());
        if(optionalTasks.isPresent()){
            Tasks task_obj = optionalTasks.get();
            task_obj.setName_task(tasks.name_task());
            task_obj.setStatus(tasks.status());
            task_obj.setData_prv_task(tasks.data_prv_task());
            System.out.println(task_obj);
            return ResponseEntity.ok(task_obj);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTask(@PathVariable String id){
        Optional<Tasks> optionalTasks = repository.findById(id);
        if(optionalTasks.isPresent()){
            Tasks task_obj = optionalTasks.get();
            task_obj.setActive(false);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.badRequest().body("Dado não encontrado");
        }
    }
}
