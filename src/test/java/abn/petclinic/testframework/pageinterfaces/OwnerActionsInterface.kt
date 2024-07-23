package abn.petclinic.testframework.pageinterfaces

import abn.petclinic.testframework.dataclasses.OwnerForTests
import abn.petclinic.testframework.dataclasses.PetForTests
import abn.petclinic.testframework.dataclasses.VisitForTests
import io.restassured.response.Response

interface OwnersActionsInterface:GeneralPageInterface {


    fun getOwnersList(ownerLastName:String, expectedResponseCode: Int): Response

    fun getAllOwnersList(expectedResponseCode: Int): Response

    fun getOwnerById(ownerId: String, expectedResponseCode: Int): Response

    fun createOwner(newOwner: OwnerForTests, expectedResponseCode: Int): Response

    fun updateOwner(ownerId: String, updatedOwner: OwnerForTests, expectedResponseCode: Int): Response

    fun deleteOwner(ownerId: String, expectedResponseCode: Int): Response


    fun getPetByOwnerIdAndPetId(ownerId: String, petId: String, expectedResponseCode: Int): Response

    fun updatePet(ownerId: String, petId: String, updatedPet: PetForTests, expectedResponseCode: Int): Response

    fun addPetToOwner(ownerId: String, newPet: PetForTests, expectedResponseCode: Int): Response

    fun addVisitToPet(ownerId: String, petId: String, newVisit: VisitForTests, expectedResponseCode: Int): Response
}

