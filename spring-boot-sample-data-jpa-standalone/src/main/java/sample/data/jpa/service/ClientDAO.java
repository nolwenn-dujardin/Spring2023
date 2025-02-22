package sample.data.jpa.service;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Client;

@Transactional
public interface ClientDAO extends JpaRepository<Client, Long> {
}
