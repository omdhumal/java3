package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User getByCustomeremail(String username);
	
	

    
	@Modifying
	@Query("update User u set u.customername=:customername, u.contactno=:contactno where u.customerid=:customerid")
	void UpdateByid(@Param("customername") String username, @Param("contactno") long contactNo, @Param("customerid") int id ) ;


	
	}
