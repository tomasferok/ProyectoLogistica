
package com.log.app.daos;
import com.log.app.entidades.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


@Component
public interface  IVentasDao extends MongoRepository<Venta, Long> {
    
}
