package our_anime_list.backend.user_list.repository;

import our_anime_list.backend.user_list.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long>{
    List<Users> findByUserId(Long userId);
}
