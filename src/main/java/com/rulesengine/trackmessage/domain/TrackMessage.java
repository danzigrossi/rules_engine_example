package com.rulesengine.trackmessage.domain;

public class TrackMessage {
	private String type;
	private String name;
	private Long velocity;
	private Position actual;
	private Position last;
	private Integer active;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the actual
	 */
	public Position getActual() {
		return actual;
	}
	/**
	 * @param actual the actual to set
	 */
	public void setActual(Position actual) {
		this.actual = actual;
	}
	/**
	 * @return the last
	 */
	public Position getLast() {
		return last;
	}
	/**
	 * @param last the last to set
	 */
	public void setLast(Position last) {
		this.last = last;
	}
	/**
	 * @return the velocity
	 */
	public Long getVelocity() {
		return velocity;
	}
	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Long velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the active
	 */
	public Integer getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

}
