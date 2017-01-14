/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.repository.mapper.entities.core;

import java.io.Serializable;

/**
 *
 * @author Cindy
 */
public interface InterfaceEntity<T extends Serializable> extends Serializable {

	T getId();

	void setId(T pId);
}
