package ee.valiit.yummy.domain.recipe.allergen;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AllergenRepository extends JpaRepository<Allergen, Integer> {

}