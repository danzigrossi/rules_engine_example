package com.rulesengine.rule.usecases;

import com.rulesengine.rule.gateway.jpa.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllRules {

    @Autowired
    RuleRepository ruleRepository;

    public List execute() {
        return ruleRepository.findAll();
    }

}
