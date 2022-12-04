package actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class BuscarPrimeiraLetra {
	public static List<Aluno> buscarPrimeiraLetra(String letra){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("SELECT a FROM Aluno AS a WHERE a.nome LIKE :letra");
		query.setParameter("letra", letra + "%");
		List<Aluno> al = (List<Aluno>)query.getResultList();
		return al;
	}
}
