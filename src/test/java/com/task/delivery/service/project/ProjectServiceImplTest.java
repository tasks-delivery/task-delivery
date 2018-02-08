package com.task.delivery.service.project;

import com.task.delivery.model.Project;
<<<<<<< HEAD
import com.task.delivery.repository.ProjectRepository;
=======
//import com.task.delivery.repository.ProjectRepository;
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.testng.annotations.Test;
import java.nio.charset.Charset;
import java.util.List;

public class ProjectServiceImplTest {
<<<<<<< HEAD

=======
/*
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
    private MediaType contentType;

    @Mock
    ProjectRepository projectRepository;

    @Spy
    ModelMapper modelMapper;

    @Mock
    ProjectServiceImpl projectService;

    @Mock
    private List<String> mockedList;

    @Mock
    private List<String> mockedList1;

    @Mock
    private List<String> mockedList2;

    @Mock
    private List<String> mockedList3;
//
   // @BeforeClass
    public void setup() throws Exception {

        this.contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                Charset.forName("utf8"));

    }

<<<<<<< HEAD
    @Test
=======
    @Test(enabled = false)
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
    public void first(){
        Project project = new Project();
        project.setId(1L);
        project.setProjectName("test");

<<<<<<< HEAD
        List<Project> projects = projectRepository.findByProjectName("test");
=======
        List<Project> projects = (List<Project>) projectRepository.findByProjectName("test");
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
        Assert.notEmpty(projects);
        Assert.notNull(projects.get(0).getId());

        projects = projectRepository.findById(1L);
        Assert.isTrue(projects.isEmpty());
      //  projectRepository.save(project);
    }
<<<<<<< HEAD

=======
*/
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
}