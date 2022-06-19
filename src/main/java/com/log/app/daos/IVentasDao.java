
package com.log.app.daos;
import com.log.app.entidades.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  IVentasDao extends MongoRepository<Venta, Long> {
    
}
