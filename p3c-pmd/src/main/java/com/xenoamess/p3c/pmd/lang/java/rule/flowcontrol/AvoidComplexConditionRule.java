/*
 * Copyright 1999-2017 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xenoamess.p3c.pmd.lang.java.rule.flowcontrol;

import com.xenoamess.p3c.pmd.lang.AbstractAliXpathRule;
import com.xenoamess.p3c.pmd.lang.java.util.ViolationUtils;
import net.sourceforge.pmd.lang.ast.Node;

/**
 * [Mandatory] Do not use complicated statements in conditional statements (except for frequently used methods
 * like getXxx/isXxx). Use boolean variables to store results of complicated statements temporarily will increase
 * the code's readability.
 *
 * @author zenghou.fw
 * @date 2017/04/11
 */
public class AvoidComplexConditionRule extends AbstractAliXpathRule {
    private static final String XPATH = "(//IfStatement/Expression"
            + "|//ConditionalExpression/PrimaryExpression)"
            + "[count(.//ConditionalAndExpression) + count(.//ConditionalOrExpression) > 1]";

    public AvoidComplexConditionRule() {
        setXPath(XPATH);
    }

    @Override
    public void addViolation(Object data, Node node, String arg) {
        ViolationUtils.addViolationWithPrecisePosition(this, node, data,
                "java.flowcontrol.AvoidComplexConditionRule.violation.msg");
    }
}
