package ee.valiit.yummy.domain.recipe.course;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Resource
    private CourseRepository courseRepository;

    public Course findCourseBy(Integer courseId) {
        return courseRepository.getReferenceById(courseId);
    }

    public Course getCourseBy(Integer courseId) {
        return courseRepository.getReferenceById(courseId);
    }

    public Course getCourseNameById(Integer courseId) {
        return courseRepository.getReferenceById(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}

