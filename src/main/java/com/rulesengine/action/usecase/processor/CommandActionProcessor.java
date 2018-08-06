package com.rulesengine.action.usecase.processor;

import com.rulesengine.action.domain.Action;
import com.rulesengine.action.usecase.ActionInterface;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandActionProcessor implements ActionInterface {

	public static final Logger LOGGER = LoggerFactory.getLogger(CommandActionProcessor.class);
	
	@Override
	public boolean process(TrackMessage message, Action action) {
		
		return accessCommandGateway(message, action);
	}
	
	private boolean accessCommandGateway(TrackMessage message, Action action) {
		LOGGER.info("Enviando Comando: "+ action.getCommand()+"\nPara"+action.getDestination()+"\nMensagem");
		return true;
	}

}
