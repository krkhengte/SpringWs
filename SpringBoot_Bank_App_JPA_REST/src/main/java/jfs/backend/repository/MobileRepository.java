
package jfs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jfs.backend.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}
