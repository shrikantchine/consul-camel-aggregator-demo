
package com.shrikantchine.soap.orderdetailsservice.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.shrikantchine.soap.orderdetailsservice.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OrderDetailsRequest_QNAME = new QName("http://shrikantchine.com/soap/OrderDetailsService/v1", "OrderDetailsRequest");
    private final static QName _GetOrderDetailsResponse_QNAME = new QName("http://shrikantchine.com/soap/OrderDetailsService/v1", "getOrderDetailsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.shrikantchine.soap.orderdetailsservice.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderDetailsRequest }
     * 
     */
    public OrderDetailsRequest createOrderDetailsRequest() {
        return new OrderDetailsRequest();
    }

    /**
     * Create an instance of {@link OrderDetailsResponse }
     * 
     */
    public OrderDetailsResponse createOrderDetailsResponse() {
        return new OrderDetailsResponse();
    }

    /**
     * Create an instance of {@link OrderItem }
     * 
     */
    public OrderItem createOrderItem() {
        return new OrderItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDetailsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrderDetailsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://shrikantchine.com/soap/OrderDetailsService/v1", name = "OrderDetailsRequest")
    public JAXBElement<OrderDetailsRequest> createOrderDetailsRequest(OrderDetailsRequest value) {
        return new JAXBElement<OrderDetailsRequest>(_OrderDetailsRequest_QNAME, OrderDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrderDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://shrikantchine.com/soap/OrderDetailsService/v1", name = "getOrderDetailsResponse")
    public JAXBElement<OrderDetailsResponse> createGetOrderDetailsResponse(OrderDetailsResponse value) {
        return new JAXBElement<OrderDetailsResponse>(_GetOrderDetailsResponse_QNAME, OrderDetailsResponse.class, null, value);
    }

}
