package com.rulesengine.action.usecase.processor;

import com.rulesengine.action.domain.Action;
import com.rulesengine.action.usecase.ActionInterface;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailActionProcess implements ActionInterface {
	public static final Logger LOGGER = LoggerFactory.getLogger(EmailActionProcess.class);
	
	@Override
	public boolean process(TrackMessage message, Action action) {
		
		return accessEmailGateway(message, action); 
	}
	
	private boolean accessEmailGateway(TrackMessage message, Action action) {
		LOGGER.info("Enviando Email: "+"\nTitulo: " +action.getTitle()+"\nPara"+action.getDestination()+"\nMensagem: "+action.getMessageModel()+ "\nDe: "+action.getFrom());
		return true;
	}
}
