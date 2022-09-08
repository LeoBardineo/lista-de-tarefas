package entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TAREFAS")
@XmlRootElement
public class Tarefa {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TITLE", length=255, nullable=false, unique=false)
	private String title;
	
	@Column(name="DESCRIPTION", nullable=false, unique=false)
	private String description;

	public enum priorityLevels { BAIXA, MEDIANA, ALTA }
	
	@Column(name="PRIORITY", nullable=false, unique=false)
	@Enumerated(EnumType.STRING)
	private priorityLevels priority;
	
	@Column(name="COMPLETED", nullable=false, unique=false)
	private boolean completed;
	
	@Column(name="CREATED_AT", nullable=false, unique=false)
	private LocalDateTime created_at;
	
	@Column(name="EXPIRES_AT", unique=false)
	private LocalDateTime expires_at;
	
	public Tarefa(){
		this.setTitle("Sem título.");
		this.setDescription("Sem descrição.");
		this.setPriority(priorityLevels.MEDIANA);
		this.setCompleted(false);
		this.setCreated_at(LocalDateTime.now());
		this.setExpires_at(LocalDateTime.now());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getExpires_at() {
		return expires_at;
	}
	public void setExpires_at(LocalDateTime expires_at) {
		this.expires_at = expires_at;
	}
	public priorityLevels getPriority() {
		return priority;
	}
	public void setPriority(priorityLevels priority) {
		this.priority = priority;
	}
}
