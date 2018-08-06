package com.rulesengine.rule.usecases.processor.math;

import com.rulesengine.rule.domain.Condition;
import com.rulesengine.rule.usecases.ConditionInterface;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiggerConditionProcessor extends BaseMathConditionProcessor implements ConditionInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(BiggerConditionProcessor.class);
	
	@Override
	public boolean process(TrackMessage message, Condition condition) throws Exception {

		boolean result = (getRationalValue(condition, message) > 0);
		traceCondition(LOGGER, condition, result);
		return result;
	}

}
