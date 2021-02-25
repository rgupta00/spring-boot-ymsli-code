package com.bookapp;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepo extends JpaRepository<Book,Long>{
	
	//public List<Book>getAll();
	
	@Query(value = "select * from b_table", nativeQuery = true)
	public List<Book> getAllBooks1Native();
	
	@Query("select b from Book b")
	public List<Book> getAllBooks1();
	
	@Query("select b from Book b where pageCount >= ?1 and price =?2")
	public List<Book> getAllBooksPageCountGreater(int pageCount, double price);
	
	
	@Query("select b from Book b where price >= :price and pageCount=:pageCount")
	public List<Book> getAllBooksPriceGreterEquals(@Param("price")double price,
			@Param("pageCount")int pageCount);

	
	
	public List<Book> findByTitle(String title);
	
	public List<Book> findByTitleLike(String title);

	public List<Book> findByTitleContaining(String title);
	//give me all book with page count bw a and b
	public List<Book> findByPageCountBetween(int a, int b);
	
	public List<Book> findByPublishDateBetween(Date a, Date b);
	public List<Book> findTop2ByOrderByPriceDesc();
}
