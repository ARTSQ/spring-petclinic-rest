package abn.petclinic.testframework.testdata.providers

import abn.petclinic.testframework.testdata.datasources.petsAdditionToOwnerTestData
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class AdditionToOwnerTestDataProvider: ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return petsAdditionToOwnerTestData.stream().map { Arguments.of(it, it.getDescription()) }
    }
}
