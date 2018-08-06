package com.rulesengine.rule.usecases.processor.geo;

import com.rulesengine.rule.domain.Condition;
import com.rulesengine.rule.usecases.ConditionInterface;
import com.rulesengine.rule.usecases.processor.math.EqualsConditionProcessor;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaRuleProcessor extends BaseGeoConditionProcessor implements ConditionInterface {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EqualsConditionProcessor.class);

	@Override
	public boolean process(TrackMessage message, Condition condition) throws Exception {
		String statusProcessor = getPositionStatus(message,condition);
		boolean result = statusProcessor.equals(condition.getFilterValue());
		traceCondition(LOGGER, condition, result);
		return result;
	}



}
