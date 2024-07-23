package abn.petclinic.testframework.utils
import abn.petclinic.testframework.dataclasses.OwnerForTests
import abn.petclinic.testframework.dataclasses.PetForTests
import com.fasterxml.jackson.core.type.TypeReference
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull

class Validators (private val response: Response){
    private val typeReferenceOwner = object : TypeReference<List<OwnerForTests>>() {}
    private val typeReferencePet = object : TypeReference<List<PetForTests>>() {}

    fun validateEmptyBody() {
        assertEquals(response.body().asString(),"")
    }

    fun validateOwnerInfo(expected: OwnerForTests, idIsMatched: Boolean?=false) {
        val actual = response.deserializeBody(OwnerForTests::class.java)
        assertEquals(expected.ownerInfo(), actual.ownerInfo(),"Owner info is not matched. Expected:${expected.ownerInfo()} Actual:${actual.ownerInfo()}")
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
        val actualList = response.deserializeBody(typeReferenceOwner)
        assertTrue(actualList.count { it.id == expectedOwner.id } == 1)
        val actualOwner = actualList.find { it.id == expectedOwner.id }
        assertNotNull(actualOwner,"Owner with id: ${expectedOwner.id} not found in response")
        assertEquals(expectedOwner.ownerInfo(), actualOwner.ownerInfo(),"Owner info is not matched. Expected:${expectedOwner.ownerInfo()} Actual:${actualOwner.ownerInfo()}")
    }


    fun validateOwnersListSize(size: Int,greaterOrEqual: Boolean?=false) {
        val actualList = response.deserializeBody(typeReferenceOwner)
        if (greaterOrEqual == true) {
            assertTrue(actualList.size >= size)
        } else {
            assertEquals(size, actualList.size)
        }
    }

    fun validateListDoesNotContainsOwner(owner: OwnerForTests) {
        val actualList = response.deserializeBody(typeReferenceOwner)
        assertFalse(actualList.any { it.id == owner.id || it.lastName == owner.lastName })
    }

    fun validateOwnerDoesNotHavePets(){
        val actual = response.deserializeBody(OwnerForTests::class.java)
        assertTrue(actual.pets.isNullOrEmpty())
    }

    fun validatePetInfo(expected: PetForTests, idIsMatched: Boolean?=false,typeIdIsMatched: Boolean?=false) {
        val actual = response.deserializeBody(PetForTests::class.java)
        assertEquals(expected.petBio(), actual.petBio(),"Pet info did not match. Expected:${expected.petBio()} Actual:${actual.petBio()}")
        assertNotNull(actual.type)
        assertEquals(expected.type?.name, actual.type.name,"Pet type name did not match. Expected: ${expected.type?.name}, Actual: ${actual.type.name}")
        if(expected.id==null){
            assertNotNull(actual.id,"No id found in response")
        } else{
            if (idIsMatched == true) {
                assertEquals(expected.id,actual.id,"id is not matching")}
            else{
                assertNotEquals(expected.id,actual.id,"id is actually matching")
            }
        }

        if(expected.type?.id==null){
            assertNotNull(actual.type.id,"No id found in response")
        } else{
            if (typeIdIsMatched == true) {
                assertEquals(expected.type.id,actual.type.id,"type ids are not matching")}
            else{
                assertNotEquals(expected.type.id,actual.type.id,"type ids are actually matching")
            }
        }
    }


}
