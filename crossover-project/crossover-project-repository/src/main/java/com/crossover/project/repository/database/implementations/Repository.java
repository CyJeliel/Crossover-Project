package com.crossover.project.repository.database.implementations;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.crossover.project.repository.interfaces.core.IRepository;
import com.crossover.project.repository.mapper.entities.core.InterfaceEntity;
import com.crossover.project.repository.mapper.interfaces.IMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Repository<T extends InterfaceEntity<?>, U> implements IRepository<U> {

	private static final long serialVersionUID = 1L;

	private transient Class<T> clazz;

	private transient IMapper<T, U> mapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Repository(IMapper<T, U> mapper) {

		this.clazz = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

		this.mapper = mapper;

	}

	public EntityManager getEntityManager() {

		return Persistence.createEntityManagerFactory("com.crossover.project").createEntityManager();
	}

	@Override
	public void add(U entityDomain) {

		T entity = mapper.domainToEntity(entityDomain);

		getEntityManager().persist(entity);
	}

	@Override
	public void update(U entityDomain) {

		T entity = mapper.domainToEntity(entityDomain);

		getEntityManager().merge(entity);
	}

	@Override
	public void delete(U entity) {

		getEntityManager().remove(entity);
	}

	@Override
	public void delete(Serializable id) {

		T t = getEntityManager().find(clazz, id);

		getEntityManager().remove(t);
	}

	@Override
	public U getById(long id) {

		return mapper.entityToDomain(getEntityManager().find(clazz, id));
	}

	@Override
	public U getById(String id) {

		return mapper.entityToDomain(getEntityManager().find(clazz, id));
	}

	@Override
	public U get(String namedQuery, Map<String, Object> map) {

		Collection<U> entities = getMany(namedQuery, map);

		U entityToDomain = null;

		if (!entities.isEmpty() && entities.size() == 1) {

			entityToDomain = entities.stream().findFirst().orElse(null);
		}

		return entityToDomain;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<U> getAll() {

		return getEntityManager().createNamedQuery(clazz.getSimpleName() + ".listar").getResultList();
	}

	@Override
	public Collection<U> getMany(String namedQuery, Map<String, Object> map) {

		List<T> list = buildQuery(namedQuery, map).getResultList();

		Collection<U> collection = new ArrayList<>();

		for (T t : list) {

			collection.add(mapper.entityToDomain(t));
		}

		return collection;

	}

	/**
	 * Creates a TypedQuery from the named query associated to the entity and
	 * loads Map parameters.
	 *
	 * @param <T>
	 *            Type of entity's class.
	 * @param clazz
	 *            entity's class
	 * @param namedQuery
	 *            Named query to construct TypedQuery
	 * @param map
	 *            Map with parameters
	 * @return TypedQuery related to the Entity
	 */
	protected TypedQuery<T> buildQuery(String namedQuery, Map<String, Object> map) {

		TypedQuery<T> typed = getEntityManager().createNamedQuery(namedQuery, clazz);

		if (typed == null) {

			log.error("__¢ query not found: {}", namedQuery);

			return null;
		}

		Set<Parameter<?>> paramSet = typed.getParameters();

		if (!paramSet.isEmpty() && map == null) {

			log.error("__¢ no room (map) for paramSet.size: {}", paramSet.size());

			return null;
		}

		for (Iterator<Parameter<?>> iter = paramSet.iterator(); iter.hasNext();) {

			buildParameters(map, typed, iter);
		}

		log.debug("__¢ typedQuery: {}", typed);

		return typed;
	}

	private void buildParameters(Map<String, Object> map, TypedQuery<T> typed, Iterator<Parameter<?>> iter) {

		Parameter<?> param = iter.next();

		String paramName = param.getName();

		log.debug("___¢ paramName: {}", paramName);

		if (!map.containsKey(paramName)) {

			log.error("__¢ parameter {} not found in Map.", paramName);

			return;
		}

		Object obj = map.get(paramName);

		if (!param.getParameterType().isAssignableFrom(obj.getClass())) {

			log.error("__¢ paramName '{}' is '{}' but i need '{}'", paramName, obj.getClass().getName(),
					param.getParameterType().getName());

			return;
		}

		typed.setParameter(paramName, map.get(paramName));
	}

}