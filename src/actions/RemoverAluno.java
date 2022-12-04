package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class RemoverAluno {
	public static void remover(Aluno aluno) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Aluno al = manager.find(Aluno.class, aluno.getId());
		
		manager.getTransaction().begin();
		
		manager.remove(al);
		manager.getTransaction().commit();
		
		
		
		manager.close();
		factory.close();
	}
}
