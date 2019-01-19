package com.cognizant.projects.management.web.controller;
import com.cognizant.projects.management.db.repository.TaskRepository;
import com.cognizant.projects.management.service.ProjectService;
import com.cognizant.projects.management.service.exception.ServiceException;
import com.cognizant.projects.management.web.vo.Project;
import com.cognizant.projects.management.web.vo.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller handles the context path "/projmgmt"
 *
 */
@RestController
@RequestMapping("/projmgmt")
@Slf4j
public class ProjectController {



    @Autowired
    private ProjectService projectService;


    @RequestMapping(method= RequestMethod.POST,value = "/addProject")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> addProject(@RequestBody Project project){
        boolean isSucess = false;
        try {
            isSucess = projectService.addProject(project);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/updateProject")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> updateProject(@RequestBody Project project){
        boolean isSucess = false;
        try {
            isSucess = projectService.updateProject(project);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deleteProject/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> deleteProject(@PathVariable int id){
        boolean isSucess = false;
        try {
            isSucess = projectService.deleteProject(id);
        }catch(ServiceException se){
            log.error("Service Exception occurred",se);
            return new ResponseEntity<>(isSucess, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(isSucess, HttpStatus.OK);
    }

}
