package com.example.les11opdrachtstudenten.repository;

import com.example.les11opdrachtstudenten.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface StudentRepository extends CrudRepository<Student, Long> {
Collection<Student> findByFullNameContaining(String name);
}
