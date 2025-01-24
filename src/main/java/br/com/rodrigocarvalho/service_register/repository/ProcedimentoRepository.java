package br.com.rodrigocarvalho.service_register.repository;

import br.com.rodrigocarvalho.service_register.entity.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}
