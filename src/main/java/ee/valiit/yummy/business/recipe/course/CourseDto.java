package ee.valiit.yummy.business.recipe.course;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class CourseDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
}