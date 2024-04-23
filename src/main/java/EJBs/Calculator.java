package EJBs;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Stateless
@Entity
public class Calculator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int number1;
    public int number2;
    public String operation;

    public Calculator() {}

    public Calculator(int operand1, int operand2, String operation) {
        this.number1 = operand1;
        this.number2 = operand2;
        this.operation = operation;
    }

   

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperand1(int operand1) {
        this.number1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.number2 = operand2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}