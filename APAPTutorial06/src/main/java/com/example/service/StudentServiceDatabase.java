package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentMapper;
import com.example.model.CourseModel;
import com.example.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
    }


    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        return studentMapper.selectAllStudents ();
    }


    @Override
    public void addStudent (StudentModel student)
    {
        studentMapper.addStudent (student);
    }


    @Override
    public void deleteStudent (String npm)
    {
    	log.info ("student " + npm + " deleted");
    	studentMapper.deleteStudent(npm);
    }
    
    @Override
    public void updateStudent (StudentModel student)
    {
    	log.info ("student " + student.getNpm() + " updated name to " + student.getName() + 
    			" and gpa to " + student.getGpa());
    	studentMapper.updateStudent(student);
    }
    
    @Override
    public List<CourseModel> selectCourses (@Param("npm") String npm) {
    	return studentMapper.selectCourses(npm);
    }
    
    @Override
    public List<StudentModel> selectStudents (@Param("idCourse") String idCourse) {
    	return studentMapper.selectStudents(idCourse);
    }; 
    
    @Override
    public CourseModel selectCourse (@Param("idCourse") String idCourse) {
    	return studentMapper.selectCourse(idCourse);
    }

}
