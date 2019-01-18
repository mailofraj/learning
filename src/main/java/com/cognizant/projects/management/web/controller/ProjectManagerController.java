package com.cognizant.projects.management.web.controller;

import com.cognizant.projects.management.db.repository.TaskRepository;
import com.cognizant.projects.management.web.vo.Project;
import com.cognizant.projects.management.web.vo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/projectmanagement")
public class ProjectManagerController {

    @Autowired
    private TaskRepository taskrepository;

    @RequestMapping(method=RequestMethod.GET,value = "/addTask")
    public ResponseEntity addTask(Task task){
        System.out.println(task);
        com.cognizant.projects.management.db.Task dbTask  = new com.cognizant.projects.management.db.Task();
        dbTask.setTask_id("1");
        taskrepository.save(dbTask);
        return null;
    }

    @RequestMapping(method=RequestMethod.GET, value="/viewTask")
    public ResponseEntity viewTaskDtls(){
        System.out.println();
        return null;
    }

    @RequestMapping(method=RequestMethod.POST,value="/addProject")
    public ResponseEntity addProjects(Project project){
        System.out.println(project);
        return null;
    }

}
