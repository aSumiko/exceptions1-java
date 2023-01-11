package model.exceptions;

public class DomainException extends RuntimeException {

	/**
	 //poderia ser RunTimeException, assim mesmo não havendo try/cacht o compilador não iria reclamar
	//a classe que extends de Exception precisa ser serializada, pois seus objetos podem ser convertidos em bytes e trafegados atraves de arquivos
	 */
	private static final long serialVersionUID = 1L; 
	
	public DomainException(String msg) {
		super(msg);
	}

}
