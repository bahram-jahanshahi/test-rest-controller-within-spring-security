package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.services;

import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.entities.Student;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.repositories.StudentJpaRepository;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.ListStudentUseCase;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.commands.ListStudentCommand;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.outcomes.ListStudentOutcome;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListStudentService implements ListStudentUseCase {

    final StudentJpaRepository studentJpaRepository;

    public ListStudentService(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public ListStudentOutcome listStudent(ListStudentCommand command) throws Exception {
        return new ListStudentOutcome(
                studentJpaRepository.findAllByStudentNameContainingOrStudentFamilyContaining(command.getSearchTitle(), command.getSearchTitle())
        );

    }
}
