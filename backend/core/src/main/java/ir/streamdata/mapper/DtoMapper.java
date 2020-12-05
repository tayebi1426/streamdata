package ir.streamdata.mapper;

public interface DtoMapper<D, E> {
    E convertToEntity(D d);
}
