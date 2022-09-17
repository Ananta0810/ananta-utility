package ananta.utility;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Ananta0810
 * This class provides some common methods related to set
 * such as creation, getting, checking,...
 * Most methods can handle NULL input well and return empty set instead of NULL.
 */
public final class ASet {
    
    private ASet() {}
    
    /**
     * Get the size of a set.
     * @param set can be null.
     * @return 0 if set is null. Otherwise, return its size.
     */
    public static int sizeOf(@Nullable final Set<?> set) {
        return ACollection.sizeOf(set);
    }
    
    /**
     * Check if a set is empty or not.
     * @param set can be null.
     * @return true if set is null or is empty. Otherwise, return false.
     */
    public static boolean isEmpty(@Nullable final Set<?> set) {
        return ACollection.isEmpty(set);
    }
    
    /**
     * Check if a set is not empty.
     * @param set can be null.
     * @return true if set has items. Otherwise, return false.
     */
    public static boolean isNotEmpty(@Nullable final Set<?> set) {
        return ACollection.isNotEmpty(set);
    }
    
    /**
     * @return a modifiable empty set.
     */
    @NotNull
    public static <T> Set<T> emptySet() {
        return new HashSet<>();
    }
    
    /**
     * @return a modifiable empty linked set.
     */
    @NotNull
    public static <T> Set<T> emptyLinkedSet() {
        return new LinkedHashSet<>();
    }
    
    /**
     * @return a modifiable empty tree set.
     */
    @NotNull
    public static <T> Set<T> emptyTreeSet() {
        return new TreeSet<>();
    }
    
    /**
     * @return a modifiable set that contains all input value.
     */
    @SafeVarargs
    @NotNull
    public static <T> Set<T> setOf(@Nullable final T... items) {
        return new HashSet<>(Arrays.asList(items));
    }
    
    /**
     * Get all items of other collections and put it into a set.
     * @return a modifiable set that contains all items of other collection.
     */
    @NotNull
    public static <T> Set<T> setOf(@Nullable final Collection<T> collection) {
        return ACollection.isEmpty(collection) ? emptySet() : new HashSet<>(collection);
    }
    
    /**
     * @return a modifiable set that contains all non-null input value.
     */
    @SafeVarargs
    @NotNull
    public static <T> Set<T> nonNullSetOf(@Nullable final T... items) {
        return Arrays.stream(items).filter(Objects::nonNull).collect(Collectors.toSet());
    }
    
    /**
     * Get all non-null items of other collections and put it into a set.
     * @return a modifiable set that contains all non-null items of other collection.
     */
    @NotNull
    public static <T> Set<T> nonNullSetOf(@Nullable final Collection<T> collection) {
        return ACollection.isEmpty(collection)
            ? emptySet()
            : collection.stream().filter(Objects::nonNull).collect(Collectors.toSet());
    }
    
    /**
     * @param collection can be null.
     * @return If collection is null then return empty list.
     * If collection is a set, return itself.
     * Otherwise, return set that contains all items of collection
     */
    @NotNull
    public static <T> Set<T> emptySetIfNull(@Nullable final Collection<T> collection) {
        if (collection == null) {
            return emptySet();
        }
        if (collection instanceof Set<?>) {
            return (Set<T>) collection;
        }
        return setOf(collection);
    }
    
    /**
     * @return a modifiable linked set that contains all input value.
     */
    @SafeVarargs
    @NotNull
    public static <T> Set<T> linkedSetOf(@Nullable final T... items) {
        return new LinkedHashSet<>(Arrays.asList(items));
    }
    
    /**
     * Get all items of other collections and put it into a linked set.
     * @return a modifiable set that contains all items of other collection.
     */
    @NotNull
    public static <T> Set<T> linkedSetOf(@Nullable final Collection<T> collection) {
        return ACollection.isEmpty(collection) ? emptyLinkedSet() : new LinkedHashSet<>(collection);
    }
    
    /**
     * @return a modifiable linked set that contains all input value.
     */
    @SafeVarargs
    @NotNull
    public static <T> Set<T> nonNullLinkedSetOf(@Nullable final T... items) {
        return linkedSetOf(AList.nonNullListOf(items));
    }
    
    /**
     * Get all items of other collections and put it into a linked set.
     * @return a modifiable set that contains all items of other collection.
     */
    @NotNull
    public static <T> Set<T> nonNullLinkedSetOf(@Nullable final Collection<T> collection) {
        return linkedSetOf(AList.nonNullListOf(collection));
    }
    
    /**
     * @return a modifiable tree set that contains all input value.
     */
    @SafeVarargs
    @NotNull
    public static <T> Set<T> treeSetOf(@Nullable final T... items) {
        return new TreeSet<>(Arrays.asList(items));
    }
    
    /**
     * Get all items of other collections and put it into a tree set.
     * @return a modifiable tree set that contains all items of other collection.
     */
    @NotNull
    public static <T> Set<T> treeSetOf(@Nullable final Collection<T> collection) {
        return ACollection.isEmpty(collection) ? emptyTreeSet() : new TreeSet<>(collection);
    }
    
    /**
     * @return a modifiable tree set that contains all input value.
     */
    @SafeVarargs
    @NotNull
    public static <T> Set<T> nonNullTreeSetOf(@Nullable final T... items) {
        return treeSetOf(AList.nonNullListOf(items));
    }
    
    /**
     * Get all items of other collections and put it into a tree set.
     * @return a modifiable tree set that contains all items of other collection.
     */
    @NotNull
    public static <T> Set<T> nonNullTreeSetOf(@Nullable final Collection<T> collection) {
        return treeSetOf(AList.nonNullListOf(collection));
    }
    
}
