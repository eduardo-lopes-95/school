package com.escola.doamanha.repository;

import com.escola.doamanha.model.Escola;
import com.escola.doamanha.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
