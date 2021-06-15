package petstore.config;

import petstore.pojo.Category;
import petstore.pojo.Pet;
import petstore.pojo.Tag;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetTableTransformer implements TableTransformer<Pet> {
    @Override
    public Pet transform(DataTable dataTable) throws Throwable {
        return dataTable.cells()
                .stream()
                .skip(1)        // Skip header row
                .map(fields -> Pet.builder().id(Long.valueOf(fields.get(0)))
                        .name(fields.get(1)).category(Category.builder().id(getLongValueOrNull(fields.get(2))).name(fields.get(3)).build())
                        .photoUrls(getPhotoUrlsOrNull(fields.get(4)))
                        .tags(getTagOrNull(fields.get(5), fields.get(6)))
                        .status(fields.get(7))
                        .build())
                .findFirst().get();


    }

    private List<Tag> getTagOrNull(String tagId, String tagName) {
        if (getLongValueOrNull(tagId) == null && tagName == null) {
            return null;
        }
        List<Tag> tagList = new ArrayList<>();
        tagList.add(Tag.builder().id(getLongValueOrNull(tagId)).name(tagName).build());
        return tagList;
    }

    private List<String> getPhotoUrlsOrNull(String value) {
        if (value == null) {
            return null;
        }
        List list = new ArrayList();
        Arrays.stream(value.split(",")).forEach(it -> list.add(it));
        return list;
    }

    private Long getLongValueOrNull(String value) {
        try {
            return Long.valueOf(value);
        } catch (Exception e) {
            return null;
        }
    }
}
