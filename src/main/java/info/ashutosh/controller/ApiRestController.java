package info.ashutosh.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.ashutosh.entity.API;
import info.ashutosh.service.APIService;

@RestController
@RequestMapping("/dummy/api")
public class ApiRestController {

	@Autowired
	APIService aPIService;

	@PostMapping(value = "/create")
	public API getAllAPIs(@RequestBody API api) {
		return aPIService.createAPI(api);
	}

	@GetMapping(value = "/all")
	public List<API> getAllAPIs() {
		return aPIService.getAllAPIs();
	}

	@PostMapping(value = "/{path}")
	public String getAllAPIsByPOst(@PathVariable String path) {
		return aPIService.findByTitle(path);
	}
	@GetMapping(value = "/{path}")
	public String getAllAPIsByGet(@PathVariable String path) {
		return aPIService.findByTitle(path);
	}


	public static void main(String[] args) {
		new ApiRestController().nameq();
	}

	private void nameq() {

		List<String> list = new LinkedList<>();
		list.add("Patel");

		Stream<String> map = list.stream().parallel().map((n) -> name(n));
		List<String> collect = map.collect(Collectors.toList());
		System.out.println(collect);
	}

	private String name(String n) {

		return n + " Ashutosh";

	}
}
