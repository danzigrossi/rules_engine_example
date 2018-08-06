package com.rulesengine.rule.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Table(name = "tb_condition", schema = "rules")
@Entity
public class Condition {

    @GenericGenerator(
            name = "seq_id_condition",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_id_condition"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_condition")
    @Column(name = "id_condition")
    private Long idCondition;

    @Column(name = "name")
    private String name;

    @Column(name = "type_class")
    private String typeClass;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "filter_value")
    private String filterValue;

    @Column(name = "radius")
    private Integer radius;

    @Transient
    private Integer idPolygon;

    public Condition(String name, String typeClass, String fieldName, String filterValue, Integer radius, Integer idPolygon) {
        super();
        this.name = name;
        this.typeClass = typeClass;
        this.fieldName = fieldName;
        this.filterValue = filterValue;
        this.radius = radius;
        this.idPolygon = idPolygon;
    }

    public Condition() {
        
    }

    public void setIdPolygon(Integer idPolygon) {
        this.idPolygon = idPolygon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public int getIdPolygon() {
        return idPolygon;
    }

    public void setIdPolygon(int idPolygon) {
        this.idPolygon = idPolygon;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Long getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(Long idCondition) {
        this.idCondition = idCondition;
    }
}
