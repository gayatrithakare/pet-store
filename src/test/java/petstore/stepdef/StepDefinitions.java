package petstore.stepdef;

import petstore.config.TestProperties;
import petstore.pojo.Category;
import petstore.pojo.Pet;
import petstore.pojo.Tag;
import petstore.util.JsonUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    private ExtractableResponse<Response> extract;

    private Pet pet;

    private TestProperties properties = TestProperties.getProperties();
    private String status;
    private String tags;


    @Given("A valid pet")
    public void a_valid_pet(Pet pet) {
        this.pet = pet;
    }


    @When("I request to create pet resource")
    public void i_request_to_create_pet_resource() {
        createPet(this.pet);
    }

    private void createPet(Pet pet) {
        String json = JsonUtil.convertToJsonString(pet);
        given().contentType("application/json")
                .body(json)
                .when().post(properties.getProperty("petstore.host") + "/api/v3/pet")
                .then()
                .assertThat()
                .statusCode(200);
    }

    private void updatePet(Pet pet) {
        String json = JsonUtil.convertToJsonString(pet);
        given().contentType("application/json")
                .body(json)
                .when().put(properties.getProperty("petstore.host") + "/api/v3/pet/")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Then("i should find new pet resource")
    public void i_should_find_new_pet_resource() {
        given()
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Then("newly created resource should have photo-url size have {int}")
    public void newly_created_resource_should_have_photo_url_size_have(Integer size) {
        given()
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .assertThat()
                .body("photoUrls.size()", Matchers.equalTo(size))
                .statusCode(200);
    }


    @Given("a existing pet")
    public void a_existing_pet(Pet pet) {
        this.pet = pet;
        createPet(pet);

    }


    @When("I request to update name to {string}")
    public void i_request_to_update_name_to(String string) {
        pet.setName(string);
        updatePet(pet);
    }

    @Then("pet should have new name {string}")
    public void pet_should_have_new_name(String updatedName) {
        given()
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .assertThat()
                .body("name", Matchers.equalTo(updatedName));
    }

    @When("I request to update category to {int} and category name to {string}")
    public void i_request_to_update_category_to(int categoryId, String categoryName) {
        pet.setCategory(Category.builder().id(Long.valueOf(categoryId)).name(categoryName).build());
        updatePet(pet);
    }

    @Then("pet should have new category id {int} and category name {string}")
    public void pet_should_have_new_category(int categoryId, String categoryName) {
        given()
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .assertThat()
                .body("category.id", Matchers.equalTo(categoryId))
                .body("category.name", Matchers.equalTo(categoryName));
    }

    @When("I request to add below tags to pet")
    public void i_request_to_add_below_tags_to_pet(List<String> tags) {

        tags.stream().forEach(
                it -> {
                    String[] split = it.split(",");
                    this.pet.getTags().add(new Tag(Long.valueOf(split[0]), split[1]));
                }
        );
        updatePet(this.pet);
    }

    @Then("pet should have new {int} number of tags")
    public void pet_should_have_new_number_of_tags(Integer size) {
        given()
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .assertThat()
                .body("tags.size()", Matchers.equalTo(size));
    }

    @When("I request to add below photo urls to pet")
    public void i_request_to_add_below_photo_urls_to_pet(List<String> urls) {
        this.pet.getPhotoUrls().addAll(urls);
        updatePet(this.pet);
    }

    @Then("pet should have new {int} number of photoUrls")
    public void pet_should_have_new_number_of_photo_urls(Integer size) {
        given()
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .assertThat()
                .body("photoUrls.size()", Matchers.equalTo(size));
    }


    @When("I request to update status to {string}")
    public void i_request_to_update_status_to(String status) {
        this.pet.setStatus(status);
        updatePet(this.pet);
    }

    @Then("pet should have status as  {string}")
    public void pet_should_have_status_as(String expectedStatus) {
        given()
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .assertThat()
                .body("status", Matchers.equalTo(expectedStatus));
    }

    @When("I request to delete pet with id {int}")
    public void i_request_to_delete_pet_with_id(Integer int1) {
        extract = given()
                .when().delete(properties.getProperty("petstore.host") + "/api/v3/pet/" + pet.getId())
                .then()
                .extract();
    }

    @Then("I should get status as {int}")
    public void i_should_get_status_as(Integer status) {
        Assert.assertEquals(Integer.valueOf(extract.statusCode()), status);
    }


    @Given("I search pet with status {string}")
    public void i_search_pet_with_status(String status) {
        this.status = status;
    }

    @Then("I should find total {int} of pets")
    public void i_should_find_total_of_pets(Integer size) {
        given()
                .queryParam("status", this.status)
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("$.size", Matchers.equalTo(size));
    }

    @Given("I search pet with tag {string}")
    public void i_search_pet_with_tag(String tags) {
        this.tags=tags;
    }
    @Then("I should find {int} pets with tags")
    public void i_should_find_pets_with_tags(Integer size) {
        given()
                .queryParam("tags", this.tags)
                .when().get(properties.getProperty("petstore.host") + "/api/v3/pet/findByTags")
                .then()
                .statusCode(200)
                .body("$.size", Matchers.equalTo(size));

    }



}
