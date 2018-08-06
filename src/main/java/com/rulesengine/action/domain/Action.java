package com.rulesengine.action.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Table(name = "tb_action", schema = "rules")
@Entity
public class Action {
    @GenericGenerator(
            name = "seq_id_action",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_id_action"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_action")
    @Column(name = "id_action")
    private Long id_action;

    @Column(name = "name")
    private String name;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "destination")
    private String destination;

    @Column(name = "message_model")
    private String messageModel;

    @Column(name = "command")
    private String command;

    @Column(name = "title")
    private String title;

    @Column(name = "from")
    private String from;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getMessageModel() {
        return messageModel;
    }

    public void setMessageModel(String messageModel) {
        this.messageModel = messageModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getId_action() {
        return id_action;
    }

    public void setId_action(Long id_action) {
        this.id_action = id_action;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
