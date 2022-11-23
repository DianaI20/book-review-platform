package com.example.bookreviewplatform.mapper;


public interface ObjectMapper<T,S> {

    T convertFromDTO(S s);
    S convertToDTO(T t);
}
