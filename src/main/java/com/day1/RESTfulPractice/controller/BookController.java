package com.day1.RESTfulPractice.controller;

import com.day1.RESTfulPractice.application.service.BookService;
import com.day1.RESTfulPractice.controller.dto.request.BookRequest;
import com.day1.RESTfulPractice.controller.dto.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public Page<BookResponse> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort.split(","))); //problemas con el sort
        return bookService.getAllBooks(pageable);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Validated @RequestBody BookRequest bookRequest) {
        BookResponse bookResponse = bookService.createBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookRequest));
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }
}




    //validaciones (OK)
    //manejo de excepciones (comunes (OK) y de validaciones (OK), falta aplicar las de Goytia que utilizan ErrorResponse)
    //test unitarios (domingo) ok al martes recien (errores de groovy y mock, solucionado)

    //regex(ok) y oauth2 (pendiente)

    //Flyway y migraciones (ok en todas las tablas)
    //Query de insert o seed (miercoles)



    //falta pagination (ok) y filtros (jueves)
    //aplicar Lazy (ok) y Eager (jueves)
    // lógica de negocio (jueves) (agregar logica para aprovechar el sistema de alquiler, filtrar y ordenar, generar un reporte de ganancia y ganancia por dia)
    //aplicar query en los Repository (jueves)


    //Clase Mapper al DTO (migrarlo para ahorrar codigo) (martes)
    //Many to Many, One to One (sabado)

    //factory, singleton, command y adapter (miercoles si llego)

    //Complejizar la logica de negocios (agregando lista de alquileres en libreria, N a N)
    //falta pathvariable(ok) validation(ok), requestParam(ok), restTemplate entre otros
    //crud completo (post, get, get all, patch, update, delete, soft delete)
    //exportar a excel
    //prueba de integracion (en postman, ejecutar diferentes endpoints para visualizar como funciona)
    //selenium y cypress para testear una aplicacion simulando ser el front end (test end to end)

    //ver default list para Repository (esto creo que lucho no lo explico)
