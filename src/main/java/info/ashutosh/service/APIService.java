package info.ashutosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ashutosh.entity.API;
import info.ashutosh.exception.APINotFoundException;
import info.ashutosh.reposetory.APIReposetory;

@Service
public class APIService {

	@Autowired
	APIReposetory apiReposetory;

	public List<API> getAllAPIs() {
		return apiReposetory.findAll();

	}

	public String findByTitle(String path) {
		API findByTitle = apiReposetory.findByTitle(path);
		if (findByTitle != null) {
			return findByTitle.getDescription();
		}
		return null;

	}

	public API createAPI(API api) {
		return apiReposetory.save(api);
	}

	public API getOneAPI(Long id) {
		Optional<API> optional = apiReposetory.findById(id);
		if (optional.isEmpty()) {
			throw new APINotFoundException("API '" + id + "' not Excist !");
		} else {
			return optional.get();
		}
	}

	public void updateDoctor(API api) {
		if (api.getApiId() != null && apiReposetory.existsById(api.getApiId())) {
			apiReposetory.save(api);
		} else {
			throw new APINotFoundException("API '" + api.getApiId() + "' not Excist !");
		}
		apiReposetory.save(api);
	}

	public void deleteAPI(Long id) {
		apiReposetory.delete(getOneAPI(id));
	}

}
