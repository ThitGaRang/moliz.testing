package org.modelexecution.fumltesting.core.assertions;

import java.util.List;

import org.modelexecution.fumltesting.core.results.OrderAssertionResult;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.OrderAssertion;
import org.modelexecution.fumltesting.core.trace.TraceUtil;

public abstract class OrderAssertionValidator {
	protected TraceUtil traceUtil;
	protected OrderUtil orderUtil;

	public OrderAssertionValidator(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
		this.orderUtil = new OrderUtil();
	}

	protected OrderAssertionResult prepareResult(List<NodeSpecification> nodes, OrderAssertionValidationType validationType) {
		OrderAssertionResult result = new OrderAssertionResult(nodes, validationType);
		return result;
	}

	public abstract OrderAssertionResult checkOrder(OrderAssertion assertion);
}