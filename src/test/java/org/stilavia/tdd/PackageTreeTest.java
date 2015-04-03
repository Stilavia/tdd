package org.stilavia.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
/**
 * Created by guillermoblascojimenez on 03/04/15.
 */
public class PackageTreeTest {

    @Test
    public void simple() {
        String p = "org.stilavia.tdd";
        Set<PackageTree> packageTrees = PackageTree.of(Collections.singleton(p));

        assertNotNull(packageTrees);
        assertEquals(packageTrees.size(), 1);
        PackageTree firstLevelPackages = packageTrees.iterator().next();
        assertNotNull(firstLevelPackages);
        assertEquals(firstLevelPackages.name(), "org");
        Set<PackageTree> secondLevelPackages = firstLevelPackages.childrenPackages();
        assertNotNull(secondLevelPackages);
        assertEquals(secondLevelPackages.size(), 1);
        PackageTree secondLevelPackage = secondLevelPackages.iterator().next();
        assertNotNull(secondLevelPackage);
        assertEquals(secondLevelPackage.name(), "stilavia");
        Set<PackageTree> thirdLevelPackages = secondLevelPackage.childrenPackages();
        assertNotNull(thirdLevelPackages);
        assertEquals(thirdLevelPackages.size(), 1);
        PackageTree thirdLevelPackage = thirdLevelPackages.iterator().next();
        assertNotNull(thirdLevelPackage);
        assertEquals(thirdLevelPackage.name(), "tdd");
        Set<PackageTree> forthLevelPackages = thirdLevelPackage.childrenPackages();
        assertNotNull(forthLevelPackages);
        assertEquals(forthLevelPackages.size(), 0);

    }

    @Test
    public void multiple() {

        // define input

        Set<String> packages = new HashSet<>();
        packages.add("org.stilavia.data.api");
        packages.add("org.stilavia.data.mybatis");
        packages.add("org.stilavia.model");
        packages.add("org.stilavia.app");
        packages.add("org.stilavia.app.controller");
        packages.add("org.stilavia.app.service");
        packages.add("java.awt.event");
        packages.add("java.lang");
        packages.add("java.util");

        // execute task

        Set<PackageTree> packageTrees = PackageTree.of(packages);

        // assert data structure

        assertNotNull(packageTrees);
        assertEquals(packageTrees.size(), 2);
        Map<String, PackageTree> byName = byName(packageTrees);
        assertTrue(byName.containsKey("org"));
        assertTrue(byName.containsKey("java"));
        PackageTree javaPackageTree = byName.get("java");
        assertEquals(javaPackageTree.childrenPackages().size(), 3);
        Map<String, PackageTree> javaPackagesByName = byName(javaPackageTree.childrenPackages());
        assertTrue(javaPackagesByName.containsKey("lang"));
        assertEquals(javaPackagesByName.get("lang").childrenPackages().size(), 0);
        assertTrue(javaPackagesByName.containsKey("util"));
        assertEquals(javaPackagesByName.get("util").childrenPackages().size(), 0);
        assertTrue(javaPackagesByName.containsKey("awt"));
        PackageTree javaAwtPackageTree = javaPackagesByName.get("awt");
        assertEquals(javaAwtPackageTree.childrenPackages().size(), 1);
        PackageTree javaAwtPackageTrees = javaAwtPackageTree.childrenPackages().iterator().next();
        assertEquals(javaAwtPackageTrees.name(), "event");
        assertEquals(javaAwtPackageTrees.childrenPackages().size(), 0);
        PackageTree orgPackageTree = byName.get("org");
        assertEquals(orgPackageTree.childrenPackages().size(), 1);
        PackageTree stilaviaPackageTrees = orgPackageTree.childrenPackages().iterator().next();
        Map<String, PackageTree> stilaviaByName = byName(stilaviaPackageTrees.childrenPackages());
        assertTrue(stilaviaByName.containsKey("data"));
        assertTrue(stilaviaByName.containsKey("model"));
        assertTrue(stilaviaByName.containsKey("app"));
        assertEquals(stilaviaByName.get("model").childrenPackages().size(), 0);
        Map<String, PackageTree> dataByName = byName(stilaviaByName.get("data").childrenPackages());
        assertTrue(dataByName.containsKey("api"));
        assertTrue(dataByName.containsKey("mybatis"));
        assertEquals(dataByName.get("api").childrenPackages().size(), 0);
        assertEquals(dataByName.get("mybatis").childrenPackages().size(), 0);
        Map<String, PackageTree> appByName = byName(stilaviaByName.get("app").childrenPackages());
        assertTrue(appByName.containsKey("controller"));
        assertTrue(appByName.containsKey("service"));
        assertEquals(appByName.get("controller").childrenPackages().size(), 0);
        assertEquals(appByName.get("service").childrenPackages().size(), 0);
    }

    private static Map<String, PackageTree> byName(Set<PackageTree> packageTrees) {
        Map<String, PackageTree> map = new HashMap<>();
        for (PackageTree packageTree : packageTrees) {
            map.put(packageTree.name(), packageTree);
        }
        return map;
    }

}
