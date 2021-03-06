package com.shrikantchine.aggregation;

import java.util.HashMap;
import java.util.function.Function;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.util.Assert;

public class GenericAggregationStrategy<T extends Object> implements AggregationStrategy {
	
	private T startObject;
	private Predicate currentPredicate;
	private HashMap<Predicate, Function<Exchange, T>> predicateToFunctionMap;
	
	public GenericAggregationStrategy<T> startWith(T startObject) {
		this.startObject = startObject;
		return this;
	}
	
	public GenericAggregationStrategy<T> condition(Predicate predicate) {
		Assert.notNull(predicate, "Predicate cannot be null");
		Assert.isNull(currentPredicate, "Please provide processor after predicate");
		this.currentPredicate = predicate;
		return this;
	}
	
	public GenericAggregationStrategy<T> process(Function<Exchange, T> processor) {
		Assert.notNull(currentPredicate, "Please provide condition before processor");
		Assert.notNull(processor, "Processor cannot be null");
		
		if (predicateToFunctionMap == null) new HashMap<>();
		this.predicateToFunctionMap.put(currentPredicate, processor);
		this.currentPredicate = null;
		return this;
	}
	

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
	
		
		return null;
	}

}
