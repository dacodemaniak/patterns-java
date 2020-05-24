package fr.ideafactory.pattern.cor;

import fr.ideafactory.pattern.exceptions.NoHttpHandlerException;
import fr.ideafactory.pattern.exceptions.ProtocolNotHandledException;
import fr.ideafactory.pattern.exceptions.VerbNotAllowedException;

public class ProtocolHandler extends HttpRequestHandler {

	public ProtocolHandler() {
		// TODO Auto-generated constructor stub
	}

	public HttpRequestHandlerInterface handle(HttpRequest request) throws ProtocolNotHandledException, NoHttpHandlerException, VerbNotAllowedException {
		if (request.protocol.equals("https")) {
			return super.handle(request);
		}
		throw new ProtocolNotHandledException();
	}
}
