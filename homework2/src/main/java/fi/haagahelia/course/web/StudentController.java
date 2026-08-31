package fi.haagahelia.course.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.course.domain.Student;

@Controller
public class StudentController {

    @GetMapping("/studentList")
    public String studentList(Model model) {
        //creates a list of students and adds them to the model
        List<Student> students = new ArrayList<>();

        //creates a new student and adds it to the list
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));

        model.addAttribute("students", students);

        return "studentList";
    }
}
