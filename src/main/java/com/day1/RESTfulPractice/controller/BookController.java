package com.day1.RESTfulPractice.controller;

import com.day1.RESTfulPractice.application.service.BookService;
import com.day1.RESTfulPractice.controller.dto.request.BookRequest;
import com.day1.RESTfulPractice.controller.dto.response.BookResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping
    public Page<BookResponse> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort.split(","))); //problemas con el sort
        log.info("Executing get all books with page {}", page);
        return bookService.getAllBooks(pageable);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Validated @RequestBody BookRequest bookRequest) {
        BookResponse bookResponse = bookService.createBook(bookRequest);
        log.info("Executing create book with this parameters{}", bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookRequest));
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        log.info("Executing search book with this id{}", id);
        return bookService.getBook(id);
    }
}




    //validaciones (OK)
    //manejo de excepciones (comunes (OK) y de validaciones (OK), falta aplicar las de Goytia que utilizan ErrorResponse)
    //test unitarios (ok) (errores de groovy y mock, solucionado)

    //regex(ok)

    //Flyway y migraciones (ok)
    //Query de insert o seed (ok)
    //Logs (ok)
    //pagination (ok)




    //filtros (martes)
    //Clase Mapper al DTO (migrarlo para ahorrar codigo) (martes)
    //oauth2 (martes)


    // lógica de negocio (miercoles) (agregar logica para aprovechar el sistema de alquiler, filtrar y ordenar, generar un reporte de ganancia y ganancia por dia)
    //factory, singleton, command y adapter (miercoles si llego)
    //oauth2 (miercoles)


    //aplicar Lazy (ok) y Eager (jueves)
    //aplicar query en los Repository (jueves)


    //Mas test (sabado)
    //Many to Many, One to One (sabado)
    //falta pathvariable(ok) validation(ok), requestParam(ok), restTemplate entre otros (sabado)

    //Complejizar la logica de negocios (agregando lista de alquileres en libreria, N a N) (domingo)
    //Mas test (domingo)
    //Mas excepciones (domingo)

    //crud completo para cada parte necesaria (post, get, get all, patch, update, delete, soft delete) (lunes)

    //Mas test (martes)

    //prueba de integracion (en postman, ejecutar diferentes endpoints para visualizar como funciona) (miercoles

    //exportar a excel (jueves)



    //selenium y cypress para testear una aplicacion simulando ser el front end (test end to end)

    //ver default list para Repository (esto creo que lucho no lo explico)
