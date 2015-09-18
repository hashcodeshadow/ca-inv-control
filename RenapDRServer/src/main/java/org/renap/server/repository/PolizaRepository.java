/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.renap.server.repository;

import org.renap.orm.activosorm.Poliza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "poliza", path = "poliza")
//@EnableJpaRepositories(value = {"cn.com.taiji.repository"}, includeFilters = @ComponentScan.Filter(JpaRepo.class))
//public interface CarrierMasterRepository extends PagingAndSortingRepository<CarrierMaster, Long> {
//public interface PolizaRepository extends CrudRepository<Poliza, Integer> {
public interface PolizaRepository extends PagingAndSortingRepository<Poliza, Integer> {
    

}

