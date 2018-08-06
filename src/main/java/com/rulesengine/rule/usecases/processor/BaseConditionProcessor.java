package com.rulesengine.rule.usecases.processor;

import com.rulesengine.rule.domain.Condition;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;

import java.lang.reflect.Method;

public abstract class BaseConditionProcessor {

	public static final String PREFIX_GET = "get";
	
	public Method getMethod(String field, TrackMessage message ) {
		for (Method method : message.getClass().getMethods()) {
			if (method.getName().equals(PREFIX_GET+field)){
				return method;
			}
		}
		return null;
	}
	
	public Object getFieldValue(String field, TrackMessage message ) throws Exception{
		Method method = getMethod(field, message);
		if (method == null ){
			throw new Exception();
		}
		return method.invoke(message);
	}
	
	public void traceCondition(Logger logger, Condition condition, boolean result){
		if (result) {
			logger.info("Condição aceita: "+condition.getName());
		}
		else {
			logger.info("Condição rejeitada: "+condition.getName());
		}
	}
}
