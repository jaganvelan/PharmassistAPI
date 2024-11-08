package com.example.pharmassist.PharmassistApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.PharmassistApi.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {

//	@Query("SELECT m FROM Medicine m WHERE LOWER(m.medicineName) LIKE %:keyword% OR LOWER(m.ingredients) LIKE %:keyword%")
//	    List<Medicine> findByMedicineNameOrIngredients(@Param("keyword") String keyword);

	
	// if you use this method findByMedicineNameLikeOrIngredientsLike spring boot can automatically implements the sql query 
	List<Medicine> findByMedicineNameLikeIgnoreCaseOrIngredientsLikeIgnoreCase(String medicineName,String ingredients);

}
