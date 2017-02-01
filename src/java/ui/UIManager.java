
package ui;

import domain.Student;
import facadeDoor.SessionFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author User
 */

@Named
@RequestScoped
public class UIManager implements Serializable {
    
    private String input;
    private String output;
    
    @Inject
    private SessionFacade facade;

    public UIManager() {
    }
    
    public void submit(){
        facade.addStudent(input);
        //output = input + " Submitted";
        input = "";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        List<Student> result = facade.getAll();
        for (Student s : result){
            output += s.getId() + " " + s.getName() + ". \r";
        }
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    
}
