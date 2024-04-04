package jfs.backend.bms.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jfs.backend.bms.user.service.entity.User;
import jfs.backend.bms.user.service.payload.UserDto;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public Optional<User> findByUserName(String userName);
}
