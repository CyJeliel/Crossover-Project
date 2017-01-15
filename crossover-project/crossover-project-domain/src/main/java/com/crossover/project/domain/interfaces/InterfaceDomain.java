package com.crossover.project.domain.interfaces;

import java.io.Serializable;

public interface InterfaceDomain<T extends Serializable> extends Serializable {

	T getId();

	void setId(T id);

}
