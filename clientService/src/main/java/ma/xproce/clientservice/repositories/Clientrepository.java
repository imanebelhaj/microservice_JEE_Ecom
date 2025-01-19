package ma.xproce.clientservice.repositories;

import ma.xproce.clientservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientrepository extends JpaRepository<Client,Long> {
}
