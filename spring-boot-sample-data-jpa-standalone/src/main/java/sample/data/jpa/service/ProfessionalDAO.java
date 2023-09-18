package sample.data.jpa.service;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Professional;

@Transactional
public interface ProfessionalDAO extends JpaRepository<Professional, Long> {
}
