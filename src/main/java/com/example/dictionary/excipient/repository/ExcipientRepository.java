package com.example.dictionary.excipient.repository;

import com.example.dictionary.excipient.model.Excipient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcipientRepository extends JpaRepository<Excipient, Long> {

    String SEARCH_QUERY =
            "SELECT DISTINCT e FROM Excipient e LEFT JOIN e.synonyms s "
                    + "WHERE e.deprecated = false AND ("
                    + "   e.name LIKE CONCAT('%', UPPER(:term), '%') OR "
                    + "   LOWER(e.prettyName) LIKE LOWER(CONCAT('%', :term, '%')) OR "
                    + "   e.canonicalName LIKE CONCAT('%', LOWER(:term), '%') OR "
                    + "   LOWER(s.synonym) LIKE LOWER(CONCAT('%', :term, '%'))"
                    + ")";

    @Query(SEARCH_QUERY)
    List<Excipient> search(@Param("term") String term);
}
