package br.com.rodrigocarvalho.service_register.repository;

import br.com.rodrigocarvalho.service_register.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
