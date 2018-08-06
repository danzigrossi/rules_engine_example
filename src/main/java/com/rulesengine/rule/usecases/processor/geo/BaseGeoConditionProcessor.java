package com.rulesengine.rule.usecases.processor.geo;

import com.rulesengine.rule.domain.Condition;
import com.rulesengine.rule.usecases.processor.BaseConditionProcessor;
import com.rulesengine.rule.usecases.processor.math.EqualsConditionProcessor;
import com.rulesengine.trackmessage.domain.Position;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseGeoConditionProcessor extends BaseConditionProcessor {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EqualsConditionProcessor.class);

	public String getPositionStatus(TrackMessage message, Condition condition) throws Exception {
		Position actual = null;
		Position last = null;
		return processPositionStatus(message.getName(), actual, last, condition.getRadius());
	}

	public String processPositionStatus(String module, Position actual, Position last, Integer radius) {
		
		return "inside";
	}

}
