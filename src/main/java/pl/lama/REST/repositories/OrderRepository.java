package pl.lama.REST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lama.REST.domain.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
