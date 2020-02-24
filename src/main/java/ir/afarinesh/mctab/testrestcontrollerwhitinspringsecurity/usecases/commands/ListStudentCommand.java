package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ListStudentCommand {
    private String searchTitle;
}
