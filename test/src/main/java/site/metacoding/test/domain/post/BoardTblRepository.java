package site.metacoding.test.domain.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTblRepository extends JpaRepository<BoardTbl, Integer> {

    @Query(value = "SELECT * FROM BoardTbl WHERE title LIKE %:keyword%", nativeQuery = true)
    List<BoardTbl> mSearch(@Param("keyword") String keyword);

}