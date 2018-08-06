package com.rulesengine.rule.domain;

import com.rulesengine.action.domain.Action;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

import java.util.List;
@Table(name="tb_rule", schema="rules")
@Entity
public class Rule {
	@GenericGenerator(
			name = "seq_id_rule",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = "sequence_name", value = "seq_id_rule"),
					@Parameter(name = "increment_size", value = "1")
			}
	)
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_id_rule")
	@Column(name="id_rule")
	private Long idRule;

    @Column(name="name")
	private String name;

    @JoinTable(name = "TB_RULE_X_CONDITION",
            joinColumns = {@JoinColumn(name = "ID_RULE", referencedColumnName = "ID_RULE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_CONDITION", referencedColumnName = "ID_CONDITION")}
    )
    @ManyToMany( fetch = FetchType.EAGER, cascade ={ CascadeType.PERSIST, CascadeType.MERGE})
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Condition> conditions;


    @JoinTable(name = "TB_RULE_X_ACTION",
            joinColumns = {@JoinColumn(name = "ID_RULE", referencedColumnName = "ID_RULE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_ACTION", referencedColumnName = "ID_ACTION")}
    )
    @ManyToMany(fetch = FetchType.EAGER, cascade ={ CascadeType.PERSIST, CascadeType.MERGE})
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Action> actions;


	public Rule(List<Condition> conditions, List<Action> actions, String name) {
		super();
		this.conditions = conditions;
		this.actions = actions;
		this.name = name;
	}

    public Rule() {
    }

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

    public Long getIdRule() {
        return idRule;
    }

    public void setIdRule(Long idRule) {
        this.idRule = idRule;
    }


}
