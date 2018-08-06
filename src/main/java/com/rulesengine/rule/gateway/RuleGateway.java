package com.rulesengine.rule.gateway;

import com.rulesengine.rule.domain.Rule;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RuleGateway {
    List<Rule> findAllRules();
}
