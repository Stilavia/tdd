package org.stilavia.tdd;


import java.util.*;

/**
 * PackageTree represents a package and all its sub packages.
 *
 * name property is the package name with no precedence of its parent package, so if the canonical package name
 * is "org.stilavia.tdd" then the name is just "tdd", the parent package name "org.stilavia" is not included
 * because a PackageTree would be a child of another PackageTree that would have this information.
 * ChildrenPackages are all the children packages that belongs to this package.
 * For example, given these packages:
 *      - org.stilavia.data
 *      - org.stilavia.app
 *
 * The package "org" would have as name "org" and as child "stilavia".
 * The package "org.stilavia" would have as name "stilavia" and as children "data" and "app".
 *
 *
 */
public class PackageTree {

    private final String name;

    private final Set<PackageTree> packageTrees;

    /**
     * Builds a new PackageTree object with the given name and child package trees.
     * @param name Package name, not null, without parent package name.
     * @param packageTrees Set of children package trees.
     */
    public PackageTree(String name, Set<PackageTree> packageTrees) {
        throw new UnsupportedOperationException("org.stilavia.tdd.PackageTree.PackageTree");
    }

    /**
     * Returns the name of the package as is.
     *
     * @return Name of the package.
     */
    public String name() {
        throw new UnsupportedOperationException("org.stilavia.tdd.PackageTree.name");
    }

    /**
     * Returns the children package trees.
     *
     * @return Children pacakge trees.
     */
    public Set<PackageTree> childrenPackages() {
        throw new UnsupportedOperationException("org.stilavia.tdd.PackageTree.childrenPackages");
    }

    /**
     * Returns the name as string representation.
     *
     * @return Name as string representation.
     */
    public String toString() {
        return name;
    }

    /**
     * Equals based on name attribute. That is because two packages with equal name within the same parent package
     * are equals. Consider that test package equality on packages that does not share parent should be always false
     * but since this object does not hold parent package information this can not be tested here. Therefore this
     * equal method only applies for packages with shared parent.
     *
     * @param o PackageTree object.
     * @return True if this and that have the same name.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageTree that = (PackageTree) o;

        return name.equals(that.name);

    }

    /**
     * Hash code delegated to name attribute.
     *
     * @return Hash code of package name.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Given a set of packages by string name returns the set of
     * packages tree.
     *
     * For example, given "org.stilavia" and "java.lang" the outcome would be:
     *
     *      org
     *      +-- stilavia
     *      java
     *      +-- lang
     *
     * Where "org" would be one package tree of the returning set containing "stilavia" as child package tree and
     * "java" would be one another package tree of the returning set containing "lang" as child package tree.
     * @param packages Packages names as string.
     * @return Set of Packages trees of the given packages names.
     */
    public static Set<PackageTree> of(Set<String> packages) {
        throw new UnsupportedOperationException("org.stilavia.tdd.PackageTree.of");
    }

}
