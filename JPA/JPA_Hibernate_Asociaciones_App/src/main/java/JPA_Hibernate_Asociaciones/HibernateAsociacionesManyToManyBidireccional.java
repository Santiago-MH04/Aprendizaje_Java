package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Alumno;
import JPA_Hibernate_Asociaciones.Entity.Curso;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToManyBidireccional {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Jugar con la transaccionalidad
        try{
            em.getTransaction().begin();
                //Crear una terceta de cursos
            Curso curso1 = new Curso("Cocina", "Chefsito");
            Curso curso2 = new Curso("Carrera", "Speedy González");
            Curso curso3 = new Curso("Natación", "Tritón");
                //Crear un par de alumnos
            Alumno alumno1 = new Alumno("Alonso", "Quijano");
                alumno1.addCurso(curso1)
                        .addCurso(curso3);
            Alumno alumno2 = new Alumno("Sancho", "Panza");
                alumno2.addCurso(curso1)
                        .addCurso(curso2);

            em.persist(alumno1);
            em.persist(alumno2);

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
