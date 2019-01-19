package com.cognizant.projects.management.service.dto;
import java.sql.Timestamp;

import com.cognizant.projects.management.web.vo.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoToDomain {


    public List<Task>  getTaskList(List<com.cognizant.projects.management.db.Entities.Task> dbTasks){

        List<Task> taskList = new ArrayList<>();
        for(com.cognizant.projects.management.db.Entities.Task dbTask : dbTasks){
            Task domainTask = new Task();
            domainTask.setTaskId(dbTask.getTask_id());
            domainTask.setParentId(dbTask.getParent_id());
            domainTask.setProjectId(dbTask.getProjectId());
            domainTask.setTaskName(dbTask.getTask_name());
            domainTask.setStartDate(dbTask.getStart_date());
            domainTask.setEndDate(dbTask.getStart_date());
            domainTask.setPriority(dbTask.getPriority());
            domainTask.setStatus(dbTask.getStatus());
            taskList.add(domainTask);
        }

        return taskList;
    }


}
