package com.rulesengine.rule.usecases;

import com.rulesengine.action.domain.Action;
import com.rulesengine.action.usecase.ActionInterface;
import com.rulesengine.rule.domain.Condition;
import com.rulesengine.rule.domain.Rule;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleProcessor {

    @Autowired
    FindAllRules findAllRules;

	public void process(TrackMessage message) throws Exception {
        List<Rule> rules = findAllRules.execute();
		for (Rule rule : rules) {
			if (isRuleAccepted(message, rule)) {
				for (Action action : rule.getActions()) {
					ActionInterface actionProcessor = (ActionInterface)ActionInterface.class.getClassLoader().loadClass(action.getClassType()).newInstance();
					actionProcessor.process(message, action);
				}
			}
		}
	}
	
	private boolean isRuleAccepted(TrackMessage message, Rule rule) throws Exception {
		for (Condition subRule : rule.getConditions()) {
			ConditionInterface ruleProcessor = (ConditionInterface)ConditionInterface.class.getClassLoader().loadClass(subRule.getTypeClass()).newInstance();
			if (!ruleProcessor.process(message, subRule)) {
				return false;
			}
		}
		return true;
	}
}
