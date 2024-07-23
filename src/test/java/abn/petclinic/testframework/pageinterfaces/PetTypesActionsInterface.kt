package abn.petclinic.testframework.pageinterfaces

import abn.petclinic.testframework.dataclasses.PetTypeForTests

interface PetTypesActionsInterface:GeneralPageInterface {
    fun getAllPetTypes(expectedResponseCode: Int): Set<PetTypeForTests>
    fun getPetTypeById(id: Int, expectedResponseCode: Int): PetTypeForTests
    fun createPetType(newPetType: String,expectedResponseCode: Int): PetTypeForTests
    fun updatePetType(id:Int, newPetType: String,expectedResponseCode: Int): PetTypeForTests
    fun deletePetType(id: Int,expectedResponseCode: Int)
}
