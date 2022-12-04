package actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class ListarAlunos {
	public static List<Aluno> listarAlunos() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		String sql = "SELECT a FROM Aluno AS a";
		Query query = manager.createQuery(sql);
		List<Aluno> alunos = (List<Aluno>) query.getResultList();
		manager.close();
		factory.close();
		return alunos;
	}
}
