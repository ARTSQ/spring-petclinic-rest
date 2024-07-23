package abn.petclinic.testframework.pages

import abn.petclinic.testframework.dataclasses.OwnerForTests
import abn.petclinic.testframework.dataclasses.PetForTests
import abn.petclinic.testframework.dataclasses.VisitForTests
import abn.petclinic.testframework.pageinterfaces.OwnersActionsInterface
import com.fasterxml.jackson.core.type.TypeReference
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.response.Response
import kotlin.test.assertEquals

object OwnerEndpointActions : OwnersActionsInterface {
    override val endpointName: String  = "owners"


    override fun getOwnersList(ownerLastName:String,expectedResponseCode: Int): Response {
        val  response = given()
            .queryParam("lastName", ownerLastName)
            .`when`()
            .get("/$endpointName")
            .then()
            .extract()
            .response()
        assertEquals(expectedResponseCode, response.statusCode)
        return response
    }

//    fun getOwnersList2(expectedResponseCode: Int): Array<OwnerForTests> {
//        val typeReference = object : TypeReference<List<OwnerForTests>>() {}
//        //var result: List<OwnerForTests> = listOf()
//        val  response = given()
//            .`when`()
//            .get("/$endpointName")
//            .then()
//            .extract()
//            .response()
//        assertEquals(expectedResponseCode, response.statusCode)
//        return response.body.`as`(Array<OwnerForTests>::class.java)
//    }

    override fun getAllOwnersList(expectedResponseCode: Int): Response {
        val response = given()
            .`when`()
            .get("/$endpointName")
            .then()
            .extract()
            .response()
        assertEquals(expectedResponseCode, response.statusCode)
        return response
    }



    override fun getOwnerById(ownerId: String, expectedResponseCode: Int): Response {
        val response = given()
            .pathParams("ownerId", ownerId)
            .`when`()
            .get("/$endpointName/{ownerId}")
            .then()
            .extract()
            .response()
        assertEquals(expectedResponseCode, response.statusCode)
        return response
    }

//    fun getOwnerById2(ownerId: String, expectedResponseCode: Int): OwnerForTests {
//        val response = given()
//            .pathParams("ownerId", ownerId)
//            .`when`()
//            .get("/$endpointName/{ownerId}")
//            .then()
//            .extract()
//            .response()
//        assertEquals(expectedResponseCode, response.statusCode)
//        return response.body.`as`(OwnerForTests::class.java)
//    }

    override fun createOwner(newOwner: OwnerForTests, expectedResponseCode: Int): Response {
        val response = given()
            .contentType(ContentType.JSON)
            .log().all()
            .body(newOwner)
            .`when`()
            .post("/$endpointName")
            .then()
            .extract()
            .response()
        assertEquals(expectedResponseCode, response.statusCode)
        return response
    }

    override fun updateOwner(ownerId: String, updatedOwner: OwnerForTests, expectedResponseCode: Int): Response {
        val response = given()
            .contentType(ContentType.JSON)
            .body(updatedOwner)
            .pathParams("ownerId", ownerId)
            .`when`()
            .put("/$endpointName/{ownerId}")
            .then()
            .extract()
            .response()
        assertEquals(expectedResponseCode, response.statusCode)
        return response
    }

    override fun deleteOwner(ownerId: String, expectedResponseCode: Int): Response {
        val response = given()
            .pathParams("ownerId", ownerId)
            .`when`()
            .delete("/$endpointName/{ownerId}")
            .then()
            .extract()
            .response()
        assertEquals(expectedResponseCode, response.statusCode)
        return response
    }

    override fun getPetByOwnerIdAndPetId(ownerId: String, petId: String, expectedResponseCode: Int): Response {
        TODO("Not yet implemented")
    }

    override fun updatePet(ownerId: String, petId: String, updatedPet: PetForTests, expectedResponseCode: Int): Response {
        TODO("Not yet implemented")
    }

    override fun addPetToOwner(ownerId: String, newPet: PetForTests, expectedResponseCode: Int): Response {
        val response =

            given()
            .contentType(ContentType.JSON)
            .pathParams("ownerId", ownerId)
            .log().all()
            .body(newPet)
            .`when`()
            .post("/$endpointName/{ownerId}/pets")
            .then()
            .log().all()
            .extract()
            .response()
        assertEquals(expectedResponseCode, response.statusCode)
        return response
    }

    override fun addVisitToPet(
        ownerId: String,
        petId: String,
        newVisit: VisitForTests,
        expectedResponseCode: Int
    ): Response {
        TODO("Not yet implemented")
    }
}
