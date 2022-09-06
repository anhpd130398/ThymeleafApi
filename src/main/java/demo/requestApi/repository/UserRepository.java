package demo.requestApi.repository;

import demo.requestApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    @Query(nativeQuery = true,value = "select * from User u where u.user_name = :userName")
    List<User> getByName(@Param("userName") String userName);
}
