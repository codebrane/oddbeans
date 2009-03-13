package net.opendd.entity;

import org.junit.Test;

import net.opendd.Entity;
import net.opendd.OddDocument;
import net.opendd.Metadata;
import net.opendd.Relationship;
import net.opendd.OddDocument.Odd;

/**
 * ODD test
 *
 * @author Alistair Young alistair@codebrane.com
 */
public class ODDEntityTest extends EntityTest {
  @Test
  public void test() {
  	OddDocument oddDoc = OddDocument.Factory.newInstance();
  	Odd odd = oddDoc.addNewOdd();
    odd.setVersion(ODD_VERSION);

    Entity testEntity = odd.addNewEntity();
    testEntity.setUuid("http://www.opendd.net/entity/test");
    testEntity.setClass1("Test");

  	Entity unitTestEntity = odd.addNewEntity();
  	unitTestEntity.setUuid("http://www.opendd.net/entity/unittest");
    unitTestEntity.setClass1("UnitTest");

    Metadata metadata = odd.addNewMetadata();
    metadata.setUuid("http://www.opendd.net/metadata/unittest/testName");
    metadata.setEntityUuid(testEntity.getUuid());
    metadata.setName("testName");
    metadata.setStringValue("EntityTest");

    Relationship relationship = odd.addNewRelationship();
    relationship.setUuidOne(unitTestEntity.getUuid());
    relationship.setType("http://www.opendd.net/types/is-a");
    relationship.setUuidTwo(testEntity.getUuid());
  }
}
