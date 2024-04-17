package com.uep.wap.repository;

import com.uep.wap.model.Newsletter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends CrudRepository<Newsletter, Integer> {
}
