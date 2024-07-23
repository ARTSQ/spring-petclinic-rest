package abn.petclinic.testframework.utils
import abn.petclinic.testframework.dataclasses.OwnerForTests
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.restassured.response.Response
import kotlin.test.assertNotNull

val objectMapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

fun Response.extractOwnerId(): String{
    val id = this.deserializeBody(OwnerForTests::class.java).id
    assertNotNull(id)
    return id
}

fun Response.validate (action: Validators.() -> Unit){
    val validator = Validators(this)
    validator.action()
}

inline fun <reified T> Response.deserializeBody(valueType: Class<T>): T{
    return objectMapper.readValue(this.body().asString(), valueType)
}

fun <T> Response.deserializeBody(valueType: TypeReference<List<T>>): List<T> {
    return objectMapper.readValue(this.body().asString(), valueType)
}

fun generateRandomPetTypeName(): String {
    val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    return (1..8)
        .map { characters.random() }
        .joinToString("")
}
