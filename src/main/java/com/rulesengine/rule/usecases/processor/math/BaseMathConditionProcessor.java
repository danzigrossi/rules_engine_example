package com.rulesengine.rule.usecases.processor.math;

import com.rulesengine.rule.domain.Condition;
import com.rulesengine.rule.usecases.processor.BaseConditionProcessor;
import com.rulesengine.trackmessage.domain.TrackMessage;

import java.math.BigDecimal;

public class BaseMathConditionProcessor extends BaseConditionProcessor {
	
	public int getRationalValue(Condition condition, TrackMessage message) throws Exception {
		Object value = getFieldValue(condition.getFieldName(), message);
		BigDecimal valueToCheck = new BigDecimal(value.toString());
		BigDecimal filterValue = new BigDecimal(condition.getFilterValue());
		return valueToCheck.compareTo(filterValue);
	}
}
