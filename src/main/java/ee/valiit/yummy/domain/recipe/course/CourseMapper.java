package ee.valiit.yummy.domain.recipe.course;

import ee.valiit.yummy.business.recipe.course.CourseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CourseDto toCourseDto(Course course);

    List<CourseDto> toCourseDtos(List<Course> courses);

}