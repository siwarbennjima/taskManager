package com.taskmanager.demo.core;

import Utils.ErrorResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
    @Autowired
    TaskRepository taskRepository;
    private Object Description;

    public ResponseEntity<?> addTask(Task task) {

        if (task.getTitre() == null)
            return new ResponseEntity<>(new ErrorResponseModel("task titre required"), HttpStatus.BAD_REQUEST);

        if (task.getDL() == null)
            return new ResponseEntity<>(new ErrorResponseModel("wrong DL"), HttpStatus.BAD_REQUEST);

        Date currentd = new Date();
        if (task.getDL().compareTo(currentd) < 0)
            return new ResponseEntity<>(new ErrorResponseModel("task DL required"), HttpStatus.BAD_REQUEST);

        if (task.getDL().compareTo(currentd) == 0)
            return new ResponseEntity<>(new ErrorResponseModel("task  DL required"), HttpStatus.BAD_REQUEST);

        task = taskRepository.save(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }


    public ResponseEntity<?> upDateById(int id, Task updatedTask) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("wrong id"), HttpStatus.BAD_REQUEST);
        Task databasetask = taskOptional.get();
        if (updatedTask.getTitre() == null)
            return new ResponseEntity<>(new ErrorResponseModel("wrong id"), HttpStatus.BAD_REQUEST);
        else
            databasetask.setTitre(updatedTask.getTitre());
        databasetask.setDescription((updatedTask.getDescription()));

        if (updatedTask.getDL() == null)
            return new ResponseEntity<>(new ErrorResponseModel("wrong DL"), HttpStatus.BAD_REQUEST);
        Date currentd = new Date();
        if (updatedTask.getDL().compareTo(currentd) < 0)
            return new ResponseEntity<>(new ErrorResponseModel("task DL required"), HttpStatus.BAD_REQUEST);
        if (updatedTask.getDL().compareTo(currentd) == 0)
            return new ResponseEntity<>(new ErrorResponseModel("task  DL required"), HttpStatus.BAD_REQUEST);
        else
            databasetask.setDL(updatedTask.getDL());
        taskRepository.save(databasetask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> removeTask(int id) {
        Optional<Task> userOptional = taskRepository.findById(id);
        if (!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("wrong task id");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }
            taskRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        public List<Task> getTasks(){
        List<Task> taskList =taskRepository.findAll();
        return taskList;
        }
        public  ResponseEntity<?> getTaskById ( int id ) {
            Optional<Task> taskOptional = taskRepository.findById(id);
            if (taskOptional.isPresent()) {
                Task task = taskOptional.get();
                return new ResponseEntity<>(task, HttpStatus.OK);
            } else {
                ErrorResponseModel errorResponseModel = new ErrorResponseModel("wrong user id");
                return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
            }


        }













}

