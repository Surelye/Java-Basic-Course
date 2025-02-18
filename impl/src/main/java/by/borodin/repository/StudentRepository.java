package by.borodin.repository;

import by.borodin.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query(value = """
        UPDATE student
        SET firstname = :#{#s.firstname},
            lastname = :#{#s.lastname},
            birthdate = :#{#s.birthdate},
            email = :#{#s.email},
            last_modified_at = NOW()
        WHERE id = :#{#s.id}
        """, nativeQuery = true)
    void update(@Param("s") Student student);
}
