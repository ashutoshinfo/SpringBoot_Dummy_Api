package info.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.ashutosh.entity.API;

@Repository
public interface APIReposetory extends JpaRepository<API, Long> {

	public API findByTitle(String path);


}
