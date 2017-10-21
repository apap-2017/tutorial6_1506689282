package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);


    List<StudentModel> selectAllStudents ();


    void addStudent (StudentModel student);


    void deleteStudent (String npm);
    
    
    void updateStudent (StudentModel student);
    
    
    List<CourseModel> selectCourses (@Param("npm") String npm);
    
    
    List<StudentModel> selectStudents (@Param("idCourse") String idCourse); 
    
    
    CourseModel selectCourse (@Param("idCourse") String idCourse); 
}
