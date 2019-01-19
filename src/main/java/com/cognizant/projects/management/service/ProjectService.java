package com.cognizant.projects.management.service;

import com.cognizant.projects.management.db.Entities.Project;
import com.cognizant.projects.management.db.repository.ProjectRepository;
import com.cognizant.projects.management.service.dto.DaoToDomain;
import com.cognizant.projects.management.service.dto.DomainToDAO;
import com.cognizant.projects.management.service.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * A orchestration class which handles the business logic
 * for the project management
 */
@Service
@Slf4j
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DomainToDAO domainToDAO;

    @Autowired
    private DaoToDomain daoToDomain;

    public boolean addProject(com.cognizant.projects.management.web.vo.Project project) throws ServiceException {
        boolean isSuccess = false;
        Project dbProject = domainToDAO.getProject(project);
        try {
            projectRepository.save(dbProject);
            isSuccess = true;
        } catch (Exception e) {
            log.error("Exception occurred in add task", e);
            throw new ServiceException(e.getMessage());
        }
        return isSuccess;
    }

    public boolean updateProject(com.cognizant.projects.management.web.vo.Project project) throws ServiceException {
        boolean isSuccess = false;
        try {
            Optional<Project> byId = projectRepository.findById(project.getProjectID());
            if(byId.isPresent()){
                Project dbProject = byId.get();
                Project project1 = domainToDAO.getProject(project, dbProject);
                projectRepository.save(project1);
            }
            isSuccess = true;
        } catch (Exception e) {
            log.error("Exception occurred in update task", e);
            throw new ServiceException(e.getMessage());
        }
        return isSuccess;
    }

    public boolean deleteProject(int projectId) throws ServiceException {
        boolean isSuccess = false;
        try {
            projectRepository.deleteById(projectId);
            isSuccess = true;
        } catch (Exception e) {
            log.error("Exception occurred in delete task", e);
            throw new ServiceException(e.getMessage());
        }
        return isSuccess;
    }
}
