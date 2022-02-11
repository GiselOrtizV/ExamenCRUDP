package com.crud.ExamenCRUD.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.ExamenCRUD.Entity.Producto;
import com.crud.ExamenCRUD.Service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	//CREAR NUEVO PRODUCTO
		@PostMapping
		public ResponseEntity<?> create (@RequestBody Producto producto){
			return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
		}
		
		//READ AN PRODUCTO
		@GetMapping("/{codigo}")
		public ResponseEntity<?> read (@PathVariable(value = "codigo") Long codigoP){
			Optional<Producto> oProducto = productoService.findById(codigoP);
			
			if(!oProducto.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(oProducto);
		}
		
		//ACTUALIZAR PRODUCTO
		@PutMapping("/{codigo}")
		public ResponseEntity<?> update (@RequestBody Producto productoDetails, @PathVariable (value = "codigo") Long codigoP){
		Optional<Producto> producto = productoService.findById(codigoP);
		 if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		 }
		 
		 producto.get().setDescripcion(productoDetails.getDescripcion());
		 producto.get().setPrecio(productoDetails.getPrecio());
		 producto.get().setCatidad(productoDetails.getCatidad());
		 //producto.get().setCompra(productoDetails.getCompra());

		 
		 return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
	    }
		
		//ELIMINAR  PRODUCTO
		@DeleteMapping("/{codigo}")
		public ResponseEntity<?> delete (@PathVariable(value = "codigo") Long codigoP){
			if(!productoService.findById(codigoP).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			productoService.deleteById(codigoP);
			return ResponseEntity.ok().build();
		}
		
		//MOSTRAR PRODUCTOS
		@GetMapping
		public List<Producto> readAll(){
			List<Producto> productos = StreamSupport
					.stream(productoService.findAll().spliterator(), false)
					.collect(Collectors.toList());
			return productos;
		}
		

}
