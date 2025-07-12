package com.example.dictionary.excipient;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcipientRepository extends JpaRepository<Excipient, Long> {

    @Query(
            "SELECT DISTINCT e FROM Excipient e LEFT JOIN e.synonyms s "
                    + "WHERE e.deprecated = false AND ("
                    + "   LOWER(e.name) LIKE LOWER(CONCAT('%', :term, '%')) OR "
                    + "   LOWER(e.prettyName) LIKE LOWER(CONCAT('%', :term, '%')) OR "
                    + "   LOWER(e.canonicalName) LIKE LOWER(CONCAT('%', :term, '%')) OR "
                    + "   LOWER(s.synonym) LIKE LOWER(CONCAT('%', :term, '%'))"
                    + ")")
    List<Excipient> searchByNameOrSynonym(@Param("term") String term);
}
