/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.renap.server.repository;

import org.renap.orm.activosorm.Libro;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "libro", path = "libro")
public interface LibroRepository extends CrudRepository<Libro, Integer> {
    
}
