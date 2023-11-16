package com.api.thymeleaf.repository;

import com.api.thymeleaf.constants.FuncionarioSetor;
import com.api.thymeleaf.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findBySetor(FuncionarioSetor funcionarioSetor);
}
