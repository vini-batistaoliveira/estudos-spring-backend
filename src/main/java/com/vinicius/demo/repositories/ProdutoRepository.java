package com.vinicius.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinicius.demo.domain.Categoria;
import com.vinicius.demo.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias ")
	Page<Produto> findDistinctByNomeContainingCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	//Com o @Param ele passa o parametro do método no named parameter da query
	//Também é possivel usar a criação automatica de metodo do JPA dando o nome de
	//findDistinctByNomeContainingCategoriasIn assim se torna desnecessário escrever a minha query em cima
	//*****VINICIUS SEU MERDA, Leia a documentação do SPRING DATA JPA*******
	//Se colocar o @QUERY, ele vai sobrepor o que o jpa fez e vai utilizar a query do jeito que eu escrevi
	//Com a anotação @Query, não é preciso implementar essa interface para usar
}
