package abn.petclinic.testframework.pages

import abn.petclinic.testframework.dataclasses.PetTypeForTests
import abn.petclinic.testframework.pageinterfaces.PetTypesActionsInterface

object PetTypesEndpointActions : PetTypesActionsInterface {
    override val endpointName = "pet"


    override fun getAllPetTypes(expectedResponseCode: Int): Set<PetTypeForTests> {
        TODO("Not yet implemented")
    }

    override fun getPetTypeById(id: Int, expectedResponseCode: Int): PetTypeForTests {
        TODO("Not yet implemented")
    }

    override fun createPetType(newPetType: String, expectedResponseCode: Int): PetTypeForTests {
        TODO("Not yet implemented")
    }

    override fun updatePetType(id: Int, newPetType: String, expectedResponseCode: Int): PetTypeForTests {
        TODO("Not yet implemented")
    }

    override fun deletePetType(id: Int, expectedResponseCode: Int) {
        TODO("Not yet implemented")
    }
}
