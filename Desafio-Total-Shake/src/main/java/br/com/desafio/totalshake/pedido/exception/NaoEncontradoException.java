package br.com.desafio.totalshake.pedido.exception;

public class NaoEncontradoException extends Throwable{

    public NaoEncontradoException(String message){
        super(message);
    }

    public NaoEncontradoException(){
        super("Item não encontrado.");
    }
}
