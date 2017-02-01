/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeDoor;

import domain.Student;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */

//directly speaking with the interface gives us flexibility to deal as we wish behind the scenes
@Local
public interface SessionFacade {
    
    List<Student> getAll();
    void addStudent(String name);
       
    
}
