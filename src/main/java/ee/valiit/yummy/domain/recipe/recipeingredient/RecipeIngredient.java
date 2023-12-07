package ee.valiit.yummy.domain.recipe.recipeingredient;

import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.ingredient.Ingredient;
import ee.valiit.yummy.domain.recipe.measureunit.MeasureUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "recipe_ingredient", schema = "project")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "measure_unit_id", nullable = false)
    private MeasureUnit measureUnit;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

}