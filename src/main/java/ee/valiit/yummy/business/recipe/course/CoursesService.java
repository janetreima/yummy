package ee.valiit.yummy.business.recipe.course;

import ee.valiit.yummy.business.recipe.dto.CourseInfo;
import ee.valiit.yummy.domain.recipe.course.Course;
import ee.valiit.yummy.domain.recipe.course.CourseMapper;
import ee.valiit.yummy.domain.recipe.course.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Resource
    private CourseService courseService;

    @Resource
    private CourseMapper courseMapper;

    public List<CourseInfo> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return courseMapper.toCourseDtos(courses);
    }
}
