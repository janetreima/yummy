package ee.valiit.yummy.domain.recipe.allergen;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergenRepository extends JpaRepository<Allergen, Integer> {
}