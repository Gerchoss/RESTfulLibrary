package com.day1.RESTfulPractice.controller.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import org.springframework.data.domain.Page;

import java.util.function.Function;
import java.util.stream.Collectors;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Builder
public class PageResponse <R>{
    private List<R> content;
    private Long totalElements;
    private Integer size;
    private Integer number;
    private Integer totalPages;

    public <T, R> PageResponse<R> from (Page<T> page, Function<? super T, ? extends R> mapper){
        List<R> content = page.getContent()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());

        return PageResponse.<R>builder()
                .content(content)
                .totalElements(page.getTotalElements())
                .size(page.getSize())
                .number(page.getNumber())
                .totalPages(page.getTotalPages())
                .build();
    }

}
