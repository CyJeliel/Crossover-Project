package com.crossover.project.domain.interfaces.core;

import java.io.Serializable;

public interface InterfaceDomain<T extends Serializable> extends Serializable {

	T getId();

	void setId(T id);

}
