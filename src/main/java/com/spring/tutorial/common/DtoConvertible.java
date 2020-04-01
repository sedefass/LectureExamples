package com.spring.tutorial.common;

/**
 * This interface exposes functionality for converting the concrete object to some DTO.
 *
 * @param <DtoT> the DTO type to which we can convert the concrete object.
 */
public interface DtoConvertible<DtoT> {
    DtoT toDto();
}
