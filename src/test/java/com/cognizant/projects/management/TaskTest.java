package com.cognizant.projects.management;
import java.sql.Timestamp;

import com.cognizant.projects.management.web.vo.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class TaskTest {

    @Test
    public void Test() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Task task = new Task();
        task.setTaskId(1);
        task.setParentId(1);
        task.setProjectId(10);
        task.setTaskName("good task");
        task.setStartDate(new Timestamp(new java.util.Date().getTime()));
        task.setEndDate(new Timestamp(new java.util.Date().getTime()));
        task.setPriority(5);
        task.setStatus(5);


        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
        System.out.println(s);

    }
}
