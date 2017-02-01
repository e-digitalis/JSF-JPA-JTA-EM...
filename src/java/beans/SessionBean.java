
package beans;

import domain.Student;
import facadeDoor.SessionFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * testing session bean
 */

//this class hides behind the interface from the outside world
@Stateless
public class SessionBean implements Serializable, SessionFacade {
    
    @PersistenceContext(name = "StudentWebApplicationPU") //database manager
    private EntityManager em;
    
    public void addStudent(String name){
        Student student = new Student();
        student.setName(name);
        em.persist(student);
    }
 
    public List<Student> getAll(){
                //class query can be used together with Entity Manager
                //JPQL statement
        Query query = em.createQuery("SELECT s FROM Student as s");
        return query.getResultList();
    }
        
}
