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
    public int operand1;
    public int operand2;
    public String operation;
    public int result;

    public Calculator() {}

    public Calculator(int operand1, int operand2, String operation, int result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.result = result;
    }

   

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public String getOperation() {
        return operation;
    }

    public int getResult() {
        return result;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setResult(int result) {
        this.result = result;
    }
}