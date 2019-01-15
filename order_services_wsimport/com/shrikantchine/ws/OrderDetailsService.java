
package com.shrikantchine.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.shrikantchine.soap.orderdetailsservice.v1.ObjectFactory;
import com.shrikantchine.soap.orderdetailsservice.v1.OrderDetailsRequest;
import com.shrikantchine.soap.orderdetailsservice.v1.OrderDetailsResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OrderDetailsService", targetNamespace = "http://shrikantchine.com/soap/OrderDetailsService/v1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OrderDetailsService {


    /**
     * 
     * @param orderDetailsRequest
     * @return
     *     returns com.shrikantchine.soap.orderdetailsservice.v1.OrderDetailsResponse
     */
    @WebMethod
    @WebResult(name = "getOrderDetailsResponse", targetNamespace = "http://shrikantchine.com/soap/OrderDetailsService/v1", partName = "getOrderDetailsResponse")
    public OrderDetailsResponse getOrderDetails(
        @WebParam(name = "OrderDetailsRequest", targetNamespace = "http://shrikantchine.com/soap/OrderDetailsService/v1", partName = "OrderDetailsRequest")
        OrderDetailsRequest orderDetailsRequest);

}
