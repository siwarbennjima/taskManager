package com.taskmanager.demo.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskServices taskServices ;

    @PostMapping("/task")
    public ResponseEntity<?> addtask (@RequestBody Task task){
        return taskServices.addTask(task);
    }
    @PutMapping("/task/{id}")
    public ResponseEntity<?> upDateById (@PathVariable int id , @RequestBody Task task){
        return taskServices.upDateById(id,task);

    }
    @GetMapping("/task/{id}")
    public ResponseEntity<?> getTaskById (@PathVariable int id ){
        return  taskServices.getTaskById(id);
    }
    @GetMapping("/tasks")
    public List<Task> gettasks(){
        List<Task> taskList =taskServices.getTasks();
        return taskList;
    }


}
