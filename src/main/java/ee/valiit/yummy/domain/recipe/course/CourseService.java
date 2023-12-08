package ee.valiit.yummy.domain.recipe.course;

import ee.valiit.yummy.domain.recipe.Recipe;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Resource
    private CourseRepository courseRepository;

    public Course getCourseById(Integer courseId) {
        return courseRepository.getReferenceById(courseId);
    }
}
