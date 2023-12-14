package ee.valiit.yummy.business.tag;

import ee.valiit.yummy.domain.recipe.tag.Tag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagsController {

    @Resource
    private TagsService tagsService;

    @GetMapping("/tags")
    @Operation(summary = "tagastab kõik andmebaasis olevad tagid")
    public List<TagDto> getAllTags() {
        return tagsService.getAllTags();
    }
}
