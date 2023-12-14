package ee.valiit.yummy.business.tag;

import ee.valiit.yummy.domain.recipe.tag.Tag;
import ee.valiit.yummy.domain.recipe.tag.TagMapper;
import ee.valiit.yummy.domain.recipe.tag.TagService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsService {


    @Resource
    private TagService tagService;

    @Resource
    private TagMapper tagMapper;

    public List<TagDto> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        return tagMapper.toTagDtos(tags);
    }
}
