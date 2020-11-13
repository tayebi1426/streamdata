package ir.streamdata.mapper;

public interface EntityMapper<E, D> {

    D convertToDto(E e);
}
