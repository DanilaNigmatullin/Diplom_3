package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.UserModel;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    @Step("Создать тестового пользователя через API")
    public String createUser(String email, String password, String name) {
        UserModel user = new UserModel(email, password, name);
        Response response = given()
                .header("Content-type", "application/json")
                .body(user)
                .post(BASE_URL + "/api/auth/register");
        return response.jsonPath().getString("accessToken");
    }

    @Step("Удалить тестового пользователя через API")
    public void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/api/auth/user");
    }
}