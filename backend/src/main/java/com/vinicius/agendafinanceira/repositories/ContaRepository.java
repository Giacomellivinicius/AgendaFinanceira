package com.vinicius.agendafinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.agendafinanceira.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository< Conta , Integer >{

}
