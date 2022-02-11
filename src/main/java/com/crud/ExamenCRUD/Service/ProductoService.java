package com.crud.ExamenCRUD.Service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.crud.ExamenCRUD.Entity.Producto;

public interface ProductoService {
	
	public Iterable<Producto> findAll();
	public Page<Producto> findAll(Pageable pageable);
	public Optional<Producto> findById(Long codigo);
    public Producto save(Producto producto);
    public void deleteById (long codigo);
}
