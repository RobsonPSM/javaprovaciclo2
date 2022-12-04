package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraDB {
	public static void main(String[] args) {
		   EntityManagerFactory factory =  Persistence.createEntityManagerFactory("alunos");
		   factory.close();
	}
}
