package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Alumno;
import JPA_Hibernate_Asociaciones.Entity.Curso;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToMany {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Jugar con la transaccionalidad
        try{
            em.getTransaction().begin();
                //Crear una terceta de cursos
            Curso curso1 = new Curso("Historia", "Heródoto");
            Curso curso2 = new Curso("Música", "Orfeo");
            Curso curso3 = new Curso("Geometría", "Eratóstenes");
                //Crear un par de alumnos
            Alumno alumno1 = new Alumno("Maxwell", "Edison");
                alumno1.getCursos().add(curso1);
                alumno1.getCursos().add(curso3);
            Alumno alumno2 = new Alumno("Lucy", "in the Sky with Diamonds");
                alumno2.getCursos().add(curso1);
                alumno2.getCursos().add(curso2);

            em.persist(alumno1);
            em.persist(alumno2);

            em.getTransaction().commit();
            System.out.println(alumno1);
            System.out.println(alumno2);

                //Eliminar unos cuantos cursitous
            em.getTransaction().begin();
            Curso c1 = em.find(Curso.class, curso1.getId());
            Curso c2 = em.find(Curso.class, curso2.getId());

            /*alumno1.getCursos().remove(c1);
            alumno2.getCursos().remove(c2);*/
            alumno1.removeCurso(c1);
            alumno2.removeCurso(c2);

            em.getTransaction().commit();
            System.out.println(alumno1);
            System.out.println(alumno2);

        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
                //Cerrar la conexión
            em.close();
        }
    }
}
