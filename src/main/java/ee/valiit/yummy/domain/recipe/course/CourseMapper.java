package ee.valiit.yummy.domain.recipe.course;

import ee.valiit.yummy.business.recipe.dto.CourseInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {

    @Mapping(source = "id", target = "courseId")
    @Mapping(source = "name", target = "courseName")
    @Mapping(constant = "false", target = "isAvailable")
    CourseInfo toCourseDto(Course course);

    List<CourseInfo> toCourseDtos(List<Course> courses);

}