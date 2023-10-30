package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.TransactionException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BaseServiceImpl<ID extends Serializable, Entity extends BaseEntity<ID>
        , REPOSITORY extends BaseRepository<ID, Entity>> implements BaseService<ID, Entity> {
    protected final Session session;
    protected final REPOSITORY repository;

    @Override
    public void save(Entity entity) {
        try {
            session.getTransaction().begin();
            repository.save(entity);
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(Entity entity) {
        try {
            session.getTransaction().begin();
            repository.update(entity);
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Entity entity) {
        try {
            session.getTransaction().begin();
            repository.delete(entity);
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public Optional<Entity> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<Entity> loadAll() {
        return repository.loadAll();
    }
}
