package base.repository.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<ID extends Serializable, Entity extends BaseEntity<ID>>
        implements BaseRepository<ID, Entity> {
    protected final Session session;

    public BaseRepositoryImpl(Session session) {
        this.session = session;
    }

    public abstract Class<Entity> getEntityClass();

    @Override
    public void save(Entity entity) {
        session.persist(entity);
    }

    @Override
    public void update(Entity entity) {
        session.merge(entity);
    }

    @Override
    public void delete(Entity entity) {
        session.remove(entity);
    }

    @Override
    public Optional<Entity> findById(ID id) {
        return Optional.ofNullable(session.find(getEntityClass(), id));
    }

    @Override
    public List<Entity> loadAll() {
        return session.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }
}
