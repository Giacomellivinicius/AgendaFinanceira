package com.vinicius.agendafinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.agendafinanceira.domain.Comprovante;

@Repository
public interface ComprovanteRepository extends JpaRepository< Comprovante, Integer >{

}
