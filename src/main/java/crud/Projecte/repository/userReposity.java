package crud.Projecte.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import crud.Projecte.model.TabelaModel;

@Repository
public interface userReposity extends CrudRepository<TabelaModel, Long> {


    List< TabelaModel > findAll();
}
