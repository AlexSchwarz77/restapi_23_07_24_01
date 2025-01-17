package afp.restapi.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import afp.restapi.models.IUsers;
import afp.restapi.models.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    @Query("FROM Users WHERE date = ?1")
    Optional<List<Users>> findUsersByDate(LocalDate date);

    @Query(value = "SELECT * FROM users WHERE user_id = ?1 AND email = ?2", nativeQuery = true)
    Optional<Users> findUserByIdAndEMail(Long id, String email);

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Optional<Users> logIn(String email);

    @Query(value = "SELECT user_id as userId, user_name as userName, email FROM users WHERE email = ?1", nativeQuery = true)
    IUsers getIUser(String email);

    @Query(value = "Update users SET password = ?1 WHERE user_id = ?2", nativeQuery = true)
    Users updatePassword(String password, Long userId);
}
