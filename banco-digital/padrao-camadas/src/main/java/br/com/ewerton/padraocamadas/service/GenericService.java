package br.com.ewerton.padraocamadas.service;

public interface GenericService<T, ID> {

    T consultar(ID id);

    T depositar(T entity);

    T enviar(T valor);

}
