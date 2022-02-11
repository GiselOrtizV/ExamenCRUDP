package com.crud.ExamenCRUD.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.ExamenCRUD.Entity.Producto;
import com.crud.ExamenCRUD.Repository.ProductoRepository;



@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly =true)
	public Iterable<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public Page<Producto> findAll(Pageable pageable) {
		return productoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly =true)
	public Optional<Producto> findById(Long codigo) {
		return productoRepository.findById(codigo);
		
	}

	@Override
	@Transactional(readOnly =true)
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
		
	}

	@Override
	@Transactional(readOnly =true)
	public void deleteById(long codigo) {
		productoRepository.deleteById(codigo);
		
	}
	 
	

}
