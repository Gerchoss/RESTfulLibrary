package com.day1.RESTfulPractice.controller;

import com.day1.RESTfulPractice.application.service.BookService;
import com.day1.RESTfulPractice.controller.dto.request.BookRequest;
import com.day1.RESTfulPractice.controller.dto.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    //implements Pageable in service first
    @GetMapping
    public List<BookResponse> getAllBooks() {
        return (List<BookResponse>) bookService.getAllBooks();
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
    //test unitarios (domingo) ok al martes recien (errores de groovy y mock)

    //regex y oauth2 (en el trabajo)

    //Flyway y migraciones (miercoles)
    //Query de insert o seed (miercoles)



    //falta pagination y filtros (jueves)
    //aplicar Lazy y Eager (jueves)
    // lógica de negocio (jueves)
    //aplicar query en los Repository (jueves)


    //Clase Mapper al DTO (migrarlo para ahorrar codigo) (martes)
    //Many to Many, One to One (sabado)

    //factory, singleton, command y adapter (miercoles si llego)

    //Complejizar la logica de negocios
    //falta pathvariable(ok) validation(ok), requestParam, restTemplate entre otros
    //crud completo (post, get, get all, patch, update, delete, soft delete)
    //exportar a excel
    //prueba de integracion (en postman, ejecutar diferentes endpoints para visualizar como funciona)
    //selenium y cypress para testear una aplicacion simulando ser el front end (test end to end)

    //ver default list para Repository (esto creo que lucho no lo explico)
