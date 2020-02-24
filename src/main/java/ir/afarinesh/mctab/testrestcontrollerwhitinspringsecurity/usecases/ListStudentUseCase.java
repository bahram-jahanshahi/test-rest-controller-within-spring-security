package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases;

import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.core.annotations.UseCase;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.entities.Student;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.commands.ListStudentCommand;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.outcomes.ListStudentOutcome;

import java.util.List;

@UseCase
public interface ListStudentUseCase {

    ListStudentOutcome listStudent(ListStudentCommand command) throws Exception;
}
