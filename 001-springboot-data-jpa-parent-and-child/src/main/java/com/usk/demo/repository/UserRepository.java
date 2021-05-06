package com.usk.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByFirstName(String firstName); 
	
	List<User> findByFirstNameContains(String firstName); 
	
	List<User> findByFirstNameAndLastName(String firstName, String lastName);
	
	/*
	 * @Query("from User where firstName=:firstName and lastName=:lastName")
	 * List<User> getUserByNames(String firstName, String lastName);
	 */
	
	@Query(value = "select u.* from user u where u.first_name=:firstName and u.last_name = :lastName", nativeQuery = true)
	List<User> getUserByNames(String firstName, String lastName);
	
	List<User> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<User> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);

	List<User> findByFirstNameContainsOrLastNameContainsOrderByAgeAsc(String firstName, String lastName);

	List<User> findByFirstNameContainsOrLastNameContainsOrderByFirstNameAsc(String firstName,
			String lastName);

	List<User> findByFirstNameContains(String firstName, Pageable pageable);

	List<User> findByFirstNameContainsOrLastNameContainsOrderByFirstNameAsc(String firstName, String lastName,
			Pageable pageable);
	
	@Query("select new com.usk.demo.dto.UserResponseDto(firstName, count(*)) from User where firstName=:firstName")
	List<UserResponseDto> getCustomUsers(@Param("firstName") String firstName);

}