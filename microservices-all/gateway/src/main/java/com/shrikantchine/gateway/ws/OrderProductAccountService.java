package com.shrikantchine.gateway.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.shrikantchine.models.OrderProductAccountRequest;
import com.shrikantchine.models.OrderProductAccountResponse;


@WebService(name="OrderProductAccountService", targetNamespace="http://shrikantchine.com/soap/OrderProductAccountService/v1")
@SOAPBinding(parameterStyle=ParameterStyle.BARE, style=Style.DOCUMENT, use=Use.LITERAL)
public interface OrderProductAccountService {

	@WebMethod
	@WebResult(name="OrderProductAccountResponse", targetNamespace="http://shrikantchine.com/soap/OrderProductAccountService/v1")
	public OrderProductAccountResponse getOrderProductAccounts(
			@WebParam(name = "OrderProductAccountRequest", targetNamespace = "http://shrikantchine.com/soap/OrderProductAccountService/v1")
			OrderProductAccountRequest request);
	
}
