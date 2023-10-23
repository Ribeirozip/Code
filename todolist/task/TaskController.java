package com.example.todolist.task;

import com.example.todolist.utils.Ultis;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity create (@RequestBody TaskModel taskModel, HttpServletRequest request){
        System.out.println("Chegou no Controller"+request.getAttribute("idUser"));
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID)idUser);
        var currentDate = LocalDateTime.now();
        if (currentDate.isAfter(taskModel.getStartAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de inicio deve ser maior que a data atual");
        }
        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de termino deve ser menor que a data de inicio");
        }

        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIdUser((UUID) idUser);
        return tasks;
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskModel taskModel,@PathVariable UUID id,HttpServletRequest request){
         var task = this.taskRepository.findById(id).orElse(null);
         if(task == null){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarefa não encontrada");
         }
         var idUser = request.getAttribute("idUser");
         if(!task.getIdUser().equals(idUser)){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario nao tem permissao pra alterar tarefa");
         }

         Ultis.copyNonNullProperties(taskModel,task);
        var taskUpdated = this.taskRepository.save(task);
         return ResponseEntity.ok().body(this.taskRepository.save(taskUpdated));
    }
}

