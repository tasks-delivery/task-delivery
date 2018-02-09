package com.task.delivery.service.project;

import com.task.delivery.model.Project;
import com.task.delivery.repository.ProjectRepository;
import com.task.delivery.service.user.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Mock
    UserServiceImpl converter;

    @Test
    public void createNewUser()  {
        Project project = new Project("test");
        assertThat(project.getName()).isEqualTo("test");
    }

}