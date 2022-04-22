package com.example.demo.sample;

import java.util.List;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.sample.repository.SampleEntity;
import com.example.demo.sample.repository.SampleRepository;
import com.example.demo.template.paging.Page;

@Service
@Transactional
public class SampleService {

	@Autowired
	SampleRepository sampleRepository;
	
	public List<SampleEntity> selectList(String name, Page page) {
		return sampleRepository.selectList(name, SelectOptions.get().offset(page.offset()).limit(page.limit()));
	}
}
