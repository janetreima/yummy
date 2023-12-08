package ee.valiit.yummy.domain.recipe.course;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Resource
    private CourseRepository courseRepository;

    public Course findCourseBy(Integer courseId) {
        return courseRepository.getReferenceById(courseId);
    }
}
