package reqres;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.rest.SerenityRest;
import reqres.objects.ResponseDTO;

public class ReqRes {

    String baseURI;

    public ReqRes(String baseURI) {
        this.baseURI = baseURI;
    }

    public void getUser (){
        String resposne = SerenityRest.with().header("Content-Type","application/json").
                when().get(baseURI+"/api/users?page=2").
                then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(resposne);
    }
    public ResponseDTO createUser(String name, String job){
        JsonParser parser = new JsonParser();
        JsonObject jsonObj = (JsonObject) parser.
                parse("{\"name\": "+name+",\"job\": "+job+"}");

        String resposne = SerenityRest.with().header("Content-Type","application/json").body(jsonObj).
                when().post(baseURI+"/api/users").
                then().assertThat().statusCode(201).extract().response().asString();
        System.out.println(resposne);

        ResponseDTO responseDTO = new Gson().fromJson(resposne,ResponseDTO.class);
        System.out.println(responseDTO.getId());
        System.out.println("OK");

        return responseDTO;
    }

    public ResponseDTO getUserByID (String id){
        String resposne = SerenityRest.with().header("Content-Type","application/json").
                when().get(baseURI+"/api/users/"+id).
                then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(resposne);
        ResponseDTO responseDTO = new Gson().fromJson(resposne,ResponseDTO.class);
        return responseDTO;
    }
}
