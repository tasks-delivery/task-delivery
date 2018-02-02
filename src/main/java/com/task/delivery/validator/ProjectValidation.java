package com.task.delivery.validator;

import com.task.delivery.model.Project;
import com.task.delivery.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class ProjectValidation {

    @Autowired
    private ProjectService projectService;


    public boolean supports(Class<?> aClass) {
        return Project.class.equals(aClass);
    }


    public void validate(Object o, Errors errors) {
        Project user = (Project) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectName", "NotEmpty");
        if (user.getProjectName().length() < 3 ) {
            errors.rejectValue("name", "Size.projectForm.name");
        }
        /*
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        */
    }
}
