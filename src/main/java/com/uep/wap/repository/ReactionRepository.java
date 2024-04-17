package com.uep.wap.repository;

import com.uep.wap.model.Reaction;
import com.uep.wap.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends CrudRepository<Reaction, Integer> {
}
