package abn.petclinic.testframework.testdata.enums

import abn.petclinic.testframework.dataclasses.PetForTests
import abn.petclinic.testframework.dataclasses.PetTypeForTests
import abn.petclinic.testframework.utils.generateRandomPetTypeName
import org.springframework.samples.petclinic.model.PetType

enum class PetTypesTestTemplates(private val petType: PetTypeForTests, description: String) {
    EXISTING_PET_TYPE(PetTypeForTests("cat","1"),"Regular cat"),
    EXISTING_PET_TYPE_WITHOUT_ID(PetTypeForTests("cat"),"Regular cat, without id specified"),
    NEW_PET_TYPE(PetTypeForTests(generateRandomPetTypeName()),"Non existing pet type"),
    EXISTING_PET_TYPE_WITH_INCORRECT_ID(PetTypeForTests("cat","999"),"Pet type with incorrect id"),
    PET_TYPE_WITH_INCORRECT_NAME_FOR_ID(PetTypeForTests(generateRandomPetTypeName(),"1"),"Pet type name not matches id"),;


    fun getPetType(): PetTypeForTests {
        return petType
    }


}
