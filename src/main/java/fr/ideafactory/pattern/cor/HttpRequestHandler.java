package fr.ideafactory.pattern.cor;

import fr.ideafactory.pattern.exceptions.NoHttpHandlerException;
import fr.ideafactory.pattern.exceptions.ProtocolNotHandledException;
import fr.ideafactory.pattern.exceptions.VerbNotAllowedException;

public abstract class HttpRequestHandler implements HttpRequestHandlerInterface {
	private HttpRequestHandlerInterface nextHandler;

	@Override
	public HttpRequestHandlerInterface next(HttpRequestHandlerInterface handler) {
		this.nextHandler = handler;
		return this;
	}

	@Override
	public HttpRequestHandlerInterface handle(HttpRequest request) throws NoHttpHandlerException, ProtocolNotHandledException, VerbNotAllowedException {
		if (this.nextHandler != null) {
			return this.nextHandler.handle(request);
		}
		throw new NoHttpHandlerException();
	}

}
