package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.outcomes;


import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ListStudentOutcome {
    List<Student> students;
}
