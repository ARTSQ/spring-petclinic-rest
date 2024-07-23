package abn.petclinic.testframework.dataclasses

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PetForTests(
    val name: String,
    val birthDate: String,
    val type: PetTypeForTests?=null,
    var id: String? =null,
    var ownerId: String? = null,
    var visits: List<VisitForTests>?=null
){
    fun petBio()= this.copy(visits = null,id = null, type=null)
}
