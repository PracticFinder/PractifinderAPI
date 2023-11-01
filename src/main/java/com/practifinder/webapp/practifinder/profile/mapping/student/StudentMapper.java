package com.practifinder.webapp.practifinder.profile.mapping.student;

import com.practifinder.webapp.practifinder.profile.domain.student.model.Student;
import com.practifinder.webapp.practifinder.profile.resource.student.CreateStudentResource;
import com.practifinder.webapp.practifinder.profile.resource.student.StudentResource;
import com.practifinder.webapp.practifinder.profile.resource.student.UpdateStudentResource;
import com.practifinder.webapp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class StudentMapper implements Serializable {


    @Autowired
    private EnhancedModelMapper mapper;

    public StudentResource toResource(Student model) {

        return mapper.map(model, StudentResource.class);
    }

    public Student toModel(CreateStudentResource resource) {

        return mapper.map(resource, Student.class);
    }


    public Student toModel(UpdateStudentResource resource) {

        return mapper.map(resource, Student.class);
    }

    public Page<StudentResource> modelListPage(List<Student> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, StudentResource.class), pageable, modelList.size());
    }



}
