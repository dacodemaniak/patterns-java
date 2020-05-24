package fr.ideafactory.pattern.cor;

import fr.ideafactory.pattern.exceptions.VerbNotAllowedException;

public class VerbHandler extends HttpRequestHandler {

	public VerbHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public HttpRequestHandlerInterface handle(HttpRequest request) throws VerbNotAllowedException {
		if (request.verb.contentEquals("get") || request.verb.contentEquals("post")) {
			// End Point
			this.verb = request.verb;
			this.protocol = request.protocol;
			return this;
		}
		throw new VerbNotAllowedException();
	}

}
