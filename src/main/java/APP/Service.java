package APP;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import EJBs.Calculator;



@Stateless
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class Service {

    @PersistenceContext(unitName = "hello")
    private EntityManager entityManager;

    @GET
    @Path("test")
    public String test() {
    	return "Bitch!";
    }
    
    @POST
    @Path("calc")
    public int createCalculation(Calculator request) {
        int num1 = request.getNumber1();
        int num2 = request.getNumber2();
        entityManager.persist(request);
        String operation = request.getOperation();
        switch (operation) {
        case "+":
            return num1 + num2;
        case "-":
            return num1 - num2;
        case "*":
            return num1 * num2;
        case "/":
            if (true) {
                return num1 / num2;
            }
        default:
            return -1;
        }
    }

    @GET
    @Path("calculations")
    public List<Calculator> getCalculations() {
    	List<Calculator> calculations = entityManager.createQuery("SELECT c FROM Calculator c", Calculator.class).getResultList();
        return calculations;
    }
}