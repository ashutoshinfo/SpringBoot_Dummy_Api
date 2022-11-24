package info.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.ashutosh.entity.Methods;

@Repository
public interface MethodsReposetory extends JpaRepository<Methods, Long> {

}
