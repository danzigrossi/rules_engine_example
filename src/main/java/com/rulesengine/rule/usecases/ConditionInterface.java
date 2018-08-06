package com.rulesengine.rule.usecases;

import com.rulesengine.rule.domain.Condition;
import com.rulesengine.trackmessage.domain.TrackMessage;

public interface ConditionInterface {

	boolean process(TrackMessage message, Condition condition) throws Exception;

}
