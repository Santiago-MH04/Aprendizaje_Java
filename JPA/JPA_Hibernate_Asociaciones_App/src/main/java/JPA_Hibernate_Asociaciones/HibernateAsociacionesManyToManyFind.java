package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Alumno;
import JPA_Hibernate_Asociaciones.Entity.Curso;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToManyFind {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Jugar con la transaccionalidad
        try{
            em.getTransaction().begin();
                //Buscar una terceta de cursos
            Curso curso1 = em.find(Curso.class, 1L);
                /*Curso curso1 = new Curso("Arquitectura", "Vitrubio");*/
            Curso curso2 = em.find(Curso.class, 2L);
                /*Curso curso2 = new Curso("Literatura", "Ovidio");*/
            Curso curso3 = em.find(Curso.class, 3L);
                /*Curso curso3 = new Curso("Leyes", "Cicerón");*/

                //Buscar un par de alumnos
            Alumno alumno1 = em.find(Alumno.class, 1L);
                alumno1.getCursos().add(curso1);
                alumno1.getCursos().add(curso3);
            Alumno alumno2 = em.find(Alumno.class, 2L);
                alumno2.getCursos().add(curso1);
                alumno2.getCursos().add(curso2);

            /*em.persist(alumno1);  //Deja de ser estrictamente necesario
            em.persist(alumno2);*/

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
