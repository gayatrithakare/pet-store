package petstore.config;

import petstore.pojo.Pet;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;

//https://www.baeldung.com/cucumber-data-tables
public class RegistryConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(
                new DataTableType(Pet.class, new PetTableTransformer())
        );
    }
}