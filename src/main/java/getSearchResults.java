import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.UnsupportedEncodingException;

import static io.restassured.RestAssured.given;

public class getSearchResults {
    public static String zwsId = "X1-ZWz16we0toi1or_ahuyo";
    public static String addressEncoded;
    public static String zipCodeEncoded;

    public static void getResults(String address, String zipCode) throws UnsupportedEncodingException {

        addressEncoded = helperMethods.encode(address);
        zipCodeEncoded = helperMethods.encode(zipCode);

        RestAssured.baseURI = "https://www.zillow.com/webservice";

        Response response = given()
                .contentType(ContentType.URLENC)
                .param("zws-id", zwsId)
                .param("address", addressEncoded)
                .param("citystatezip", zipCodeEncoded)
                .when()
                .get("/GetDeepSearchResults.htm");

        System.out.println(response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());

    }
}
