package linghu.repository;

import linghu.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAreaRepository extends JpaRepository<Area,String> {
}
