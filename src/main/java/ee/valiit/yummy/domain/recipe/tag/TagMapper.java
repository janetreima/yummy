package ee.valiit.yummy.domain.recipe.tag;

import ee.valiit.yummy.business.tag.TagDto;
import org.mapstruct.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {

    @Mapping(source = "id", target = "tagId")
    @Mapping(source = "name", target = "tagName")
    TagDto toTagDto(Tag tag);

    List<TagDto> toTagDtos(List<Tag> tags);

}