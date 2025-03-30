package in.rutujam.restapi.repository;

import in.rutujam.restapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity ,Long> {
}
