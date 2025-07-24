package com.acc.springBootProject001.controller;

import com.acc.springBootProject001.entity.Student;
import com.acc.springBootProject001.exception.DataNotFound;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    static List<Student> students = new ArrayList<Student>();

    static {
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Jane", "Smith"));
        students.add(new Student(3, "Alice", "Johnson"));
    }

    @PostMapping("/addStudent")
   public String addStudent(Student student){
        students.add(student);
        return "Student added successfully";
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable int id)  {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/firstName/{firstName}")
    public List<Student> getStudentByName(@PathVariable("firstName") String name){
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name) || student.getLastName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }

        return result;
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return "Student updated successfully";
            }
        }
        return  null;
    }



}
