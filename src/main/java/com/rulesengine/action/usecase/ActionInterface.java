package com.rulesengine.action.usecase;

import com.rulesengine.action.domain.Action;
import com.rulesengine.trackmessage.domain.TrackMessage;

public interface ActionInterface {
	boolean process(TrackMessage message, Action action);
}
