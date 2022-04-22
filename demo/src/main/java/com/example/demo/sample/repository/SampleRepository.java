package com.example.demo.sample.repository;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

@ConfigAutowireable
@Dao
public interface SampleRepository {

	@Select
	public List<SampleEntity> selectList(String name, SelectOptions option);
}
