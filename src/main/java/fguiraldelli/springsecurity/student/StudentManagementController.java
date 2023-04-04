package fguiraldelli.springsecurity.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteStudent(@PathVariable("id") Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student){
        System.out.println(String.format("%s, %s", studentId, student));
    }
}
