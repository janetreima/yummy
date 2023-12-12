package ee.valiit.yummy.business.recipe.course;

import ee.valiit.yummy.business.recipe.dto.CourseInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursesController {

    @Resource
    private CoursesService coursesService;

    @GetMapping("recipe/courses")
    @Operation(summary = "Tagastab kõik käigud")
    public List<CourseInfo> getAllCourses() {
        return coursesService.getAllCourses();
    }

}
