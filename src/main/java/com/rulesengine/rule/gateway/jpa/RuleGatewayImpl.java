package com.rulesengine.rule.gateway.jpa;

import com.rulesengine.rule.domain.Rule;
import com.rulesengine.rule.gateway.RuleGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RuleGatewayImpl implements RuleGateway {

    @Autowired
    RuleRepository ruleRepository;

    @Override
    public List<Rule> findAllRules() {
        return ruleRepository.findAll();
    }
}
