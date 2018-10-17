package reqres;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import reqres.objects.ResponseDTO;

import java.util.ArrayList;

public class Stepdef {


    ReqRes reqRes ;

    ArrayList<ResponseDTO> responseDTOArrayList = new ArrayList<>();

    @Given("I am having acess to reqres")
    public void accessReqres(){
        reqRes = new ReqRes("https://reqres.in");
    }

    @When("I create the user")
    public void createUser(){

        responseDTOArrayList.add( reqRes.createUser("Tester1", "Tester"));
        responseDTOArrayList.add( reqRes.createUser("Tester2", "Tester"));
        responseDTOArrayList.add( reqRes.createUser("Tester3", "Tester"));
        responseDTOArrayList.add( reqRes.createUser("Tester4", "Tester"));
        responseDTOArrayList.add( reqRes.createUser("Tester5", "Tester"));

    }

    @Then("Validate the user details")
    public void validateUserDetails(){
        for (ResponseDTO responseDTO : responseDTOArrayList) {
            Assert.assertEquals(responseDTO.getName(),reqRes.getUserByID(responseDTO.getId()).getName());
            System.out.println("Okay");
        }
    }
}
