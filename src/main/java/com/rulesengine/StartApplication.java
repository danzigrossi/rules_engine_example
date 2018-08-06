package com.rulesengine;

import com.rulesengine.action.domain.Action;
import com.rulesengine.rule.domain.Condition;
import com.rulesengine.rule.domain.Rule;
import com.rulesengine.rule.usecases.RuleProcessor;
import com.rulesengine.trackmessage.domain.Position;
import com.rulesengine.trackmessage.domain.TrackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.rulesengine"})
@EnableJpaRepositories(basePackages = {"com.rulesengine"})
@ComponentScan(basePackages = {"com.rulesengine"})
public class StartApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private RuleProcessor ruleProcessor;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }


    @Override
    public void run(String... arg0) throws Exception {

        LOGGER.info("Starting AuthenticationMessageProcessor.");

        for (TrackMessage message : createMessages()) {

            ruleProcessor.process(message);
        }

    }

    public List<TrackMessage> createMessages() {
        List<TrackMessage> messages = new ArrayList<>();

        TrackMessage message = new TrackMessage();
        message.setActive(1);
        message.setActual(new Position(12.019821782612, -45.12783681));
        message.setLast(new Position(12.029821782612, -45.13783681));
        message.setType("ATC");
        message.setVelocity(131L);
        messages.add(message);
        return messages;
    }

}
