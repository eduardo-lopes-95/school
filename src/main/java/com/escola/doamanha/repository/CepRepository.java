package com.escola.doamanha.repository;

import com.escola.doamanha.model.Cep;
import com.escola.doamanha.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Cep, Long> {

}
