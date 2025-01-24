package br.com.rodrigocarvalho.service_register.repository;

import br.com.rodrigocarvalho.service_register.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}
