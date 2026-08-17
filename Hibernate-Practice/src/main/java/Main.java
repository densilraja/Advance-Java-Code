import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "hibernate-persistence-unit");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student = new Student();

        student.setId(1);
        student.setName("Densil");
        student.setMarks(90);

        em.persist(student);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Student saved successfully!");
    }
}