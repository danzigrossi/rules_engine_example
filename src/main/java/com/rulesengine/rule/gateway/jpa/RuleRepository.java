package com.rulesengine.rule.gateway.jpa;

import com.rulesengine.rule.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {

 
}