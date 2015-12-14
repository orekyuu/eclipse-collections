/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.sorted.immutable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import net.jcip.annotations.Immutable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.SortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.sortedbag.ImmutableSortedBagMultimap;
import org.eclipse.collections.api.ordered.OrderedIterable;
import org.eclipse.collections.api.partition.bag.sorted.PartitionImmutableSortedBag;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.EmptyIterator;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.SortedBags;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimap;
import org.eclipse.collections.impl.partition.bag.sorted.PartitionImmutableSortedBagImpl;
import org.eclipse.collections.impl.partition.bag.sorted.PartitionTreeBag;
import org.eclipse.collections.impl.utility.OrderedIterate;

@Immutable
class ImmutableEmptySortedBag<T>
        extends AbstractImmutableSortedBag<T>
        implements Serializable
{
    static final ImmutableSortedBag<?> INSTANCE = new ImmutableEmptySortedBag<Object>();

    private static final long serialVersionUID = 1L;
    private final Comparator<? super T> comparator;

    private ImmutableEmptySortedBag()
    {
        this.comparator = null;
    }

    ImmutableEmptySortedBag(Comparator<? super T> comparator)
    {
        this.comparator = comparator;
    }

    public ImmutableSortedBag<T> newWith(T element)
    {
        return SortedBags.immutable.with(this.comparator, element);
    }

    public ImmutableSortedBag<T> newWithAll(Iterable<? extends T> elements)
    {
        return SortedBags.immutable.withAll(this.comparator, elements);
    }

    public ImmutableSortedBag<T> newWithout(T element)
    {
        return this;
    }

    public ImmutableSortedBag<T> newWithoutAll(Iterable<? extends T> elements)
    {
        return this;
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == this)
        {
            return true;
        }
        return other instanceof Bag && ((Collection<?>) other).isEmpty();
    }

    @Override
    public int hashCode()
    {
        return 0;
    }

    public void forEachWithOccurrences(ObjectIntProcedure<? super T> procedure)
    {
    }

    public int sizeDistinct()
    {
        return 0;
    }

    public int size()
    {
        return 0;
    }

    @Override
    public <V> ImmutableList<V> collect(Function<? super T, ? extends V> function)
    {
        return Lists.immutable.empty();
    }

    @Override
    public ImmutableSortedBag<T> select(Predicate<? super T> predicate)
    {
        return this;
    }

    @Override
    public ImmutableSortedBag<T> reject(Predicate<? super T> predicate)
    {
        return this;
    }

    @Override
    public <P> ImmutableSortedBag<T> selectWith(Predicate2<? super T, ? super P> predicate, P parameter)
    {
        return this;
    }

    @Override
    public <P> ImmutableSortedBag<T> rejectWith(Predicate2<? super T, ? super P> predicate, P parameter)
    {
        return this;
    }

    @Override
    public <S> ImmutableSortedBag<S> selectInstancesOf(Class<S> clazz)
    {
        return (ImmutableSortedBag<S>) this;
    }

    public <V> ImmutableSortedBagMultimap<V, T> groupBy(Function<? super T, ? extends V> function)
    {
        return TreeBagMultimap.<V, T>newMultimap(this.comparator).toImmutable();
    }

    public <V> ImmutableSortedBagMultimap<V, T> groupByEach(Function<? super T, ? extends Iterable<V>> function)
    {
        return TreeBagMultimap.<V, T>newMultimap(this.comparator).toImmutable();
    }

    public <V> ImmutableMap<V, T> groupByUniqueKey(Function<? super T, ? extends V> function)
    {
        return Maps.immutable.empty();
    }

    @Override
    public boolean contains(Object object)
    {
        if (object == null)
        {
            throw new NullPointerException();
        }
        return false;
    }

    @Override
    public ImmutableSortedBag<T> tap(Procedure<? super T> procedure)
    {
        return this;
    }

    @Override
    public ImmutableSortedBag<T> selectByOccurrences(IntPredicate predicate)
    {
        return this;
    }

    public <S> boolean corresponds(OrderedIterable<S> other, Predicate2<? super T, ? super S> predicate)
    {
        return OrderedIterate.corresponds(this, other, predicate);
    }

    public void forEach(int startIndex, int endIndex, Procedure<? super T> procedure)
    {
    }

    public void each(Procedure<? super T> procedure)
    {
    }

    public void forEachWithIndex(int fromIndex, int toIndex, ObjectIntProcedure<? super T> objectIntProcedure)
    {
    }

    @Override
    public <P> void forEachWith(Procedure2<? super T, ? super P> procedure, P parameter)
    {
    }

    public int occurrencesOf(Object item)
    {
        return 0;
    }

    public Iterator<T> iterator()
    {
        return EmptyIterator.getInstance();
    }

    @Override
    public T min(Comparator<? super T> comparator)
    {
        throw new NoSuchElementException();
    }

    @Override
    public T max(Comparator<? super T> comparator)
    {
        throw new NoSuchElementException();
    }

    @Override
    public T min()
    {
        throw new NoSuchElementException();
    }

    @Override
    public T max()
    {
        throw new NoSuchElementException();
    }

    @Override
    public <V extends Comparable<? super V>> T minBy(Function<? super T, ? extends V> function)
    {
        throw new NoSuchElementException();
    }

    @Override
    public <V extends Comparable<? super V>> T maxBy(Function<? super T, ? extends V> function)
    {
        throw new NoSuchElementException();
    }

    public Comparator<? super T> comparator()
    {
        return this.comparator;
    }

    @Override
    public ImmutableSortedSet<Pair<T, Integer>> zipWithIndex()
    {
        return SortedSets.immutable.with((Comparator<? super Pair<T, Integer>>) this.comparator);
    }

    public PartitionImmutableSortedBag<T> partitionWhile(Predicate<? super T> predicate)
    {
        return new PartitionImmutableSortedBagImpl<T>(new PartitionTreeBag<T>(this.comparator()));
    }

    public ImmutableSortedSet<T> distinct()
    {
        return SortedSets.immutable.with(this.comparator);
    }

    public T getFirst()
    {
        return null;
    }

    public T getLast()
    {
        return null;
    }

    public ImmutableSortedBag<T> takeWhile(Predicate<? super T> predicate)
    {
        return this;
    }

    public ImmutableSortedBag<T> dropWhile(Predicate<? super T> predicate)
    {
        return this;
    }

    public int detectIndex(Predicate<? super T> predicate)
    {
        return -1;
    }

    @Override
    public int count(Predicate<? super T> predicate)
    {
        return 0;
    }

    @Override
    public MutableStack<T> toStack()
    {
        return Stacks.mutable.empty();
    }

    public int indexOf(Object object)
    {
        return -1;
    }

    public int compareTo(SortedBag<T> o)
    {
        return o.size() * -1;
    }

    @Override
    public RichIterable<RichIterable<T>> chunk(int size)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("Size for groups must be positive but was: " + size);
        }
        return Lists.immutable.empty();
    }

    public MutableSortedMap<T, Integer> toMapOfItemToCount()
    {
        return SortedMaps.mutable.of(this.comparator);
    }

    public ImmutableSortedBag<T> take(int count)
    {
        if (count < 0)
        {
            throw new IllegalArgumentException("Count must be greater than zero, but was: " + count);
        }
        return this;
    }

    public ImmutableSortedBag<T> drop(int count)
    {
        if (count < 0)
        {
            throw new IllegalArgumentException("Count must be greater than zero, but was: " + count);
        }
        return this;
    }
}