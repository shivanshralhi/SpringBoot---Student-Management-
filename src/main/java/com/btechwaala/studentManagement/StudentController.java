package com.btechwaala.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // telling the java applications this class will contain endpoints
public class StudentController {
    // database
    HashMap<Integer,Student> studentDb = new HashMap<>();

    // add a student
    @PostMapping("/add_student")
    public String addStudent(@RequestBody() Student student){
         int key = student.id;
         studentDb.put(key,student);
         return "Student added";
    }
    //get student by id
    @GetMapping("/get_student_by_id")
    public Student getStudentById(@RequestParam("id") Integer id){
        return studentDb.get(id);
    }

    @GetMapping("/get_by_path/{id}")
    public Student getByPath(@PathVariable("id")Integer id){
        return studentDb.get(id);
    }


    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name") String name){
        int id = 0;
        for(Map.Entry<Integer,Student> entry : studentDb.entrySet()){
            Student check = entry.getValue();
            if(check.name.equals(name)){
                 id = check.id;
            }
        }
        return studentDb.get(id);
    }
    // update student
    @PutMapping("/update_student")
    public Student updateStudent(@RequestBody() Student student){
        int key  = student.id;
        studentDb.put(key,student);
        return student;

    }
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id")Integer id){
        studentDb.remove(id);
        return "deleted successfully";
    }


}
