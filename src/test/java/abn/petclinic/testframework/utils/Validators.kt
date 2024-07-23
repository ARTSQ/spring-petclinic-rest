package abn.petclinic.testframework.utils
import abn.petclinic.testframework.dataclasses.OwnerForTests
import com.fasterxml.jackson.core.type.TypeReference
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class Validators (private val response: Response){
    private val typeReference = object : TypeReference<List<OwnerForTests>>() {}

    fun validateBody(expected: String) {
        assertEquals(expected, response.body().asString())
    }

    fun validateEmptyBody() {
        assertEquals(response.body().asString(),"")
    }

    fun validateOwnerData(expected: OwnerForTests, idIsMatched: Boolean?=false) {
        //val actual = deserializeJson(response.body().asString(), OwnerForTests::class.java)
        val actual = response.deserializeBody(OwnerForTests::class.java)
        //comparing fields one by one since equals on whole object is not suitable.
        //TODO: Replace with AssertJ comparison when Allure is added
        assertEquals(expected.firstName, actual.firstName,"firstName is not matching")
        assertEquals(expected.lastName, actual.lastName, "lastName is not matching")
        assertEquals(expected.city, actual.city, "city is not matching")
        assertEquals(expected.address, actual.address, "address is not matching")
        assertEquals(expected.telephone,actual.telephone, "telephone is not matching")
        if(expected.id==null){
            assertNotNull(actual.id,"No id found in response")
        } else{
            if (idIsMatched == true) {
                assertEquals(expected.id,actual.id,"id is not matching")} else{
                assertNotEquals(expected.id,actual.id,"id is actually matching")
            }
        }
    }

    fun validateBodyContainsOwnerWithIdInList(expectedOwner: OwnerForTests) {
        val actualList = response.deserializeBody(typeReference)
        assertTrue(actualList.count { it.id == expectedOwner.id } == 1)
        val actualOwner = actualList.find { it.id == expectedOwner.id }
        assertNotNull(actualOwner,"Owner with id: ${expectedOwner.id} not found in response")
        assertEquals(expectedOwner.firstName, actualOwner.firstName,"firstName is not matching")
        assertEquals(expectedOwner.lastName, actualOwner.lastName, "lastName is not matching")
        assertEquals(expectedOwner.city, actualOwner.city, "city is not matching")
        assertEquals(expectedOwner.address, actualOwner.address, "address is not matching")
        assertEquals(expectedOwner.telephone,actualOwner.telephone, "telephone is not matching")

    }


    fun validateOwnersListSize(size: Int,greaterOrEqual: Boolean?=false) {
        val actualList = response.deserializeBody(typeReference)
        if (greaterOrEqual == true) {
            assertTrue(actualList.size >= size)
        } else {
            assertEquals(size, actualList.size)
        }
    }

    fun validateListDoesNotContainsOwner(owner: OwnerForTests) {
        val actualList = response.deserializeBody(typeReference)
        assertFalse(actualList.any { it.id == owner.id || it.lastName == owner.lastName })
    }

    fun validateOwnerDoesNotHavePets(){
        val actual = response.deserializeBody(OwnerForTests::class.java)
        assertTrue(actual.pets.isNullOrEmpty())
    }


}
