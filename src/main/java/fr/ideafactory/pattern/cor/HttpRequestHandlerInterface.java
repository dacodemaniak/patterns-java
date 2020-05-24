package fr.ideafactory.pattern.cor;

import fr.ideafactory.pattern.exceptions.NoHttpHandlerException;
import fr.ideafactory.pattern.exceptions.ProtocolNotHandledException;
import fr.ideafactory.pattern.exceptions.VerbNotAllowedException;

public interface HttpRequestHandlerInterface {
	public HttpRequestHandlerInterface next(HttpRequestHandlerInterface handler);
	public HttpRequestHandlerInterface handle(HttpRequest request) throws NoHttpHandlerException, ProtocolNotHandledException, VerbNotAllowedException;
}
