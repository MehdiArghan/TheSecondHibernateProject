package base.repository;

import base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<ID extends Serializable, Entity extends BaseEntity<ID>> {
    void save(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

    Optional<Entity> findById(ID id);

    List<Entity> loadAll();
}
