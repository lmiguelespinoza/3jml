package pe.j3ml.app.vo;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import pe.j3ml.app.model.*;

@XmlRootElement(name = "response")

public class PedidoCollection {
    private Collection<CPedido> pedidos;
    
    public PedidoCollection() {
    }

    public PedidoCollection(Collection<CPedido> pedidos) {
        this.pedidos = pedidos;
    }

    @XmlElement(name="pedido")
    @XmlElementWrapper(name="pedidos")
    public Collection<CPedido> getPedidos() {
        return pedidos;
    }
}