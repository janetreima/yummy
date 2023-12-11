package ee.valiit.yummy.business.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.yummy.domain.recipe.course.Course}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfo implements Serializable {
    private Integer courseId;
    private String courseName;
    private Boolean isAvailable;
}