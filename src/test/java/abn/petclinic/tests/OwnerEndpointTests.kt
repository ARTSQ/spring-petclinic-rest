package abn.petclinic.tests

import abn.petclinic.testframework.pages.OwnerEndpointActions.addPetToOwner
import abn.petclinic.testframework.pages.OwnerEndpointActions.createOwner
import abn.petclinic.testframework.pages.OwnerEndpointActions.deleteOwner
import abn.petclinic.testframework.pages.OwnerEndpointActions.endpointName
import abn.petclinic.testframework.pages.OwnerEndpointActions.getAllOwnersList
import abn.petclinic.testframework.pages.OwnerEndpointActions.getOwnerById
import abn.petclinic.testframework.pages.OwnerEndpointActions.getOwnersList
import abn.petclinic.testframework.pages.OwnerEndpointActions.updateOwner
import abn.petclinic.testframework.testdata.datasources.OwnerTestData
import abn.petclinic.testframework.testdata.datasources.PetTestData
import abn.petclinic.testframework.testdata.enums.OwnerTestTemplates
import abn.petclinic.testframework.testdata.providers.*
import abn.petclinic.testframework.utils.allureStep
import abn.petclinic.testframework.utils.extractOwnerId
import abn.petclinic.testframework.utils.setSeverity
import abn.petclinic.testframework.utils.validate
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import io.restassured.RestAssured.*
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import kotlin.test.assertEquals

class OwnerEndpointTests {


    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll(): Unit {
            //TODO: switch to config properties instead of hardcode url/port
            baseURI = "http://localhost:9966";
            basePath = "/petclinic/api";
        }
    }

    @ParameterizedTest(name = "{1}")
    @Feature("Owner-level operations")
    @Story("Add new owner")
    @ArgumentsSource(OwnersCreationTestDataProvider::class)
    @DisplayName("Owner creation test:")
    fun createNewOwnerTest(testData: OwnerTestData, description: String, severity:SeverityLevel ) {
        setSeverity(severity)
        val newOwner = testData.ownerData
        val expectedCode = testData.expectedResponseCode
        val response  = createOwner(newOwner,expectedCode)
        if (expectedCode == 201) {
            response.validate {
                validateOwnerInfo(newOwner)
                validateOwnerDoesNotHavePets()
            }
        }
        if (expectedCode == 400){
            getAllOwnersList(200).validate {
                validateListDoesNotContainsOwner(newOwner)
            }
        }
    }

    @Test
    @Feature("Owner-level operations")
    @Story("Add new owner")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Owner creation test: malformed JSON")
    fun createNewOwnerMalformedTest() {

        allureStep("First Step") {
            val response = given()
                .contentType(ContentType.JSON)
                .body(
                    """
                {
                  "firstName": "George",
                  "lastName": "Franklin",
                  "address": "110 W. Liberty St.",
                  "city": "Madison",
                  "telephone": "6085551023"
                """.trimIndent()
                )
                .`when`()
                .post("/$endpointName")
                .then()
                .extract()
                .response()
            assertEquals(400, response.statusCode)
        }
    }

    @Test
    @Feature("Owner-level operations")
    @Story("Add new owner")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Owner creation test: absent field")
    fun createNewOwnerAbsentFieldTest() {
        val response = given()
            .contentType(ContentType.JSON)
            .body("""
                {
                  "firstName": "George",
                  "address": "110 W. Liberty St.",
                  "city": "Madison",
                  "telephone": "6085551023"
                  }
                """.trimIndent())
            .`when`()
            .post("/$endpointName")
            .then()
            .extract()
            .response()
        assertEquals(400, response.statusCode)
    }

    @ParameterizedTest(name = "{1}")
    @Feature("Owner-level operations")
    @Story("Modify owner")
    @ArgumentsSource(OwnersModificationTestDataProvider::class)
    @DisplayName("Owner update test:")
    fun updateOwnerTest(testData: OwnerTestData, description: String, severity:SeverityLevel ) {
        setSeverity(severity)

        val originalOwnerData = OwnerTestTemplates.BASIC_OWNER2.getOwner()
        val updatedOwner = testData.ownerData
        val expectedOwner =  testData.ownerData
        val expectedCode = testData.expectedResponseCode
        val responseInitial = createOwner(originalOwnerData,201)
        val id = responseInitial.extractOwnerId()
        expectedOwner.id = id

        val response = updateOwner(id,updatedOwner,expectedCode)
        if (expectedCode == 204) {
            response.validate{ validateEmptyBody()}
            getOwnerById(id,200).validate {
                validateOwnerInfo(expectedOwner,true)
            }
        }
        if (expectedCode == 400){
            originalOwnerData.id = id
            getOwnerById(id,200).validate {
                validateOwnerInfo(originalOwnerData,true)
            }
        }
    }

    @Test
    @Feature("Owner-level operations")
    @Story("Modify owner")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Owner update: malformed JSON")
    fun updateOwnerMalformedTest() {
        val originalOwnerData = OwnerTestTemplates.BASIC_OWNER2.getOwner()
        val responseInitial = createOwner(originalOwnerData,201)
        val id = responseInitial.extractOwnerId()
        val response = given()
            .pathParams("ownerId",id)
            .contentType(ContentType.JSON)
            .body("""
                {
                  "firstName": "George",
                  "lastName": "Franklin",
                  address: 110 W. Liberty St.,
                  "city": "Madison",
                  "telephone": "6085551023"
                  }
                """.trimIndent())
            .`when`()
            .put("/$endpointName/{ownerId}")
            .then()
            .extract()
            .response()
        assertEquals(400, response.statusCode)
    }

    @Test
    @Feature("Owner-level operations")
    @Story("Modify owner")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Owner update: absent field")
    fun updateOwnerAbsentFieldTest() {
        val originalOwnerData = OwnerTestTemplates.BASIC_OWNER2.getOwner()
        val responseInitial = createOwner(originalOwnerData,201)
        val id = responseInitial.extractOwnerId()

        val response = given()
            .pathParams("ownerId",id)
            .contentType(ContentType.JSON)
            .body("""
                {
                  "firstName": "George",
                  "address": "110 W. Liberty St.",
                  "city": "Madison",
                  "telephone": "6085551023"
                  }
                """.trimIndent())
            .`when`()
            .post("/$endpointName/{ownerId}")
            .then()
            .extract()
            .response()
        assertEquals(400, response.statusCode)
    }

    @Test@Feature("Owner-level operations")
    @Story("Get owners list")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Get full owners list")
    fun getOwnersListTest() {
        val newOwner = OwnerTestTemplates.BASIC_OWNER2.getOwner()
        val responseInitial = createOwner(newOwner,201)
        createOwner(OwnerTestTemplates.BASIC_OWNER.getOwner(),201)
        newOwner.id = responseInitial.extractOwnerId()

        val ownersList = getAllOwnersList(200)
        ownersList.validate { validateBodyContainsOwnerWithIdInList(newOwner)
            validateOwnersListSize(2,true)
        }
    }

    @Test
    @Feature("Owner-level operations")
    @Story("Get owners list")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Get full owners list when no owners registered")
    @Disabled("This test is disabled: deeper framework integration required")
    fun getFullOwnersListTestUponEmpty() {
        //TODO: requires direct test database manipulation
    }

    @Test
    @Feature("Owner-level operations")
    @Story("Get owners list")
    @DisplayName("Get owners list by last name")
    fun getOwnersListByLastNameTest() {
        val newOwner1 = OwnerTestTemplates.BASIC_OWNER.getOwner()
        val newOwner2 = OwnerTestTemplates.BASIC_OWNER2.getOwner()
        val response1 = createOwner(newOwner1,201)
        val response2 = createOwner(newOwner2,201)
        newOwner1.id = response1.extractOwnerId()
        newOwner2.id = response2.extractOwnerId()

        val ownersList = getOwnersList(newOwner1.lastName,200)
        ownersList.validate {
            validateBodyContainsOwnerWithIdInList(newOwner1)
            validateListDoesNotContainsOwner(newOwner2)
        }
    }

    @Test
    @Feature("Owner-level operations")
    @Story("Get owners list")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get full owners list: last name not existing")
    fun getOwnersListByLastNameNegativeTest(){
        createOwner(OwnerTestTemplates.BASIC_OWNER.getOwner(),201)
        getOwnersList("DefinitelyNotExisting",404)
    }

    @ParameterizedTest(name = "{1}")
    @Feature("Owner-level operations")
    @Story("Delete owner")
    @ArgumentsSource(OwnersDeletionTestDataProvider::class)
    @DisplayName("Owner update test:")
    fun ownerDeletionTest(testData: OwnerTestData, description: String, severity:SeverityLevel){
        setSeverity(severity)

        val newOwner = testData.ownerData
        val expectedCode = testData.expectedResponseCode
        val creationResponse = createOwner(newOwner,201)

        val id = newOwner.id ?: creationResponse.extractOwnerId()

        val response  = deleteOwner(id,expectedCode)
        if (expectedCode == 204) {
            response.validate {validateEmptyBody()}
        }
    }

    @ParameterizedTest(name = "{1}")
    @Feature("Owner-level operations")
    @Story("Delete owner")
    @ArgumentsSource(OwnerGetByIdTestDataProvider::class)
    @DisplayName("Owner deletion test:")
    fun ownerGetByIdTest(testData: OwnerTestData, description: String, severity:SeverityLevel){
        setSeverity(severity)

        val newOwner = testData.ownerData
        val expectedCode = testData.expectedResponseCode
        val creationResponse = createOwner(newOwner,201)
        val id = newOwner.id ?: creationResponse.extractOwnerId()

        val response  = getOwnerById(id,expectedCode)
        if (expectedCode == 200) {
            val expectedOwner = newOwner.copy(id = id)
            response.validate {validateOwnerInfo(expectedOwner,true)}
        }
    }

    @ParameterizedTest(name = "{1}")
    @Feature("Pet-level operations")
    @Story("Add new pet")
    @ArgumentsSource(AdditionToOwnerTestDataProvider::class)
    @DisplayName("Add pet to owner test:")
    fun addPetToOwnerTest(testData: PetTestData, description: String, severity:SeverityLevel){
        setSeverity(severity)
        val addedPet = testData.petData
        val newOwner = OwnerTestTemplates.BASIC_OWNER.getOwner()
        val expectedCode = testData.expectedResponseCode

        val ownerCreationResponse = createOwner(newOwner,201)
        val ownerId = ownerCreationResponse.extractOwnerId()
        newOwner.id = ownerId

        val response = addPetToOwner(ownerId,addedPet,expectedCode)

        if (expectedCode == 201) {
            val expectedPet = addedPet.copy(ownerId=ownerId)
            response.validate {validatePetInfo(expectedPet,false,true)}
        }
    }

    @Test
    @DisplayName("Get owner's pet by ID")
    @Disabled("This test is not yet implemented")
    fun getOwnerPetByIDTest(){
        //TODO: Add test
    }

    @Test
    @DisplayName("Update pet's details")
    @Disabled("This test is not yet implemented")
    fun updatePetDetailTest(){
        //TODO: Add test
    }

    @Test
    @DisplayName("Add new visit for owner's pet")
    @Disabled("This test is not yet implemented")
    fun addNewVisitForOwnerTest(){
        //TODO: Add test
    }






}
