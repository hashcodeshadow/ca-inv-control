/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.renap.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "activoinformatica", path = "activoinformatica")

public interface ActivoInformatica extends PagingAndSortingRepository<ActivoInformatica, Integer> {
    

}

