package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    public String createUser(String email, String password, String name) {
        Response response = given()
                .header("Content-type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"name\":\"" + name + "\"}")
                .post(BASE_URL + "/api/auth/register");
        return response.jsonPath().getString("accessToken");
    }

    public void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/api/auth/user");
    }
}
