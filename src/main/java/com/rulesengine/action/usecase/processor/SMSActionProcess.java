package com.rulesengine.action.usecase.processor;

import com.rulesengine.action.domain.Action;
import com.rulesengine.action.usecase.ActionInterface;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSActionProcess implements ActionInterface {
	public static final Logger LOGGER = LoggerFactory.getLogger(CommandActionProcessor.class);
	
	@Override
	public boolean process(TrackMessage message, Action action) {
		
		return accessSMSGateway(message, action);
	}
	
	private boolean accessSMSGateway(TrackMessage message, Action action) {
		LOGGER.info("Enviando SMS: "+"\nDestinos: "+ action.getDestination(),"\nMensagem: "+action.getMessageModel());
		return true;
	}
}
