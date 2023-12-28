package hibernate_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_student.dto.Student;

public class StudentDao {
	public EntityManager getEntityManager() {

		return Persistence.createEntityManagerFactory("suraj").createEntityManager();

	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Student data saved");

	}

	public void getAllStudents() {
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> list = query.getResultList();
		System.out.println(list);
	}

	public void getStudent(long phone) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.phone=?1");
		query.setParameter(1, phone);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			System.out.println("Student with " + phone + " not found");
		}

	}

	public void getStudent(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email=?1");
		query.setParameter(1, email);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			System.out.println("Student with " + email + " not found");
		}
	}

	public void updateStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student dbStudent = entityManager.find(Student.class, student.getId());
		if (dbStudent != null) {
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");

		}
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
		} else {
			System.out.println("Student id not found");
		}

	}

	public void fetchStudent(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Id not found");

		}

	}
}
