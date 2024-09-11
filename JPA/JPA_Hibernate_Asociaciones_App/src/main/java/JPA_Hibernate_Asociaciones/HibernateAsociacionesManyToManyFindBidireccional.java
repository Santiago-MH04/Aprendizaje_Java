package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Alumno;
import JPA_Hibernate_Asociaciones.Entity.Curso;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToManyFindBidireccional {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Jugar con la transaccionalidad
        try{
            em.getTransaction().begin();
                //Crear una terceta de cursos
            Curso curso1 = em.find(Curso.class, 1L);
            Curso curso2 = em.find(Curso.class, 2L);
            Curso curso3 = em.find(Curso.class, 3L);
                //Crear un par de alumnos
            Alumno alumno1 = em.find(Alumno.class, 1L);
                alumno1.addCurso(curso1)
                        .addCurso(curso3);
            Alumno alumno2 = em.find(Alumno.class, 2L);
                alumno2.addCurso(curso1)
                        .addCurso(curso2);

            /*em.persist(alumno1);
            em.persist(alumno2);*/

            em.getTransaction().commit();
            System.out.println(alumno1);
            System.out.println(alumno2);

                //Eliminar unos cuantos cursitous
            em.getTransaction().begin();
            Curso c1 = em.find(Curso.class, curso1.getId());
            Curso c2 = em.find(Curso.class, curso2.getId());

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
