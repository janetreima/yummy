package ee.valiit.yummy.business.tag;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.yummy.domain.recipe.tag.Tag}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto implements Serializable {
    private Integer tagId;
    private String tagName;
}