package com.task.delivery.service.project;

import com.task.delivery.model.Project;
import com.task.delivery.repository.ProjectRepository;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.testng.annotations.Test;
import java.nio.charset.Charset;
import java.util.List;

public class ProjectServiceImplTest {

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

    @Test(enabled = false)
    public void first(){
        Project project = new Project();
        project.setId(1L);
        project.setProjectName("test");

        List<Project> projects = (List<Project>) projectRepository.findByProjectName("test");
        Assert.notEmpty(projects);
        Assert.notNull(projects.get(0).getId());

        projects = projectRepository.findById(1L);
        Assert.isTrue(projects.isEmpty());
      //  projectRepository.save(project);
    }

}