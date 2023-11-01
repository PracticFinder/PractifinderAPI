package com.practifinder.webapp.practifinder.profile.mapping.intern;

import com.practifinder.webapp.practifinder.profile.domain.intern.model.Student;
import com.practifinder.webapp.practifinder.profile.resource.intern.CreateStudentResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.StudentResource;
import com.practifinder.webapp.practifinder.profile.resource.intern.UpdateStudentResource;
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

    public StudentResource toResource(Student model){

        return mapper.map(model,StudentResource.class);
    }

    public Student toModel(CreateStudentResource resource){

        return mapper.map(resource,Student.class);
    }



    public Student toModel(UpdateStudentResource resource){

        return mapper.map(resource,Student.class);
    }

    public Page<StudentResource> modelListPage(List<Student> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,StudentResource.class),pageable,modelList.size());
    }

}
