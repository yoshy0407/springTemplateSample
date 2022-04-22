package com.example.demo.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sample.repository.SampleEntity;
import com.example.demo.template.annotation.Paging;
import com.example.demo.template.paging.Page;

@RestController
@RequestMapping("/api")
public class SampleRestController {

	@Autowired
	SampleService sampleService;
	
	@GetMapping("/sample")
	public List<SampleEntity> getList(String name, @Paging Page page) {
		return sampleService.selectList(name, page);
	}
}
