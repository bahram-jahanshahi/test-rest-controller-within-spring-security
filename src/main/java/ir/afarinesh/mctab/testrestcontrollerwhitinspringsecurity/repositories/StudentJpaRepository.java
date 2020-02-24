package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.repositories;

import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudentNameContainingOrStudentFamilyContaining(String studentName, String studentFamily);
}
