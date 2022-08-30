package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                ListStorageTest.class,
                SortedArrayStorageTest.class,
                MapUuidStorageTest.class,
                MapResumeStorageTest.class,
                ObjectFileStorageTest.class,
                ObjectPathStorageTest.class,
                XmlPathStorageTest.class,
                JsonPathStorageTest.class,
                DataPathStorageTest.class,
                SqlStorageTest.class
        })
public class AllStorageTest {
}
