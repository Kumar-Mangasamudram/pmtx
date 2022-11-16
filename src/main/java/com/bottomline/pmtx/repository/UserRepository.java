package com.bottomline.pmtx.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.bottomline.pmtx.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User getByName(String name);

	User getByEmail(String email);

	List<User> findAllByRole(String role);

	User getById(long id);

}