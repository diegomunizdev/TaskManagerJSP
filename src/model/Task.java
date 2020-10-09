package model;

import java.sql.Date;

public class Task {

	private int id;
    private String name;
    private String description;
    private String status_tarefa;
    private String atribuido;
    private Date data_conclusao;
    private Date dateCreated;
    private Date dateUpdated;
        
    public String getStatus_tarefa() {
		return status_tarefa;
	}

	public void setStatus_tarefa(String status_tafera) {
		this.status_tarefa = status_tafera;
	}

	public String getAtribuido() {
		return atribuido;
	}

	public void setAtribuido(String atribuido) {
		this.atribuido = atribuido;
	}

	public Date getData_conclusao() {
		return data_conclusao;
	}

	public void setData_conclusao(Date data_conclusao) {
		this.data_conclusao = data_conclusao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name
                + ", description=" + description + ", dateCreated=" + dateCreated
                + ", dateUpdated=" + dateUpdated + "]";
    }

}
