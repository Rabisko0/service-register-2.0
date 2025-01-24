package br.com.rodrigocarvalho.service_register.repository;

import br.com.rodrigocarvalho.service_register.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
