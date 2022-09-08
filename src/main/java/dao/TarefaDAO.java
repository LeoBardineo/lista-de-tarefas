package dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Tarefa;
import util.HibernateConfig;

public class TarefaDAO {
	public List<Tarefa> getAll(){
		Session session = HibernateConfig.getSession();
		List<Tarefa> tarefas = session.createQuery("from Tarefa").list();
		session.close();
		return tarefas;
	}
	
	public Tarefa get(int id){
		Session session = HibernateConfig.getSession();
		Tarefa tarefa = session.get(Tarefa.class, id);
		session.close();
		return tarefa;
	}
	
	public void insert(Tarefa tarefa){
		Session session = HibernateConfig.getSession();
		session.save(tarefa);
		session.close();		
	}
	
	public void update(Tarefa tarefa){
		Session session = HibernateConfig.getSession();
		Transaction tx = session.beginTransaction();
		String strQuery = "update Tarefa set title = :title,"
				+ "description = :description,"
				+ "completed = :completed,"
				+ "priority = :priority,"
				+ "expires_at = :expires_at"
				+ " where id = :id";
		Query query = session.createQuery(strQuery);
		query.setParameter("title", tarefa.getTitle());
		query.setParameter("description", tarefa.getDescription());
		query.setParameter("completed", tarefa.isCompleted());
		query.setParameter("priority", tarefa.getPriority());
		query.setParameter("expires_at", tarefa.getExpires_at());
		query.setParameter("id", tarefa.getId());
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	
	public void delete(int id){
		Session session = HibernateConfig.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Tarefa where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
}
