package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.controllers;

import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.entities.Student;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.ListStudentUseCase;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.commands.ListStudentCommand;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.outcomes.ListStudentOutcome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final ListStudentUseCase listStudentUseCase;

    public StudentController(ListStudentUseCase listStudentUseCase) {
        this.listStudentUseCase = listStudentUseCase;
    }

    @PostMapping("/all")
    public ListStudentOutcome listStudent(@RequestBody ListStudentCommand command) throws Exception {
        return listStudentUseCase.listStudent(command);
    }
}
