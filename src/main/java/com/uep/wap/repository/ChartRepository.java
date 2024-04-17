package com.uep.wap.repository;

import com.uep.wap.model.Chart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartRepository extends CrudRepository<Chart, Integer> {
}
